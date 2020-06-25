package com.shunlian.service;

import java.util.List;

public interface ShipmentItemService {

    public int insert1(int shipmentId, String pId, String pName, String pQuanty, String pType) throws Exception;

    public List<Integer> findItemId(String pId) throws Exception;

    public int delete1(int id) throws Exception;


}

