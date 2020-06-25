package com.shunlian.service;

public interface TransactionsService {

    public int insert1(int tradeID, int version, String securityCode, int quantity, String operationType, String buySellType) throws Exception;


}

