package com.ml.commons.utils;

import java.util.UUID;

/**
 * @description: UUIDUtils
 * @author: musou
 * @Date: 2022/4/13 2:54 PM
 */
public class UUIDUtils {
    /**
     * 返回一个替换掉-的随机uuid
     *
     * @return
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
