package com.baizhi.fina.dao;

import com.baizhi.fina.entity.Banner;
import java.util.List;

public interface BannerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    Banner selectByPrimaryKey(Integer id);

    List<Banner> selectAll();

    int updateByPrimaryKey(Banner record);
    void multiDelete(int[] ids);
}