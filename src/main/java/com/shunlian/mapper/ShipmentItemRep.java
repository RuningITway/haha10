package com.shunlian.mapper;


import com.shunlian.entity.ShipmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShipmentItemRep extends JpaRepository<ShipmentItem, Long> {


    @Transactional
    @Modifying
    @Query(value = "delete Shipment_item where id=?1", nativeQuery = true)
    public int delete1(int id) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "insert into Shipment_Item(shipment_Id,p_Id,p_Name,p_Quanty,p_type) values(?1,?2,?3,?4,?5)", nativeQuery = true)
    public int insert1(int shipmentId, String pId, String pName, String pQuanty, String pType) throws Exception;


    @Query(value = "select id,p_id,p_name,p_quanty,p_type,shipment_id from Shipment_Item order by id asc", nativeQuery = true)
    public List<ShipmentItem> selectListResult() throws Exception;

}