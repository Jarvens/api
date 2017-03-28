package com.hcon.api.domain;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kunlun on 2017/3/28.
 */
public class UserRegiter implements Serializable {

    private static final long serialVersionUID = 9159144693650460332L;

    @ApiModelProperty(notes = "SID")
    private String sid;

    @ApiModelProperty(notes = "账号")
    private String account;

    @ApiModelProperty(notes = "名称")
    private String name;

    @ApiModelProperty(notes = "手机号")
    private String mobilePhone;

    @ApiModelProperty(notes = "登录口令")
    private String loginToken;

    @ApiModelProperty(notes = "身份证")
    private String idCard;

    @ApiModelProperty(notes = "性别")
    private String sex;

    @ApiModelProperty(notes = "年龄")
    private int age;

    @ApiModelProperty(notes = "用户类型")
    private String userType;

    @ApiModelProperty(notes = "岗位描述")
    private String detail;

    @ApiModelProperty(notes = "删除标识")
    private String deleFlag;

    @ApiModelProperty(notes = "操作人员")
    private String editor;

    @ApiModelProperty(notes = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date mdateTime;

    @ApiModelProperty(notes = "创建人")
    private String creator;

    @ApiModelProperty(notes = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date cDateTime;

    @ApiModelProperty(notes = "最后修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastModified;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    @Override
    public String toString() {
        return "UserRegiter{" +
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
