package com.baizhi.fina.service;

import com.baizhi.fina.dao.MenuDao;
import com.baizhi.fina.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl  implements MenuService {
    @Autowired
    MenuDao menuDao;
    @Override
    public List<Admin> selectAllD() {
        return menuDao.selectAllD();
    }
}
