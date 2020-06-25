package com.shunlian.service;

public interface ShipmentService {

    public int delete1(int id) throws Exception;

    public int insert1(String pId, String pName, String pQuanty) throws Exception;

    public int findId(String pId, String pName, String pQuanty) throws Exception;


}

