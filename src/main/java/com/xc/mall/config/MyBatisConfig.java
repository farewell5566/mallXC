package com.xc.mall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.xc.mall.mbg.mapper")
public class MyBatisConfig {
}
