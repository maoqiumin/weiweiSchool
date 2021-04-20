package com.qmmao.weiweischool.auth.web;

import com.qmmao.weiweischool.auth.web.config.RsaKeyProperties;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author DELL
 */
@SpringBootApplication(scanBasePackages = {"com.qmmao.weiweischool.service","com.qmmao.weiweischool.auth.web"})
@MapperScan(value = "com.qmmao.weiweischool.dao", annotationClass = Mapper.class)
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthWebApplication.class, args);
    }
}
