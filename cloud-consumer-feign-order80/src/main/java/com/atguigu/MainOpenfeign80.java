package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: xj
 * @version: 2024/6/10
 * @description:feign是在消费端使用的
 */
@SpringBootApplication
@EnableDiscoveryClient //注册服务到consul中被consul发现
@EnableFeignClients //开启openfeign功能并激活
public class MainOpenfeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenfeign80.class, args);
        System.out.println("************ MainOpenfeign80 启动成功 **************");
    }
}