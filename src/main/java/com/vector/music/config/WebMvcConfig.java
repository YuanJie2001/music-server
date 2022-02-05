package com.vector.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author YuanJie
 * @Date 2022/1/31 11:25
 */

/**
 * 解决跨域问题
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("*");
    }

    /**
     * 默认情况下Spring Boot 使用WebMvcAutoConfiguration中配置的各种属性。
     * 默认映射的文件夹有：
     * classpath:/META-INF/resources
     * classpath:/resources
     * classpath:/static
     * classpath:/public
     * 上面这几个都是静态资源的映射路径，优先级顺序为：META-INF/resources > resources > static > public
     * 原理： 静态映射/**。
     * 请求进来，先去找Controller看能不能处理。不能处理的所有请求又都交给静态资源处理器。静态资源也找不到则响应404页面
     * 静态资源访问前缀
     * 默认无前缀
     * spring:
     * mvc:
     * static-path-pattern: /res/**
     * 当前项目 + static-path-pattern + 静态资源名 = 静态资源文件夹下找
     */
    // 以下是自定义静态资源访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * spring boot中上传图片回显问题
         * 定位歌手头像地址
         * 绝对路径映射,这个不重新部署就可以回显,因为映射你的本地
         */
        registry.addResourceHandler("static/**").addResourceLocations(
                System.getProperty("user.dir") + File.separator + "static" + File.separator);

    }
}
