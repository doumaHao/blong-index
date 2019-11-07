package com.xs.blong.index.entity;

import lombok.Data;
import org.springframework.beans.BeanUtils;

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

    public void beanCopy(Object object) {
        BeanUtils.copyProperties(object, this);
        this.setIsDelete("N");
        this.setGmtCreate("system");
        this.setCreateTime(new Date());
    }

}
