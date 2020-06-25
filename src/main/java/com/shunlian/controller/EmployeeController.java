package com.shunlian.controller;/**
 * description: EmployeeController <br>
 * date: 2020/6/25 10:42 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

import com.shunlian.entity.Employee;
import com.shunlian.service.EmployeeService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/***
 *
 */
@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/findObj")
    public Employee findObj(@RequestParam Map<String, Object> map1) {

        Employee employee = null;
        int id = MapUtils.getInteger(map1, "id", 0);
        try {
            employee = employeeService.findObj(id);
        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return employee;
    }


    @PostMapping("/save")
    public Boolean save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return Boolean.TRUE;
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody Employee employee) {
        employeeService.save(employee);
        return Boolean.TRUE;
    }

    @PostMapping("/update1")
    public int update1(@RequestParam Map<String, Object> map1) {

        String id = MapUtils.getString(map1, "id", "");
        String name = MapUtils.getString(map1, "name", "");
        int n = 0;
        try {
            n = employeeService.update1(name, Long.parseLong(id));
        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return n;
    }

    @PostMapping("/insert1")
    public int insert1(@RequestParam Map<String, Object> map1) {

        String name = MapUtils.getString(map1, "name", "");
        int n = 0;
        try {
            n = employeeService.insert1(name);
        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return n;
    }

    @PostMapping("/delete1")
    public int delete1(@RequestParam Map<String, Object> map1) {

        long id = MapUtils.getLongValue(map1, "id", 0);
        int n = 0;
        try {
            n = employeeService.delete1(id);
        } catch (Exception e) {
            LOGGER.error("==错误:{}", e.getMessage(), e);
        }
        return n;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        employeeService.delete(id);
        return Boolean.TRUE;
    }


}
