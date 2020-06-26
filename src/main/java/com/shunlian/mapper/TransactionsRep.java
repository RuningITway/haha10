package com.shunlian.mapper;


import com.shunlian.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionsRep extends JpaRepository<Transactions, Long> {


    /***
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
    @Transactional
    @Modifying
    @Query(value = "insert into Transactions(tradeID,version,security_Code,quantity,operation_Type,buy_Sell_Type) values(?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    public int insert1(int tradeID, int version, String securityCode, int quantity, String operationType, String buySellType) throws Exception;


    /***
     * getResultPosition
     *  动态获取交易结果
     * @return
     * @throws Exception
     */
    @Query(value = "select transactionid,tradeid,version,security_code,quantity,operation_type,buy_sell_type from Transactions  order by transactionid asc", nativeQuery = true)
    public List<Transactions> selectListTransactions() throws Exception;


}