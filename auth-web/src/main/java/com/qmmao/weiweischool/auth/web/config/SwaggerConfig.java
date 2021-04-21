package com.qmmao.weiweischool.auth.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("business-api")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.qmmao.weiweischool.auth.web.restcontroller"))
                //扫描Controller
                .build();
    }
    /**
     * swagger api 信息描述<br/>
     * @return {@link ApiInfo swagger API 对象}
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统 API")
                .description("了解更多信息：http://www.baidu.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .license("License Version 1.0")
                .contact("xx开发组")
                .version("1.0")
                .build();
    }
}
