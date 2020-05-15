package com.cu.weiketang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@MapperScan("com.cu.weiketang.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableSwagger2
@SpringBootApplication
public class WeiketangApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiketangApplication.class, args);
    }

}
