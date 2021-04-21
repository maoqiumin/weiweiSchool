package com.qmmao.weiweischool.auth.web.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qmmao.weiweischool.auth.web.config.RsaKeyProperties;
import com.qmmao.weiweischool.common.util.login.JwtUtil;
import com.qmmao.weiweischool.model.PayLoad;
import com.qmmao.weiweischool.model.auth.vo.UserVO;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DELL
 */
@Component
public class JwtTokenInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenInterceptor.class);

    @Autowired
    private RsaKeyProperties prop;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String header = request.getHeader(ConstVar.AUTHORIZATION);
        if (header == null || !header.startsWith(ConstVar.BEARER)) {
            response.sendRedirect("/login");
            return false;
            //throw new RuntimeException("Token 无效");
        }
        //如果携带了正确格式的token要先得到token
        String token = header.replace(ConstVar.BEARER + " ", StringUtils.EMPTY);
        log.info("获取token：{}", token);
        PayLoad<UserVO> payload = JwtUtil.getInfoFromToken(token, prop.getPublicKey(), UserVO.class);
        if (payload.getUserInfo() == null) {
            response.sendRedirect("/login");
            return false;
            //throw new RuntimeException("Token 无效");
        }
        if (payload.getExpiration().before(DateTime.now().toDate())) {
            response.sendRedirect("/login");
            return false;
            //throw new RuntimeException("Token 过期");
        }
        request.setAttribute(ConstVar.USERINFO, payload.getUserInfo());
        return true;
    }
}
