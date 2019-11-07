package com.xs.blong.index.api;

import com.xs.blong.index.api.service.ActivityApiService;
import com.xs.blong.index.req.GetInvitationCodeReq;
import com.xs.blong.index.req.SaveInvitationChannelReq;
import com.xs.blong.index.resp.BaseResp;
import com.xs.blong.index.resp.GetInvitationCodeResp;
import com.xs.blong.index.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 活动API
 */
@Api("活动API")
@Slf4j
@Service
public class ActivityApi extends BaseApi {

    @Autowired
    private ActivityApiService activityApiService;

    /**
     * 获取邀请码
     *
     * @param req
     * @return
     */
    @ApiOperation(value = "获取邀请码", notes = "获取邀请码")
    public String getInvitationCode(String req) {
        log.info("ActivityApi.getInvitationCode BEGIN,reqJson={}", req);

        if (StringUtils.isEmpty(req)) {
            log.warn("ActivityApi.getInvitationCode WARN[请求报文异常]，reqJson={}", req);
            return BaseResp.fastFail().toString();
        }

        GetInvitationCodeReq request = JsonUtil.toObject(req, GetInvitationCodeReq.class);

        GetInvitationCodeResp response = new GetInvitationCodeResp();
        response.setReqNo(request.getReqNo());
        try {

            request.verify();

            response = activityApiService.doGetInvitationCode(request);

        } catch (Exception e) {
            log.warn("ActivityApi.getInvitationCode ERROR,e={}", e);
            catchException(e, request, response);
        }
        log.info("ActivityApi.getInvitationCode END,response={}", response);
        return JsonUtil.toJson(response);
    }


    /**
     * 保存邀请渠道信息
     *
     * @param req
     * @return
     */
    @ApiOperation(value = "保存邀请渠道信息", notes = "保存邀请渠道信息")
    public String saveInvitationChannel(String req) {
        log.info("ActivityApi.saveInvitationChannel BEGIN,reqJson={}", req);

        if (StringUtils.isEmpty(req)) {
            log.warn("ActivityApi.saveInvitationChannel WARN[请求报文异常]，reqJson={}", req);
            return BaseResp.fastFail().toString();
        }

        SaveInvitationChannelReq request = JsonUtil.toObject(req, SaveInvitationChannelReq.class);

        BaseResp response = new BaseResp();
        response.setReqNo(request.getReqNo());
        try {

            request.verify();

            response = activityApiService.saveInvitationChannel(request);

        } catch (Exception e) {
            log.warn("ActivityApi.saveInvitationChannel ERROR,e={}", e);
            catchException(e, request, response);
        }
        log.info("ActivityApi.saveInvitationChannel END,response={}", response);
        return JsonUtil.toJson(response);
    }


}
