package com.shunlian.service.impl;

import com.shunlian.entity.Transactions;
import com.shunlian.mapper.TransactionsRep;
import com.shunlian.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "transactionsService")
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRep transactionsRep;


    @Override
    public int insert1(int tradeID, int version, String securityCode, int quantity, String operationType, String buySellType) throws Exception {
        return transactionsRep.insert1(tradeID, version, securityCode, quantity, operationType, buySellType);
    }

    @Override
    public List<Transactions> selectListTransactions() throws Exception {
        return transactionsRep.selectListTransactions();
    }
}
