package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: 卑微小冯
 * Date: 2020/12/11 下午4:04
 * Project: shopping-mall
 * Package: org.example.config
 */

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/home/fxy/HomeDirection/IdeaProjects/shopping-mall/mall-web/src/main/resources/static/images");
    }
}
