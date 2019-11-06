package com.xs.blong.index.req;

import com.xs.blong.index.exception.BlongException;
import com.xs.blong.index.exception.ErrorType;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class GetInvitationCodeReq extends BaseReq {

    /**
     * 手机号
     */
    private String phone;

    public String verify() {
        if (StringUtils.isEmpty(phone)) {
            throw new BlongException(ErrorType.PARAM_NULL_ERROR, "手机号");
        }
        String other = super.verify();
        if (other != null) {
            throw new BlongException(ErrorType.COMMON_ERROR, other);
        }
        return null;
    }

}
