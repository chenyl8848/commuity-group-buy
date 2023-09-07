package com.cyl.groupbuy.framework.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @author：Java陈序员
 * @date：2023/8/30 9:35
 * @description：swagger 配置类
 */
@Configuration
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("社区团购")
                .description("社区团购")
                .contact(new Contact("Java陈序员", "https://github.com/chenyl8848", "1063415880@qq.com"))
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket docket() {
        // 定义全局请求参数
        ArrayList<RequestParameter> paramsList = new ArrayList<>();

        RequestParameterBuilder requestParameterBuilder = new RequestParameterBuilder();

        RequestParameter requestParameter = requestParameterBuilder.name("apiToken")
                .description("用户token")
                .in("header")
                .required(false)
                .build();
        paramsList.add(requestParameter);


        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .groupName("webApi")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cyl.scaffold.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(paramsList);
    }

}
