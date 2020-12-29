package org.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 自动扫描Mapper接口
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"org.example.mapper"})
public class MyBatisConfig {
}
