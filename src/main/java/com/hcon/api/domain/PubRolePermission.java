package com.hcon.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台公用 -- 应用角色权限
 * Created by kunlun on 2017/3/31.
 */
public class PubRolePermission implements Serializable {


    private static final long serialVersionUID = 1349225220125724667L;

    //id
    private String sid;

    //应用id
    private String applicationId;

    //功能id
    private String functionId;

    //角色id
    private String roleId;

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
    private Date lastModified;


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

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
