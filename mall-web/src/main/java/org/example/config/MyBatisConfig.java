package org.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:03
 * Project: shopping-mall
 * Package: org.example.config
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"org.example.dao","org.example.mapper"})
public class MyBatisConfig {
}
