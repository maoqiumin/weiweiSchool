package com.qmmao.weiweischool.sercurity.auth.config.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author DELL
 */
public class VerifyCodeException extends AuthenticationException {
    public VerifyCodeException(String msg) {
        super(msg);
    }
}
