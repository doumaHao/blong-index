package com.xs.blong.index.util;

import com.xs.blong.index.entity.ActivityInviteCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class JsonUtilTest {

    @Test
    public void test_toJson() {

        try {
            ActivityInviteCode activityInviteCode = new ActivityInviteCode();
            activityInviteCode.setPhone("18221859429");

            String json = JsonUtil.toJson(activityInviteCode);
            log.info("{}", json);
        } catch (Exception e) {

        }

    }
}