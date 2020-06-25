package com.shunlian.mapper;


import com.shunlian.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShipmentItemRep extends JpaRepository<Shipment, Long> {


    @Transactional
    @Modifying
    @Query(value = "delete Shipment_item where id=?1", nativeQuery = true)
    public int delete1(int id) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "insert into Shipment_Item(shipment_Id,p_Id,p_Name,p_Quanty,p_type) values(?1,?2,?3,?4,?5)", nativeQuery = true)
    public int insert1(int shipmentId, String pId, String pName, String pQuanty, String pType) throws Exception;


    @Query(value = "select id from Shipment_item where p_id =?1 order by id desc", nativeQuery = true)
    public List<Integer> findItemId(String pId) throws Exception;


//
//    @Query(value = "select * from Employee  where id = ?1", nativeQuery = true)
//    public Employee findObj(int id) throws Exception;
//
//
//    @Transactional
//    @Modifying
//    @Query(value = "update Employee u set u.name = ?1 where u.id = ?2", nativeQuery = true)
//    int update1(String name, long id) throws Exception;
//
//    @Transactional
//    @Modifying
//    @Query(value = "insert into Employee(name) values(?1)", nativeQuery = true)
//    int insert1(String name) throws Exception;
//
//    @Transactional
//    @Modifying
//    @Query(value = "delete Employee where id=?1", nativeQuery = true)
//    public int delete1(long id) throws Exception;


}