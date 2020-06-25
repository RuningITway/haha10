package com.shunlian.controller;

import com.shunlian.entity.Position;
import com.shunlian.service.PositionService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class PositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    @Autowired
    private PositionService positionService;


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

            LOGGER.info("==input map1:{}", map1.toString());

            String securityCode = MapUtils.getString(map1, "securityCode", "REL");
            int quantity = MapUtils.getInteger(map1, "quantity", 0);

            n = positionService.insert1(securityCode, quantity);

        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return n;
    }


}
