package com.qmmao.weiweischool.security.resources;

import com.qmmao.weiweischool.security.resources.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author DELL
 */
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
