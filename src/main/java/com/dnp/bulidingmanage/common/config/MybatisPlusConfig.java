package com.dnp.bulidingmanage.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {"com.dnp.bulidingmanage.dao*"})
public class MybatisPlusConfig {

}
