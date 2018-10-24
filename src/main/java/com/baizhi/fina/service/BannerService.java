package com.baizhi.fina.service;

import com.baizhi.fina.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> selectAll();
    int updateByPrimaryKey(Banner record);
    int insert(Banner record);
    void multiDelete(int[] ids);
}
