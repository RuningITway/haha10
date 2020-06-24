package com.shunlian.entity;/**
 * description: Employee <br>
 * date: 2020/6/25 10:42 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
