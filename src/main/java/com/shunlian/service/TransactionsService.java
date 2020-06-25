package com.shunlian.service;

import com.shunlian.entity.Transactions;

import java.util.List;

public interface TransactionsService {

    public int insert1(int tradeID, int version, String securityCode, int quantity, String operationType, String buySellType) throws Exception;

    public List<Transactions> selectListTransactions() throws Exception;


}

