package com.xs.blong.index.api;

import com.xs.blong.index.exception.BlongException;
import com.xs.blong.index.req.BaseReq;
import com.xs.blong.index.resp.BaseResp;

public class BaseApi {

    public void catchException(Exception e, BaseReq request, BaseResp response) {
        if (e instanceof BlongException) {
            BlongException be = (BlongException) e;
            response.structureFail(request.getReqNo(), be.getCode(), be.getMessage());
        } else {
            response.structureFail(request.getReqNo(), null, null);
        }
    }

}
