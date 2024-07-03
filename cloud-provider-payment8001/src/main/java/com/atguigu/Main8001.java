package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: xj
 * @version: 2024/6/9
 * @description:
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")//对mapper文件夹进行扫描
@EnableDiscoveryClient //为了让注册中心发现 consul
@RefreshScope // 动态刷新
public class Main8001 { //这里注意要改名字哦
    public static void main(String[] args)
    {
        SpringApplication.run(Main8001.class,args);

        System.out.println("********************************8001启动成功********************************");
    }
}