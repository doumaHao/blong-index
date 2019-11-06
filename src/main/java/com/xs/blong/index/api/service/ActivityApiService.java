package com.xs.blong.index.api.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xs.blong.index.dao.ActivityInviteCodeDao;
import com.xs.blong.index.entity.ActivityInviteCode;
import com.xs.blong.index.exception.BlongException;
import com.xs.blong.index.exception.ErrorType;
import com.xs.blong.index.req.GetInvitationCodeReq;
import com.xs.blong.index.resp.GetInvitationCodeResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SuppressWarnings("ALL")
@Slf4j
@Service
public class ActivityApiService {

    @Autowired
    private ActivityInviteCodeDao activityInviteCodeDao;

    @Transactional
    public GetInvitationCodeResp doGetInvitationCode(GetInvitationCodeReq request) {
        log.info("ActivityApiService.doGetInvitationCode,request={}", request);
        GetInvitationCodeResp resp = new GetInvitationCodeResp();
        resp.structureSuccess();

        EntityWrapper<ActivityInviteCode> condition = new EntityWrapper();
        condition.eq("phone", request.getPhone());
        List<ActivityInviteCode> activityInviteCodes = activityInviteCodeDao.selectList(condition);

        if (!CollectionUtils.isEmpty(activityInviteCodes)) {
            log.info("ActivityApiService.doGetInvitationCode,[手机号已经领取过该活动了],activityInviteCodes={}", activityInviteCodes);
            throw new BlongException(ErrorType.ACTIVITY_PHONE_USED);
        }

        ActivityInviteCode activityInviteCode = activityInviteCodeDao.get1stWhenPhoneNull();
        if (activityInviteCode == null) {
            log.info("ActivityApiService.doGetInvitationCode,[邀请码已经领完]");
            throw new BlongException(ErrorType.ACTIVITY_CODE_OVER);
        }

        activityInviteCode.setPhone(request.getPhone());
        Integer i = activityInviteCodeDao.updateById(activityInviteCode);
        if (i != 1) {
            log.info("ActivityApiService.doGetInvitationCode,[数据库操作异常]");
            throw new BlongException(ErrorType.COMMON_DB_ERROR);
        }

        resp.setInvitCode(activityInviteCode.getInvitCode());

        log.info("ActivityApiService.doGetInvitationCode,resp={}", resp);
        return resp;
    }
}
