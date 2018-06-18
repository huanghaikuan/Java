package com.example.Demo.repository;

import com.example.Demo.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserPO, Long> {

    List<UserPO> findUserByName(String name);

    // hql
    @Query("from UserPO u where u.age = :age")
    List<UserPO> findUserByAge(@Param("age") int age);
}
