package com.qmmao.weiweischool.sercurity.auth.config.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qmmao.weiweischool.common.util.login.JwtUtil;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import com.qmmao.weiweischool.sercurity.auth.config.key.RsaKeyProperties;
import com.qmmao.weiweischool.sercurity.auth.config.user.SecurityUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DELL
 */
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Autowired
    private RsaKeyProperties prop;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
        //成功可以跳转到进来的地址，如果进来的地址是空的，就跳转到首页
        //super.onAuthenticationSuccess(request, response, authentication);
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        String token = JwtUtil.generateTokenExpireInMinutes(user.getUserInfo(), prop.getPrivateKey(), 24 * 60);
        response.addHeader("Authorization", "Bearer " + token);
        response.setContentType(ConstVar.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", HttpServletResponse.SC_OK);
        resultMap.put("msg", "登陆成功！");
        out.write(new ObjectMapper().writeValueAsString(resultMap));
        out.flush();
        out.close();
    }
}
