package com.shunlian.service;

import com.shunlian.entity.Transactions;

import java.util.List;

public interface TransactionsService {

    /****
     * initTransactionsData
     * 初始化交易数据
     * @param tradeID
     * @param version
     * @param securityCode
     * @param quantity
     * @param operationType
     * @param buySellType
     * @return
     * @throws Exception
     */
    public int insert1(int tradeID, int version, String securityCode, int quantity, String operationType, String buySellType) throws Exception;

    /**
     * getResultPosition
     * 动态获取交易结果
     *
     * @return
     * @throws Exception
     */
    public List<Transactions> selectListTransactions() throws Exception;


}

