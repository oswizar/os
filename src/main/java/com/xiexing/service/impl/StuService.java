package com.xiexing.service.impl;

import com.xiexing.dao.StuMapper;
import com.xiexing.entities.Stu;
import com.xiexing.service.IStuService;

import javax.annotation.Resource;
import java.util.List;

public class StuService implements IStuService {

    @Resource
    private StuMapper stuMapper;

    @Override
    public Stu selectUser(int id) {
        return stuMapper.selectUser(id);
    }

    @Override
    public List<Stu> selectAllUser() {
        return stuMapper.selectAllUser();
    }

    @Override
    public Stu addUser(Stu stu) {
        return stuMapper.addUser(stu);
    }

    @Override
    public Stu removeUser(int id) {
        return stuMapper.removeUser(id);
    }

    @Override
    public Stu modifyUser(Stu stu) {
        return stuMapper.modifyUser(stu);
    }
}
