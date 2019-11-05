package com.xs.blong.index.resp;

import com.xs.blong.index.util.UUIDUtil;

import java.io.Serializable;

public class BaseResp implements Serializable {

    /**
     * \
     * 请求号
     */
    private String reqNo;
    /**
     * 响应号
     */
    private String respNo;
    /**
     * 响应状态
     */
    private String status;
    /**
     * 响应描述
     */
    private String msg;

    public void structureSuccess() {
        this.respNo = UUIDUtil.uuid();
        this.status = "000000";
        this.msg = "请求成功";
    }

    public void structureFail(String reqNo, String status, String msg) {
        this.reqNo = reqNo;
        this.respNo = UUIDUtil.uuid();
        this.status = status == null ? "999999" : status;
        this.msg = msg == null ? "未知异常" : msg;
    }

    public static BaseResp fastFail() {
        BaseResp baseResp = new BaseResp();
        baseResp.respNo = UUIDUtil.uuid();
        baseResp.status = "999999";
        baseResp.msg = "未知异常";
        return baseResp;
    }
}
