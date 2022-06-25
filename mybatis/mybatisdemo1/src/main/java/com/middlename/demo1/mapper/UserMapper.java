package com.middlename.demo1.mapper;

import com.middlename.demo1.pojo.User;

import java.util.List;

public interface UserMapper {
    public int insertUser();
    public int modifyUser();
    public int deleteUser();

    public User getUserbyID();
    public List<User> getAllUser();

}
