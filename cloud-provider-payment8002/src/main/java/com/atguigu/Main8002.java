package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: xj
 * @version: 2024/6/10
 * @description:
 */
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
@EnableDiscoveryClient //被consul注册中心发现
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class,args);
        System.out.println("********************* 8002 启动成功 ******************");
    }
}