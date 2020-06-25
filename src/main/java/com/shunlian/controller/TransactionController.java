package com.shunlian.controller;

import com.shunlian.service.TransactionsService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionsService transactionsService;


    @PostMapping("/insert111")
    public int insert111(@RequestParam Map<String, Object> map1) {

        int n = 0;
        try {

            LOGGER.info("==input map1:{}", map1.toString());

            int tradeID = MapUtils.getInteger(map1, "tradeID", 0);
            int version = MapUtils.getInteger(map1, "version", 0);
            String securityCode = MapUtils.getString(map1, "securityCode", "REL");
            int quantity = MapUtils.getInteger(map1, "quantity", 0);
            String operationType = MapUtils.getString(map1, "operationType", "Insert");
            String buySellType = MapUtils.getString(map1, "buySellType", "Buy");

            n = transactionsService.insert1(tradeID, version, securityCode, quantity, operationType, buySellType);

        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return n;
    }


}