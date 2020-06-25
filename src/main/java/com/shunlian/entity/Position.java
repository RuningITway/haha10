package com.shunlian.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;//1,2,3,4,5,6

    private String securityCode;//REL,ITC,INF
    private int quantity;//


}
