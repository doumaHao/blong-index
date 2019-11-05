package com.xs.blong.index.util;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 随机生成uuid
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
