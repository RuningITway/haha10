package com.shunlian.service.impl;

import com.shunlian.entity.Employee;
import com.shunlian.mapper.EmployeeRep;
import com.shunlian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *
 * tip: only for hj test , ignore
 *
 *
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRep employeeRep;


    @Override
    public List<Employee> findAll() {
        return employeeRep.findAll();
    }

    @Override
    public Employee findObj(int id) throws Exception {
        return employeeRep.findObj(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRep.save(employee);
    }

    @Override
    public int insert1(String name) throws Exception {
        return employeeRep.insert1(name);
    }

    @Override
    public void update(Employee employee) {
        employeeRep.save(employee);
    }

    @Override
    public int update1(String name, long id) throws Exception {
        return employeeRep.update1(name, id);
    }


    @Override
    public void delete(Long id) {
        employeeRep.delete(id);
    }


    @Override
    public int delete1(long id) throws Exception {
        return employeeRep.delete1(id);
    }


}
