package com.shunlian.service.impl;

import com.shunlian.mapper.ShipmentRep;
import com.shunlian.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "shipmentService")
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentRep shipmentRep;


    @Override
    public int delete1(int id) throws Exception {
        return shipmentRep.delete1(id);
    }

    @Override
    public int insert1(String pId, String pName, String pQuanty) throws Exception {
        return shipmentRep.insert1(pId, pName, pQuanty);
    }

    @Override
    public int findId(String pId, String pName, String pQuanty) throws Exception {
        return shipmentRep.findId(pId, pName, pQuanty);
    }


}
