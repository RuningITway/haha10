package com.shunlian.service.impl;

import com.shunlian.mapper.ShipmentItemRep;
import com.shunlian.service.ShipmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "shipmentItemService")
public class ShipmentItemServiceImpl implements ShipmentItemService {

    @Autowired
    private ShipmentItemRep shipmentItemRep;


    @Override
    public int insert1(int shipmentId, String pId, String pName, String pQuanty, String pType) throws Exception {
        return shipmentItemRep.insert1(shipmentId, pId, pName, pQuanty, pType);
    }

    @Override
    public List<Integer> findItemId(String pId) throws Exception {
        return shipmentItemRep.findItemId(pId);
    }

    @Override
    public int delete1(int id) throws Exception {
        return shipmentItemRep.delete1(id);
    }


}
