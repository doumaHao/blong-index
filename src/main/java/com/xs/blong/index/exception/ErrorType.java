package com.xs.blong.index.exception;

import lombok.Getter;

@Getter
public enum ErrorType {

    /**
     * 通用异常
     **********************/
    COMMON_REQ_ERROR    ("0010001", "请求报文为空或异常"),
    COMMON_DB_ERROR     ("0010001", "数据库操作异常"),

    /**
     * 参数异常
     **********************/
    PARAM_NULL_ERROR    ("0110001", "%s不能为空"),

    /**
     * 活动相关异常
     **********************/
    ACTIVITY_PHONE_USED ("0210001", "该手机号已经领取过本活动了"),
    ACTIVITY_CODE_OVER  ("0210002", "邀请码已经领完");


    private String code;
    private String msg;

    ErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
