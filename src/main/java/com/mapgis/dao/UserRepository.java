package com.mapgis.dao;

import com.mapgis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Song on 2017/2/15.
 * User表操作接口
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select t from User t where t.name = :name")
    User findByUserName(@Param("name") String name);
}