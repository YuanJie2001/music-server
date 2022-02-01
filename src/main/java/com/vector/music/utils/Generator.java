package com.vector.music.utils;



import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;


/**
 * @description: 代码生成器
 * @author: YuanJie
 * @create: 2022-1-31 16:22
 **/

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class Generator {
    public static void main(String[] args) {
        //获取项目所在路径
        String path = System.getProperty("user.dir");
        // 数据库配置(DataSourceConfig)
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/music?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true", "root", "WJHwjh20010825.")
        // 全局配置(GlobalConfig)
                .globalConfig(builder -> {
                    builder.author("YuanJie") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride()// 覆盖已生成文件
                            .outputDir(path+"/src/main/java"); // 指定输出目录
                })
        // 包配置(PackageConfig)
                .packageConfig(builder -> {
                    builder.parent("com.vector.music") // 设置父包名
                            .mapper("mapper")
                            .entity("pojo")
                            .controller("controller")
                            .service("service")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, path+"/src/main/resources/mapper")); // 设置mapperXml生成路径;
                })
                .strategyConfig(builder -> {
                    builder.addInclude("admin","collect","comment","list_contain_song","rank","sing","song","song_list","user"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}


