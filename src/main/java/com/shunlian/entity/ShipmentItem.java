package com.shunlian.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ShipmentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int shipmentId;
    private String pId;
    private String pName;
    private String pQuanty;
    private String pType;
}
