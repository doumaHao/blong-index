package com.xs.blong.index.api.service;

import com.xs.blong.index.BlongIndexApplication;
import com.xs.blong.index.req.GetInvitationCodeReq;
import com.xs.blong.index.resp.GetInvitationCodeResp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("ALL")
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlongIndexApplication.class)
public class ActivityApiServiceTest {

    @Autowired
    private ActivityApiService activityApiService;

    @Test
    public void doGetInvitationCode() {
        try {
            GetInvitationCodeReq getInvitationCodeReq = new GetInvitationCodeReq();
            getInvitationCodeReq.setPhone("18011112222");
            GetInvitationCodeResp getInvitationCodeResp = activityApiService.doGetInvitationCode(getInvitationCodeReq);
            log.info("{}", getInvitationCodeReq);
        } catch (Exception e) {

        }

    }
}