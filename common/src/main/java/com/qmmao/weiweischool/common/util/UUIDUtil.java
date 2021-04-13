package com.qmmao.weiweischool.common.util;

import java.util.UUID;

/**
 * @author xiyang.ycj
 * @since Jul 08, 2019 16:18:00 PM
 */
public class UUIDUtil {

    private UUIDUtil() {}

    /**
     * 简单模式，简单模式为不带'-'的UUID字符串
     * @return 生成32位的uuid
     */
    public static String generator() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
