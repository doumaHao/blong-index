package com.xs.blong.index.entity;

import lombok.Data;

/**
 * 活动邀请码表
 */
@Data
public class ActivityInviteCode extends BaseDo {

    /**
     * 手机号
     */
    private String phone;
    /**
     * 邀请码
     */
    private String invitCode;
    /**
     * session
     */
    private String session;
    /**
     * ip
     */
    private String ip;

}
