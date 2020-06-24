package com.shunlian.controller;/**
 * description: EmployeeController <br>
 * date: 2020/6/25 10:42 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

import com.shunlian.entity.Employee;
import com.shunlian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> findAll() {
        return employeeService.findAll();
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

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        employeeService.delete(id);
        return Boolean.TRUE;
    }


}
