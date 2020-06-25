package com.shunlian.mapper;


import com.shunlian.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ShipmentRep extends JpaRepository<Shipment, Long> {


    @Transactional
    @Modifying
    @Query(value = "delete Shipment where id=?1", nativeQuery = true)
    public int delete1(int id) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "insert into Shipment(p_Id,p_Name,p_Quanty) values(?1,?2,?3)", nativeQuery = true)
    public int insert1(String pId, String pName, String pQuanty) throws Exception;


    //select id from shipment where p_id ='aa' and p_name ='aa' and  p_quanty ='100' order by id desc limit 1


    @Query(value = "select id from shipment where p_id =?1 and p_name =?2 and  p_quanty =?3 order by id desc limit 1", nativeQuery = true)
    public int findId(String pId, String pName, String pQuanty) throws Exception;

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


}