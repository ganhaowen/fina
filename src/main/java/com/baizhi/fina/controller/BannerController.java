package com.baizhi.fina.controller;

import com.baizhi.fina.entity.Banner;
import com.baizhi.fina.service.BannerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/banner")
public class BannerController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    BannerService bannerService;

    @Bean
    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置上传的文件大小上限，如果超出限制，就会抛出异常信息
        factory.setMaxFileSize("128KB");
        //设置一次总上传数据的大小，用于多文件上传设置
        factory.setMaxRequestSize("256KB");
        return factory.createMultipartConfig();
    }


    @RequestMapping("selectAll")
    public Map selectAll(int rows, int page) {
        HashMap map = new HashMap();
        Page<Banner> page1 = PageHelper.startPage(page, rows);
        bannerService.selectAll();
        map.put("rows", page1.getResult());
        map.put("total", page1.getTotal());

        return map;
    }

    @RequestMapping("/update")
    public boolean update(Banner banner) {
        HashMap map = new HashMap();
        try {
            bannerService.updateByPrimaryKey(banner);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("add")
    public boolean add(Banner banner, MultipartFile file, HttpServletRequest request) throws IOException {
        try {
            String realPath = request.getRealPath("/upload");
            String originalFilename = file.getOriginalFilename();
            String fileName = System.currentTimeMillis() + "_" + originalFilename;
            File file1 = new File(realPath + "/" + fileName);
            file.transferTo(file1);
            banner.setUrl(fileName);
            bannerService.insert(banner);
           /* System.out.println(1/0);*/
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @RequestMapping("multiDelete")
    public boolean multiDelete(int[] ids){
        try {
            bannerService.multiDelete(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
