package com.shunlian.mapper;


import com.shunlian.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PositionRep extends JpaRepository<Position, Long> {


    @Transactional
    @Modifying
    @Query(value = "insert into Position(security_Code,quantity) values(?1,?2)", nativeQuery = true)
    public int insert1(String securityCode, int quantity) throws Exception;


    @Query(value = "select id,quantity,security_code from Position order by quantity desc", nativeQuery = true)
    public List<Position> selectList() throws Exception;

    @Query(value = "select id,quantity,security_code from Position where security_code =?1  limit 1", nativeQuery = true)
    public Position selectObjectBySc(String securityCode) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "update Position  set quantity=?1 where security_code =?2", nativeQuery = true)
    public int update1(int quantity, String securityCode) throws Exception;


}