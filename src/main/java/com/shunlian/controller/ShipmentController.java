package com.shunlian.controller;

import com.shunlian.service.UserService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping(value = "/shipment")
public class ShipmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/split")
    @ResponseBody
    private double split(@RequestParam Map<String, Integer> map1) {

        try {

            //input num from page
            int num1 = MapUtils.getInteger(map1, "num1", 0);

            //split
            double a = num1 * 0.2;
            double b = num1 * 0.3;
            double c = num1 * 0.5;

            //merge
            double d = b + c;

            LOGGER.info("==result:{}", d);

            return d;

        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
            return 0;
        }

    }


}
