package com.xiexing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiexing.entities.Stu;
import com.xiexing.service.IStuService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class StuController {

    @Resource
    private IStuService stuService;
    private Logger logger = Logger.getLogger(this.getClass());

    //注册
    @RequestMapping(value = "/showUser",  produces = "application/json;charset=utf-8")
    public Object postUser(@RequestBody Stu registUser) throws IOException {
        System.out.println(registUser);
        System.out.println(registUser.getName());
        Map<String,Object> msg = new HashMap<>();
        Stu user = stuService.selectUserByName(registUser.getName());
        if (user != null) {
            msg.put("msg","账号已被注册");
            return msg;
        } else {
            boolean flag = stuService.addUser(registUser);
            System.out.println(flag);
            if (flag) {
                msg.put("msg","注册成功");
                return msg;
            } else {
                msg.put("msg","注册失败");
                return msg;
            }

        }

    }

    //登录
    @RequestMapping(value = "/loginUser",produces = "application/json;charset=utf-8")
    public Object loginUser(@RequestBody Stu loginUser){
        Stu user = stuService.selectUserByName(loginUser.getName());
        System.out.println(user);
        Map<String,Object> msg = new HashMap<>();
        if(user==null){
            msg.put("msg","账号不存在");
            return msg;
        }
        else if(!(user.getPassword().equals(loginUser.getPassword()))){
            msg.put("msg","密码错误");
            return msg;
        }
        else {
            msg.put("msg","登录成功");
            msg.put("user",user);
            return msg;
        }
    }


    //修改
    @RequestMapping(value = "/updateUser",produces = "application/json;charset=utf-8")
    public Object updateUser(@RequestBody Stu user){
        Map<String,Object> msg = new HashMap<>();
        boolean flag = stuService.modifyUser(user);
        if (flag) {
            msg.put("msg","修改成功");
            return msg;
        } else {
            msg.put("msg","修改失败");
            return msg;
        }
    }

    //查询所有用户
    @RequestMapping(value = "/allUser",produces = "application/json;charset=utf-8")
    public List<Stu> allUser(){
        List<Stu> list = stuService.selectAllUser();
        logger.info(list);
        if(list != null){
            return list;
        } else {
            return null;
        }
    }










}
