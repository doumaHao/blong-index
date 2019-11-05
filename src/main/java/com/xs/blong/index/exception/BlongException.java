package com.xs.blong.index.exception;

import lombok.Getter;

@Getter
public class BlongException extends RuntimeException {

    private String code;

    public BlongException(ErrorType errorType){
        super(errorType.getMsg());
        this.code = errorType.getCode();
    }

    public BlongException(ErrorType errorType, String ...params){
        super(String.format(errorType.getMsg(), params));
        this.code = errorType.getCode();
    }

}
