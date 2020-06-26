package com.shunlian.mapper;

/**
 * description: EmployeeRep <br>
 * date: 2020/6/25 10:43 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */

import com.shunlian.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/***
 *
 * tip: only for hj test , ignore
 *
 *
 */
public interface EmployeeRep extends JpaRepository<Employee, Long> {

    /***
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Query(value = "select * from Employee  where id = ?1", nativeQuery = true)
    public Employee findObj(int id) throws Exception;


    @Transactional
    @Modifying
    @Query(value = "update Employee u set u.name = ?1 where u.id = ?2", nativeQuery = true)
    int update1(String name, long id) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "insert into Employee(name) values(?1)", nativeQuery = true)
    int insert1(String name) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "delete Employee where id=?1", nativeQuery = true)
    public int delete1(long id) throws Exception;


}