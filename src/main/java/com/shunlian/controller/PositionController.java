package com.shunlian.controller;

import com.shunlian.entity.Position;
import com.shunlian.entity.Transactions;
import com.shunlian.service.PositionService;
import com.shunlian.service.TransactionsService;
import com.shunlian.utils.CalUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class PositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    @Autowired
    private PositionService positionService;
    @Autowired
    private TransactionsService transactionsService;


    @GetMapping("/selectList")
    public List<Position> selectList() {
        List<Position> list = null;
        try {
            list = positionService.selectList();
            if (CollectionUtils.isEmpty(list)) {
                LOGGER.error("==position do not have data");
                return null;
            }

            LOGGER.info("==position list.size():{}", list.size());

        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }

        return list;
    }


    @PostMapping("/insert1111")
    public int insert1111(@RequestParam Map<String, Object> map1) {

        int n = 0;
        try {

            //【1】全部查出来
            List<Transactions> list1 = new ArrayList<Transactions>();
            List<Transactions> list2 = new ArrayList<Transactions>();
            List<Transactions> list3 = new ArrayList<Transactions>();
            List<Transactions> list = transactionsService.selectListTransactions();

            //【2】根据SecurityCode分组
            //List里面的对象元素，以某个属性来分组，例如，以SecurityCode分组，将SecurityCode相同的放在一起
            Map<String, List<Transactions>> map2 = list.stream().collect(Collectors.groupingBy(Transactions::getSecurityCode));
            list1 = map2.get("REL");
            list2 = map2.get("ITC");
            list3 = map2.get("INF");

            //【3】遍历，根据Buy/Sell 的标记，判断是加号+，还是减号-
            int sum1 = calSum(list1);
            String securityCode = "REL";
            int quantity = sum1;
            LOGGER.info("==list1==securityCode:{},quantity:{}", securityCode, quantity);
            int n1 = positionService.insert1("REL", sum1);

            int sum2 = calSum(list2);
            String securityCode2 = "ITC";
            int quantity2 = sum2;
            LOGGER.info("==list2==securityCode2:{},quantity2:{}", securityCode2, quantity2);
            int n2 = positionService.insert1("ITC", sum2);

            int sum3 = calSum(list3);
            String securityCode3 = "INF";
            int quantity3 = sum3;
            LOGGER.info("==list3==securityCode3:{},quantity3:{}", securityCode3, quantity3);
            int n3 = positionService.insert1("INF", sum3);

            n = n1 + n2 + n3;
        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return n;
    }

    public int calSum(List<Transactions> list) {
        int sum = 0;

        for (Transactions tran1 : list) {
            if (tran1.getBuySellType().equalsIgnoreCase("Buy")) {
                int a = tran1.getQuantity();
                switch (tran1.getOperationType()) {
                    case "INSERT":
                        //add
                        sum = CalUtil.binaryAdd(sum, a);
                        break;
                    case "UPDATE":
                        //update current
                        sum = a;
                        break;
                    case "CANCEL":
                        //update 0
                        sum = 0;
                        break;
                }

            } else if (tran1.getBuySellType().equalsIgnoreCase("Sell")) {
                int a = -(tran1.getQuantity());
                switch (tran1.getOperationType()) {
                    case "INSERT":
                        //add
                        sum = CalUtil.binaryAdd(sum, a);
                        break;
                    case "UPDATE":
                        //update current
                        sum = a;
                        break;
                    case "CANCEL":
                        //update 0
                        sum = 0;
                        break;
                }
            }

        }
        return sum;
    }


}
