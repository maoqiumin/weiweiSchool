package com.qmmao.weiweischool.sercurity.auth.config.code;

import com.qmmao.weiweischool.model.constvar.ConstVar;
import com.qmmao.weiweischool.sercurity.auth.config.handle.LoginFailureHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DELL
 */
@Component
public class VerifyCodeFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(VerifyCodeFilter.class);
    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (ConstVar.LOGIN.equals(request.getRequestURI()) && ConstVar.POST.equalsIgnoreCase(request.getMethod())) {
            try {
                validate(request);
            } catch (VerifyCodeException e) {
                loginFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        // 3. 校验通过，就放行
        filterChain.doFilter(request, response);
    }

    private void validate(HttpServletRequest request) throws ServletRequestBindingException {
        String captcha = ServletRequestUtils.getStringParameter(request, "captcha");
        String code = (String) request.getSession().getAttribute(request.getParameter("uuid"));
        log.info("获取提交的code:【{}】", captcha);
        log.info("获取保存的code:【{}】", code);
        if (!code.equalsIgnoreCase(captcha)) {
            throw new VerifyCodeException("验证码不正确！");
        }
        request.getSession().removeAttribute(request.getParameter("uuid"));
    }
}
