package com.qmmao.weiweischool.sercurity.auth.config.key;

import com.qmmao.weiweischool.common.util.login.JwtUtil;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import com.qmmao.weiweischool.model.vo.login.PayLoad;
import com.qmmao.weiweischool.model.vo.login.UserInfoDTO;
import com.qmmao.weiweischool.sercurity.auth.config.handle.LoginFailureHandler;
import com.qmmao.weiweischool.sercurity.auth.config.user.SecurityUser;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author DELL
 */
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationTokenFilter.class);

    @Autowired
    private RsaKeyProperties prop;
    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //不需要进行token验证的请求
        List<String> noCheckUrls = Arrays.asList(ConstVar.LOGIN, ConstVar.GETCODE);
        if (!noCheckUrls.contains(request.getRequestURI())) {
            try {
                checkToken(request);
            } catch (AuthenticationServiceException e) {
                loginFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private void checkToken(HttpServletRequest request) throws AuthenticationServiceException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new AuthenticationServiceException("Token 无效");
        }
        //如果携带了正确格式的token要先得到token
        String token = header.replace("Bearer ", "");
        log.info("获取token：{}", token);
        PayLoad<UserInfoDTO> payload = JwtUtil.getInfoFromToken(token, prop.getPublicKey(), UserInfoDTO.class);
        if (payload.getUserInfo() == null) {
            throw new AuthenticationServiceException("Token 无效");
        }
        if (payload.getExpiration().before(DateTime.now().toDate())) {
            throw new AuthenticationServiceException("Token 过期");
        }
        SecurityUser securityUser = new SecurityUser(payload.getUserInfo());
        UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authResult);
    }
}


