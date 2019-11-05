package com.xs.blong.index.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class JsonUtil {

    /**
     * Objec转json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        String json = null;
        if (object == null) {
            return json;
        }
        return JSON.toJSONString(object);
    }

    /**
     * json转Object
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * json转Map
     *
     * @param json
     * @return
     */
    public static Map<String, Object> toMap(String json) {
        return JSON.parseObject(json, Map.class);
    }

}
