package com.shunlian.controller;/**
 * description: HelloContraller <br>
 * date: 2020/6/24 23:12 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

import com.shunlian.entity.Location;
import com.shunlian.mapper.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloContraller {

    @Autowired
    private LocationRepository locationRepository;

    @ResponseBody
    @RequestMapping("/hello")
    public List<Location> hello() {
        return locationRepository.findAll();
    }
}
