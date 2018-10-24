package com.xiexing.dao;

import com.xiexing.entities.Stu;

import java.util.List;

public interface StuMapper {

    Stu selectUser(int id);

    List<Stu> selectAllUser();

    Stu addUser(Stu stu);

    Stu removeUser(int id);

    Stu modifyUser(Stu stu);

}