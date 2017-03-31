package com.hcon.api.domain;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kunlun on 2017/3/28.
 */
public class UserRegister implements Serializable {

    private static final long serialVersionUID = 9159144693650460332L;
    //用户ID
    private String sid;

    //账号
    private String account;

    //名称
    private String name;

    //手机号
    private String mobilePhone;

    //登录口令
    private String loginToken;

    //身份证
    private String idCard;

    //性别
    private String sex;

    //年龄
    private String age;

    //用户类型
    private String userType;

    //岗位描述
    private String detail;

    //删除标识
    private String deleFlag;

    //操作人员
    private String editor;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    //修改时间
    private Date mdateTime;

    //创建人
    private String creator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    //创建时间
    private Date cDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    //最后修改时间
    private Date lastModified;

    //用作Token判断有效期
    private long currentTime = System.currentTimeMillis();

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDeleFlag() {
        return deleFlag;
    }

    public void setDeleFlag(String deleFlag) {
        this.deleFlag = deleFlag;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getMdateTime() {
        return mdateTime;
    }

    public void setMdateTime(Date mdateTime) {
        this.mdateTime = mdateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getcDateTime() {
        return cDateTime;
    }

    public void setcDateTime(Date cDateTime) {
        this.cDateTime = cDateTime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void updateCurrentTime() {
        currentTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "sid='" + sid + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", userType='" + userType + '\'' +
                ", detail='" + detail + '\'' +
                ", deleFlag='" + deleFlag + '\'' +
                ", editor='" + editor + '\'' +
                ", mdateTime=" + mdateTime +
                ", creator='" + creator + '\'' +
                ", cDateTime=" + cDateTime +
                ", lastModified=" + lastModified +
                '}';
    }
}
