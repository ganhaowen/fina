package com.baizhi.fina.controller;

import com.baizhi.fina.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String username, String password, String kaptcha, HttpSession session) throws UnsupportedEncodingException {
        logger.error(kaptcha);
        if (kaptcha.equalsIgnoreCase((String) session.getAttribute("kaptcha"))) {
            if (adminService.login(username, password)) {
                return "redirect:/main/main.jsp";
            } else {
                return "redirect:/login.jsp?info=" + URLEncoder.encode("账号或者密码错误", "UTF-8");
            }
        }
        return "redirect:/login.jsp?info=" + URLEncoder.encode("验证码错误", "UTF-8");

    }
}

