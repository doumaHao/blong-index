package com.xs.blong.index.dao;

import com.xs.blong.index.BlongIndexApplication;
import com.xs.blong.index.entity.ActivityInviteCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SuppressWarnings("ALL")
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlongIndexApplication.class)
public class ActivityInviteCodeDaoTest {

    @Autowired
    private ActivityInviteCodeDao activityInviteCodeDao;

    @Test
    public void test_activityInviteCodeDao() {
        try {
            List<ActivityInviteCode> activityInviteCodes = activityInviteCodeDao.selectList(null);
            Assert.assertEquals(1, activityInviteCodes.size());
            log.info("test_activityInviteCodeDao success");
        } catch (Exception e) {
            log.error("{}", e);
        }
    }

    @Test
    public void test_getAll() {
        try {
            List<ActivityInviteCode> activityInviteCodes = activityInviteCodeDao.get1stWhenPhoneNull();
            Assert.assertEquals(1, activityInviteCodes.size());
            log.info("test_getAll success");
        } catch (Exception e) {
            log.error("{}", e);
        }
    }

}