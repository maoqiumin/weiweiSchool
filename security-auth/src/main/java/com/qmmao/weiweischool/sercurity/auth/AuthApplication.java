package com.qmmao.weiweischool.sercurity.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DELL
 */
@SpringBootApplication(scanBasePackages = {"com.qmmao.weiweischool.service","com.qmmao.weiweischool.sercurity"})
@MapperScan("com.qmmao.weiweischool.dao")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
