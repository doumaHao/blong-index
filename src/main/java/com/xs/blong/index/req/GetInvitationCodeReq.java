package com.xs.blong.index.req;

import com.xs.blong.index.exception.BlongException;
import com.xs.blong.index.exception.ErrorType;
import lombok.Data;

@Data
public class GetInvitationCodeReq extends BaseReq {

    /**
     * 手机号
     */
    private String phone;

    public String verify() {
        String other = super.verify();
        if (other != null) {
            throw new BlongException(ErrorType.COMMON_ERROR, other);
        }
        return null;
    }

}
