package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: xj
 * @version: 2024/6/9
 * @description: 消费者订单模块
 */
@SpringBootApplication
@EnableDiscoveryClient //为了让consul注册中心发现
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class, args);
        System.out.println("************************ 80服务启动成功 ************************");
    }

}