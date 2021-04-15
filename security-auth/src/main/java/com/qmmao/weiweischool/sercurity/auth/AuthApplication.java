package com.qmmao.weiweischool.sercurity.auth;

import com.qmmao.weiweischool.sercurity.auth.config.key.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author DELL
 */
@SpringBootApplication(scanBasePackages = {"com.qmmao.weiweischool.service","com.qmmao.weiweischool.sercurity"})
@MapperScan("com.qmmao.weiweischool.dao")
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
