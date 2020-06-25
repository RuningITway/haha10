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
    private static final String SECURITY_CODE_REL = "REL";
    private static final String SECURITY_CODE_ITC = "ITC";
    private static final String SECURITY_CODE_INF = "INF";



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
    public void insert1111(@RequestParam Map<String, Object> map1) {


        try {

            //【1】全部查出来
            List<Transactions> list1 = new ArrayList<Transactions>();
            List<Transactions> list2 = new ArrayList<Transactions>();
            List<Transactions> list3 = new ArrayList<Transactions>();
            List<Transactions> list = transactionsService.selectListTransactions();

            //【2】根据SecurityCode分组
            //List里面的对象元素，以某个属性来分组，以SecurityCode分组，将SecurityCode相同的放在一起
            Map<String, List<Transactions>> map2 = list.stream().collect(Collectors.groupingBy(Transactions::getSecurityCode));
            list1 = map2.get(SECURITY_CODE_REL);
            list2 = map2.get(SECURITY_CODE_ITC);
            list3 = map2.get(SECURITY_CODE_INF);


            //【3】遍历，根据Buy/Sell 的标记，判断是加号+，还是减号-
            //【4】根据Insert/Update/Cancel 标记，判断计算规则
            //【5】把动态计算的结果保存到 Position 表
            calSum(list1, SECURITY_CODE_REL);
            calSum(list2, SECURITY_CODE_ITC);
            calSum(list3, SECURITY_CODE_INF);



        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }

    }


    public void calSum(List<Transactions> list, String securityCode) throws Exception {
        int sum = 0;

        //calculate
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

        //operation table
        Position position1 = positionService.selectObjectBySc(securityCode);
        if (null != position1) {
            //update
            positionService.update1(sum, securityCode);
        } else {
            //insert
            positionService.insert1(securityCode, sum);
        }

    }


}
