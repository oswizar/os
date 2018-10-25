package com.xiexing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiexing.entities.Stu;
import com.xiexing.service.IStuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class StuController {

    @Resource
    private IStuService stuService;
    private int id;
    private ObjectMapper mapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //注册
    @RequestMapping(value = "/showUser", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    public String postUser(@RequestBody Stu registUser, HttpServletRequest request) throws IOException {
        System.out.println(registUser);
        System.out.println(registUser.getName());
        Stu user = stuService.selectUserByName(registUser.getName());
        if (user != null) {
            return "已被注册";
        } else {
            boolean flag = stuService.addUser(registUser);
            System.out.println(flag);
            if (flag) {
                return "注册成功";
            } else {
                return "注册失败";
            }

        }

    }

    //登录
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Object loginUser(@RequestBody Stu loginUser, HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        Stu user = stuService.selectUserByName(loginUser.getName());
        Map<String,String> msg = new HashMap<>();
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
            return msg;
        }



    }










}
