package com.vector.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SingerPicConfig
 * @Description 定位歌手头像地址
 * @Author YuanJie
 * @Date 2022/2/3 23:57
 */
/**
 * resources目录下建立如下四个目录
 * classpath:/public/
 * classpath:/resources/
 * classpath:/static/
 * classpath:/META-INFO/resouces/
 * 自动访问
 */
@Configuration
public class SingerPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
