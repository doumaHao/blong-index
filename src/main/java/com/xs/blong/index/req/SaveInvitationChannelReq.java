package com.xs.blong.index.req;

import com.xs.blong.index.exception.BlongException;
import com.xs.blong.index.exception.ErrorType;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class SaveInvitationChannelReq extends BaseReq {

    /**
     * 邀请渠道
     */
    private String channel;
    /**
     * 邀请种类 index:首页 down:下载
     */
    private String type;

    public String verify() {
        if (StringUtils.isEmpty(type)) {
            throw new BlongException(ErrorType.PARAM_NULL_ERROR, "邀请种类");
        }
        String other = super.verify();
        if (other != null) {
            throw new BlongException(ErrorType.COMMON_ERROR, other);
        }
        return null;
    }

}
