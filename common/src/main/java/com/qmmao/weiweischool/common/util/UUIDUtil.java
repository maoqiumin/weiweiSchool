package com.qmmao.weiweischool.common.util;


import org.apache.commons.codec.digest.DigestUtils;

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

    /**
     * 获取根据MD5加密的密码
     * @param srcPassword 原密码
     * @param salt 盐值
     * @return 加密后的密码
     */
    private static String generatorMd5Password(String srcPassword, String salt) {
        // 【注意】以下加密规则是自由设计的
        // ----------------------------
        // 使用盐值 + 原密码
        String str = salt + srcPassword;
        // 循环执行10次摘要运算
        for (int i = 0; i < 10; i++) {
            str = DigestUtils.md5Hex(str);
        }
        // 返回摘要结果
        return str;
    }
}
