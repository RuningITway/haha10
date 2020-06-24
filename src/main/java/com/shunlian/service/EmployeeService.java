package com.shunlian.service;

import com.shunlian.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService {


    public List<Employee> findAll();


    public void save(@RequestBody Employee employee);


    public void update(@RequestBody Employee employee);


    public void delete(@PathVariable Long id);


}

