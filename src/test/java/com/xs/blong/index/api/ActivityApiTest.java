package com.xs.blong.index.api;

import com.xs.blong.index.BlongIndexApplication;
import com.xs.blong.index.req.GetInvitationCodeReq;
import com.xs.blong.index.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@SuppressWarnings("ALL")
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlongIndexApplication.class)
public class ActivityApiTest {

    @Autowired
    private ActivityApi activityApi;

    @Transactional(rollbackFor = Exception.class)
    @Test
    public void test_getInvitationCode() {
        try {
            GetInvitationCodeReq req = new GetInvitationCodeReq();
            req.setPhone("18211113333");
            req.setSession("ABC112233112233");
            req.setReqNo("REQ123456789");
            String resp = activityApi.getInvitationCode(JsonUtil.toJson(req));
            log.info("test_getInvitationCode====>{}", resp);
        } catch (Exception e) {
            log.error("test_getInvitationCode={}", e);
        }
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

}