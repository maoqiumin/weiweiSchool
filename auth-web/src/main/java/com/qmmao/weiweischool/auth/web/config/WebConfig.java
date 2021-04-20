package com.qmmao.weiweischool.auth.web.config;

import com.qmmao.weiweischool.auth.web.interceptor.JwtTokenInterceptor;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author DELL
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JwtTokenInterceptor jwtTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePaths = Arrays.asList(ConstVar.LOGIN, ConstVar.GETCODE,"/static/**");
        registry.addInterceptor(jwtTokenInterceptor).addPathPatterns("/**").excludePathPatterns(excludePaths);
    }
    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
