package com.baizhi.fina.dao;

import com.baizhi.fina.entity.Admin;
import com.baizhi.fina.entity.Menu;
import java.util.List;

public interface MenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    Menu selectByPrimaryKey(Integer id);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);

    List<Admin>  selectAllD();
}