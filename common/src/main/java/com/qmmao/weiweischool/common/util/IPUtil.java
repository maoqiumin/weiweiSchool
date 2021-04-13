package com.qmmao.weiweischool.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiyang.ycj
 * @since Jul 09, 2019 14:31:29 PM
 */
public class IPUtil {

    /**
     * 获取ip
     *
     * @param request servlet
     * @return 返回真实的ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        /* squid */
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            /* apache */
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        /* 获取最直接发给他的机器ip */
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
