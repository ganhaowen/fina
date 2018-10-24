package com.baizhi.fina.service;

import com.baizhi.fina.dao.BannerDao;
import com.baizhi.fina.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerDao bannerDao;
    @Override
    public List<Banner> selectAll() {
        return bannerDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerDao.updateByPrimaryKey(record);
    }

    @Override
    public int insert(Banner record) {
        return bannerDao.insert(record);
    }

    @Override
    public void multiDelete(int[] ids) {
        bannerDao.multiDelete(ids);
    }
}
