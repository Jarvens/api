package com.hcon.common;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kunlun on 2017/3/28.
 */
public class GridDataRet<T> implements Serializable {

    private static final long serialVersionUID = -6563937391005832288L;

    @ApiModelProperty(notes = "错误编码")
    private String errorCode;

    @ApiModelProperty(notes = "提示信息")
    private String message;

    @ApiModelProperty(notes = "结果集")
    private List<T> list;

    @ApiModelProperty(notes = "总条数")
    private Long total = 0l;

    @ApiModelProperty(notes = "当前页数")
    private Integer page = 1;

    @ApiModelProperty(notes = "每页条数")
    private Integer size = 15;

    public GridDataRet(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public GridDataRet() {

    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
