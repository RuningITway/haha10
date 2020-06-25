package com.shunlian.service;

import com.shunlian.entity.Position;

import java.util.List;

public interface PositionService {

    public int insert1(String securityCode, int quantity) throws Exception;

    public List<Position> selectList() throws Exception;

    public Position selectObjectBySc(String securityCode) throws Exception;

    public int update1(int quantity, String securityCode) throws Exception;


}

