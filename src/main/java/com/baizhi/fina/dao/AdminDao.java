package com.baizhi.fina.dao;

import com.baizhi.fina.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao{
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);

    Admin selectOne(@Param("username") String username, @Param("password") String password);
}