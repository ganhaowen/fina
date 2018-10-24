package com.baizhi.fina.service;

import com.baizhi.fina.dao.AdminDao;
import com.baizhi.fina.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public boolean login(String username, String password) {
        if (adminDao.selectOne(username,password)!=null){
            return true;
        }
        return false;
    }
}
