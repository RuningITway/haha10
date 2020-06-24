package com.shunlian.service.impl;

import com.shunlian.entity.Employee;
import com.shunlian.mapper.EmployeeRep;
import com.shunlian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRep employeeRep;


    @Override
    public List<Employee> findAll() {
        return employeeRep.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRep.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRep.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRep.delete(id);
    }
}
