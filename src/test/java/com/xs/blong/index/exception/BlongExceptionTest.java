package com.xs.blong.index.exception;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BlongExceptionTest {

    @Test
    public void test_BlongException() {
        try {
            BlongException blongException = new BlongException(ErrorType.PARAM_NULL_ERROR, "手机号");
            log.info("{}", blongException);
        } catch (Exception e) {
            log.error("{}", e);
        }
    }

}