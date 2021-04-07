package com.qmmao.weiweischool.security.authserver;

import com.qmmao.weiweischool.security.authserver.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author qmmao
 */
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
