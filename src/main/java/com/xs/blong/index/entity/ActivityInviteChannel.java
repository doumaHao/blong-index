package com.xs.blong.index.entity;

import lombok.Data;

/**
 * 活动邀请渠道表
 */
@Data
public class ActivityInviteChannel extends BaseDo {

    /**
     * 邀请渠道
     */
    private String channel;
    /**
     * 邀请种类 index:首页 down:下载
     */
    private String type;
    /**
     * session
     */
    private String session;
    /**
     * ip
     */
    private String ip;

}
