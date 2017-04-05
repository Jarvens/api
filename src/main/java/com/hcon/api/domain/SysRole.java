package com.hcon.api.domain;

import java.util.Date;

/**
 * 系统  - 角色
 * Created by kunlun on 2017/4/5.
 */
public class SysRole {

    //主键
    private int id;

    //角色名称
    private String name;

    //备注
    private String remark;

    //创建时间
    private Date createTime;

    //操作人
    private String operator;

    //修改时间
    private Date updateTime;

    //状态
    private String state;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", operator='" + operator + '\'' +
                ", updateTime=" + updateTime +
                ", state='" + state + '\'' +
                '}';
    }
}
