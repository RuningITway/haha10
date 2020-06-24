package com.shunlian.mapper;

/**
 * description: EmployeeRep <br>
 * date: 2020/6/25 10:43 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

import com.shunlian.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRep extends JpaRepository<Employee, Long> {
}