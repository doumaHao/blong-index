package com.xs.blong.index.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseReq implements Serializable {

    /**
     * 请求流水号
     */
    private String reqNo;
    /**
     * 请求设备 H5/IOS/Android
     */
    private String device;
    /**
     * 设备号
     */
    private String deviceNo;
    /**
     * 请求ip
     */
    private String ip;

    /**
     * 校验方法
     *
     * @return
     */
    public String verify() {
        return null;
    }
}
