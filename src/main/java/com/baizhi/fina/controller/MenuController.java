package com.baizhi.fina.controller;

import com.baizhi.fina.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping("/selectAll")
    public Map selectAll() {
        HashMap map = new HashMap();
        logger.error(menuService.selectAllD().toString());
        map.put("list", menuService.selectAllD());
        return map;
    }
}
