package com.shunlian.service;

import com.shunlian.entity.ShipmentItem;

import java.util.List;

public interface ShipmentItemService {

    public int insert1(int shipmentId, String pId, String pName, String pQuanty, String pType) throws Exception;

    public int delete1(int id) throws Exception;

    public List<ShipmentItem> selectListResult() throws Exception;


}

