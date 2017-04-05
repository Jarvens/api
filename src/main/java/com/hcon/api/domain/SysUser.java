package com.hcon.api.domain;

import java.util.Date;

/**
 * Created by kunlun on 2017/4/5.
 */
public class SysUser {

    //主键id
    private int id;

    //账户
    private String account;

    //姓名
    private String name;

    //手机号
    private String mobilePhone;

    //密码
    private String password;

    //身份证号
    private String card;

    //性别
    private String sex;

    //年龄
    private int age;

    //用户类型
    private String type;

    //状态
    private String status;

    //操作人
    private String operator;

    //操作时间
    private Date operatorTime;

    //有效时间
    private long currentTime = System.currentTimeMillis();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public void updateCurrentTime() {
        currentTime = System.currentTimeMillis();
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", password='" + password + '\'' +
                ", card='" + card + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                ", operatorTime=" + operatorTime +
                '}';
    }
}
