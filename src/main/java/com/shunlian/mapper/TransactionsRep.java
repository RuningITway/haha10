package com.shunlian.mapper;


import com.shunlian.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionsRep extends JpaRepository<Transactions, Long> {


    @Transactional
    @Modifying
    @Query(value = "insert into Transactions(tradeID,version,security_Code,quantity,operation_Type,buy_Sell_Type) values(?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    public int insert1(int tradeID, int version, String securityCode, int quantity, String operationType, String buySellType) throws Exception;


}