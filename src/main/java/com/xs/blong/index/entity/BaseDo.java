package com.xs.blong.index.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDo implements Serializable {

    private Long id;
    private String isDelete;
    private String gmtCreate;
    private Date createTime;
    private String gmtModify;
    private Date modifyTime;

}
