package com.example.springbootCM.Config;

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
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootCM.apiServer"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false); // status code 200,401,403,404 메시지 표시 x
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("CareerManagementSystem api")
                .description("경력관리시스템 api 문서")
                .license("seonuwana")
                .licenseUrl("http://github.com/jeongyoonjeong")
                .version("1").build();
    }
}