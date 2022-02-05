package com.mapgis.service;

import com.mapgis.dao.UserRepository;
import com.mapgis.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Song on 2017/2/15.
 * User业务逻辑
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findUserByName(String name){
        User user = null;
        try{
            user = userRepository.findByUserName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}