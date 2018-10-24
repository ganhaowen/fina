package com.baizhi.fina.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private Integer id;

    private String title;

    private Integer pid;

    private String icon;

    private String url;

    private List<Admin> list;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pid=" + pid +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", list=" + list +
                '}';
    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}