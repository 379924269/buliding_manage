package com.dnp.bulidingmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 启动类，继承SpringBootServletInitializer，主要是为了部署到tomcat下面
 *
 * @Author 华仔
 * @DATE 2017/10/20 8:59
 */
@SpringBootApplication
public class BulidingManageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BulidingManageApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
