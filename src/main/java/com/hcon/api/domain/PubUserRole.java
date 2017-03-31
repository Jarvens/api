package com.hcon.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 平台公用 -- 应用角色
 * Created by kunlun on 2017/3/30.
 */
public class PubUserRole implements Serializable {

    private static final long serialVersionUID = 1451919989178179863L;

    //角色id
    private String sid;

    //应用id
    private String applicationId;

    //用户类型
    private String userType;

    //角色名称
    private String roleName;

    //岗位说明
    private String memoString;

    //删除标识
    private String deleFlag;

    //修改人员
    private String editor;

    //修改时间
    private Date mDateTime;

    //创建人
    private String creator;

    //创建时间
    private Date cDateTime;

    //时间戳
    private Date lastModifyed;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMemoString() {
        return memoString;
    }

    public void setMemoString(String memoString) {
        this.memoString = memoString;
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

    public Date getmDateTime() {
        return mDateTime;
    }

    public void setmDateTime(Date mDateTime) {
        this.mDateTime = mDateTime;
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

    public Date getLastModifyed() {
        return lastModifyed;
    }

    public void setLastModifyed(Date lastModifyed) {
        this.lastModifyed = lastModifyed;
    }

    @Override
    public String toString() {
        return "PubUserRole{" +
                "sid='" + sid + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", userType='" + userType + '\'' +
                ", roleName='" + roleName + '\'' +
                ", memoString='" + memoString + '\'' +
                ", deleFlag='" + deleFlag + '\'' +
                ", editor='" + editor + '\'' +
                ", mDateTime=" + mDateTime +
                ", creator='" + creator + '\'' +
                ", cDateTime=" + cDateTime +
                ", lastModifyed=" + lastModifyed +
                '}';
    }
}
