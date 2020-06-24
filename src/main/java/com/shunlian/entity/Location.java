package com.shunlian.entity;/**
 * description: Location <br>
 * date: 2020/6/24 23:10 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double latitude;
    private double longtitude;
}