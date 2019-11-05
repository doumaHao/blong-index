package com.xs.blong.index.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class UUIDUtilTest {

    @Test
    public void uuid() {
        try {
            log.info("{}", UUIDUtil.uuid());
        } catch (Exception e) {
            log.error("{}", e);
        }
    }
}