package com.cu.weiketang.base.config;

import io.swagger.models.Contact;
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
public class Swagger2 {

    @Bean
    public Docket createRestApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.host("39.96.68.53:9898");
     /*   docket.host("localhost:9898");*/
        docket.apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cu.weiketang.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    private ApiInfo apiInfo(){
        Contact contact=new Contact();
        contact.setName("CG");
        contact.setUrl("http://baidu.com");
        contact.setEmail("1634337925@qq.com");
        return new ApiInfoBuilder()
                .title("CG API")//大标题
                .description("CG API CG's zone,CG's rule")//详细描述
                .version("1.0")//版本
                .contact(contact.toString())//作者
                .license("The Apache License, Version 1.0")//许可证信息
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")//许可证地址
                .build();

    }
}
