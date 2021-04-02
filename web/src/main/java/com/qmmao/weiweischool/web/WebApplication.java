package com.qmmao.weiweischool.web;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author maoqi
 */
@SpringBootApplication(scanBasePackages = {"com.qmmao.weiweischool.service.servicemanger.operator","com.qmmao.weiweischool.web"})
@MapperScan(value = "com.qmmao.weiweischool.dao.operatordb.mapper", annotationClass = Mapper.class)
public class WebApplication extends SpringBootServletInitializer {

    /*public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }*/
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

}
