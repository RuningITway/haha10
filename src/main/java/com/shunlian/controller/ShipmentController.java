package com.shunlian.controller;

import com.shunlian.entity.ShipmentItem;
import com.shunlian.service.ShipmentItemService;
import com.shunlian.service.ShipmentService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class ShipmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private ShipmentItemService shipmentItemService;


    @PostMapping("/setShipmentData")
    public int setShipmentData(@RequestParam Map<String, Object> map1) {

        int n = 0;
        try {

            /******************************* shipment start **************************************/

            String pId = MapUtils.getString(map1, "pId", "");
            String pName = MapUtils.getString(map1, "pName", "");
            String pQuanty = MapUtils.getString(map1, "pQuanty", "");

            n = shipmentService.insert1(pId, pName, pQuanty);

            /******************************* shipment end **************************************/

            /******************************* shipmentItem start **************************************/
            int shipmentId = shipmentService.findId(pId, pName, pQuanty);//shipment primary id

            String pQuanty1 = Integer.parseInt(pQuanty) * 0.2 + "";
            String pQuanty2 = Integer.parseInt(pQuanty) * 0.3 + "";
            String pQuanty3 = Integer.parseInt(pQuanty) * (1 - 0.2 - 0.3) + "";
            String pQuanty4 = Integer.parseInt(pQuanty) * 0.3 + Integer.parseInt(pQuanty) * (1 - 0.2 - 0.3) + "";

            LOGGER.info("pQuanty1={},pQuanty2={},pQuanty3={},pQuanty4={}", pQuanty1, pQuanty2, pQuanty3, pQuanty4);


            shipmentItemService.insert1(shipmentId, pId, pName, pQuanty1, "S");//split
            shipmentItemService.insert1(shipmentId, pId, pName, pQuanty4, "M");//merge

            /******************************* shipmentItem end **************************************/

        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return n;
    }


    @PostMapping("/getShipmentItemResult")
    public List<ShipmentItem> getShipmentItemResult(@RequestParam Map<String, Object> map1) {

        List<ShipmentItem> listResult = new ArrayList<ShipmentItem>();
        try {

            listResult = shipmentItemService.selectListResult();
            if (CollectionUtils.isEmpty(listResult)) {
                LOGGER.error("==获取shipmentItem结果无数据");
                return null;
            }

            LOGGER.error("==listResult.size():{}", listResult.size());

        } catch (Exception e) {
            LOGGER.error("==获取shipmentItem结果错误:{}", e.getMessage(), e);
            return listResult;
        }
        return listResult;
    }



}
