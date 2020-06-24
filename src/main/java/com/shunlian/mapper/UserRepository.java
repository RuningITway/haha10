package com.shunlian.mapper;

import com.shunlian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * description: UserRepository <br>
 * date: 2020/6/24 22:56 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
