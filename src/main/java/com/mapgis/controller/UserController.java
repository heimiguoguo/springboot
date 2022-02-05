package com.mapgis.controller;

import com.mapgis.entity.User;
import com.mapgis.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Song on 2017/2/15.
 * User控制层
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value="/")
    @ResponseBody
    public String hello() {
        return port;
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getPassword();
        else return "null";
    }
}