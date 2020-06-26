package com.shunlian.service;

public interface ShipmentService {

    public int delete1(int id) throws Exception;

    /***
     * setShipmentData
     * 设置船运管理运输数据
     * @param pId
     * @param pName
     * @param pQuanty
     * @return
     * @throws Exception
     */
    public int insert1(String pId, String pName, String pQuanty) throws Exception;

    public int findId(String pId, String pName, String pQuanty) throws Exception;


}

