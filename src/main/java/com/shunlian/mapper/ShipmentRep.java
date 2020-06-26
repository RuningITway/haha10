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

    /***
     *    setShipmentData
     *   设置船运管理运输数据
     * @param pId
     * @param pName
     * @param pQuanty
     * @return
     * @throws Exception
     */
    @Transactional
    @Modifying
    @Query(value = "insert into Shipment(p_Id,p_Name,p_Quanty) values(?1,?2,?3)", nativeQuery = true)
    public int insert1(String pId, String pName, String pQuanty) throws Exception;



    @Query(value = "select id from shipment where p_id =?1 and p_name =?2 and  p_quanty =?3 order by id desc limit 1", nativeQuery = true)
    public int findId(String pId, String pName, String pQuanty) throws Exception;


}