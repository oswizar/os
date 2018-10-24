package com.xiexing.service;

import com.xiexing.entities.Stu;

import java.util.List;

public interface IStuService {

    public Stu selectUser(int id);

    public List<Stu> selectAllUser();

    public Stu addUser(Stu stu);

    public Stu removeUser(int id);

    public Stu modifyUser(Stu stu);

}
