package com.shunlian.service;

import com.shunlian.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/***
 *
 * tip: only for hj test , ignore
 *
 *
 */
public interface EmployeeService {


    public List<Employee> findAll();

    public void save(@RequestBody Employee employee);

    public void update(@RequestBody Employee employee);

    public void delete(@PathVariable Long id);


    public Employee findObj(int id) throws Exception;

    public int insert1(String name) throws Exception;

    public int update1(String name, long id) throws Exception;

    public int delete1(long id) throws Exception;


}

