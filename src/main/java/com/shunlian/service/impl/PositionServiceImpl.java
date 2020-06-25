package com.shunlian.service.impl;

import com.shunlian.entity.Position;
import com.shunlian.mapper.PositionRep;
import com.shunlian.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "positionService")
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRep positionRep;


    @Override
    public int insert1(String securityCode, int quantity) throws Exception {
        return positionRep.insert1(securityCode, quantity);
    }

    @Override
    public List<Position> selectList() throws Exception {
        return positionRep.selectList();
    }
}
