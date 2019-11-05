package com.xs.blong.index.api;

import com.xs.blong.index.api.service.ActivityApiService;
import com.xs.blong.index.exception.BlongException;
import com.xs.blong.index.req.GetInvitationCodeReq;
import com.xs.blong.index.resp.BaseResp;
import com.xs.blong.index.resp.GetInvitationCodeResp;
import com.xs.blong.index.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 活动API
 */
@Slf4j
@Service
public class ActivityApi {

    @Autowired
    private ActivityApiService activityApiService;

    /**
     * 获取邀请码
     *
     * @param req
     * @return
     */
    public String getInvitationCode(String req) {
        log.info("ActivityApi.getInvitationCode BEGIN,reqJson={}", req);

        if (StringUtils.isEmpty(req)) {
            log.warn("ActivityApi.getInvitationCode WARN[请求报文异常]，reqJson={}", req);
            return BaseResp.fastFail().toString();
        }

        GetInvitationCodeReq request = JsonUtil.toObject(req, GetInvitationCodeReq.class);
        GetInvitationCodeResp response = new GetInvitationCodeResp();
        try {
            response = activityApiService.doGetInvitationCode(request);
        } catch (Exception e) {
            log.warn("ActivityApi.getInvitationCode ERROR,e={}", e);
            if (e instanceof BlongException) {
                BlongException be = (BlongException) e;
                response.structureFail(request.getReqNo(), be.getCode(), be.getMessage());
            } else {
                response.structureFail(request.getReqNo(), null, null);
            }
        }
        log.info("ActivityApi.getInvitationCode END,response={}", response);
        return JsonUtil.toJson(response);
    }
}
