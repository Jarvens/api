package com.hcon.api.domain;

/**
 * 系统  - 菜单
 * Created by kunlun on 2017/4/5.
 */
public class SysMenu {

    //主键
    private int id;

    //菜单名称
    private String name;

    //父级id
    private int pid;

    //菜单地址
    private String url;

    //菜单类型
    private String type;

    //菜单描述
    private String description;

    //状态
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
