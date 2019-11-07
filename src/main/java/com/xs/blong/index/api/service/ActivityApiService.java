package com.xs.blong.index.api.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xs.blong.index.dao.ActivityInviteChannelDao;
import com.xs.blong.index.dao.ActivityInviteCodeDao;
import com.xs.blong.index.entity.ActivityInviteChannel;
import com.xs.blong.index.entity.ActivityInviteCode;
import com.xs.blong.index.exception.BlongException;
import com.xs.blong.index.exception.ErrorType;
import com.xs.blong.index.req.GetInvitationCodeReq;
import com.xs.blong.index.req.SaveInvitationChannelReq;
import com.xs.blong.index.resp.BaseResp;
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
    @Autowired
    private ActivityInviteChannelDao activityInviteChannelDao;

    @Transactional
    public GetInvitationCodeResp doGetInvitationCode(GetInvitationCodeReq request) {
        log.info("ActivityApiService.doGetInvitationCode,request={}", request);

        GetInvitationCodeResp resp = new GetInvitationCodeResp();
        resp.structureSuccess(request);

        EntityWrapper<ActivityInviteCode> condition = null;

        //查看session已经获取过邀请码
        condition = new EntityWrapper();
        condition.eq("session", request.getSession());
        List<ActivityInviteCode> listBySession = activityInviteCodeDao.selectList(condition);
        if (!CollectionUtils.isEmpty(listBySession)) {
            resp.setInvitCode(listBySession.get(0).getInvitCode());
            log.info("ActivityApiService.doGetInvitationCode,resp={}", resp);
            return resp;
        }

        //查看手机号是否已经获取过邀请码
        condition = new EntityWrapper();
        condition.eq("phone", request.getPhone());
        List<ActivityInviteCode> listByPhone = activityInviteCodeDao.selectList(condition);
        if (!CollectionUtils.isEmpty(listByPhone)) {
            resp.setInvitCode(listByPhone.get(0).getInvitCode());
            log.info("ActivityApiService.doGetInvitationCode,resp={}", resp);
            return resp;
        }

        //获取邀请码
        ActivityInviteCode activityInviteCode = activityInviteCodeDao.get1stWhenPhoneNull();
        if (activityInviteCode == null) {
            log.info("ActivityApiService.doGetInvitationCode,[邀请码已经领完]");
            throw new BlongException(ErrorType.ACTIVITY_CODE_OVER);
        }

        //更新获取状态
        activityInviteCode.setPhone(request.getPhone());
        activityInviteCode.setIp(request.getIp());
        activityInviteCode.setSession(request.getSession());
        Integer i = activityInviteCodeDao.updateById(activityInviteCode);
        if (i != 1) {
            log.info("ActivityApiService.doGetInvitationCode,[数据库操作异常]");
            throw new BlongException(ErrorType.COMMON_DB_ERROR);
        }

        resp.setInvitCode(activityInviteCode.getInvitCode());

        log.info("ActivityApiService.doGetInvitationCode,resp={}", resp);
        return resp;
    }


    @Transactional
    public BaseResp saveInvitationChannel(SaveInvitationChannelReq request) {
        log.info("ActivityApiService.saveInvitationChannel,request={}", request);

        BaseResp resp = new BaseResp();
        resp.structureSuccess(request);

        EntityWrapper<ActivityInviteChannel> condition = null;

        //查看session是否已经保存过
        condition = new EntityWrapper();
        condition.eq("session", request.getSession());
        List<ActivityInviteChannel> listBySession = activityInviteChannelDao.selectList(condition);
        if (!CollectionUtils.isEmpty(listBySession)) {
            return resp;
        }

        ActivityInviteChannel activityInviteChannel = new ActivityInviteChannel();
        activityInviteChannel.beanCopy(request);
        Integer i = activityInviteChannelDao.insert(activityInviteChannel);
        if (i != 1) {
            log.info("ActivityApiService.saveInvitationChannel,[数据库操作异常]");
            throw new BlongException(ErrorType.COMMON_DB_ERROR);
        }

        log.info("ActivityApiService.saveInvitationChannel,resp={}", resp);
        return resp;
    }
}
