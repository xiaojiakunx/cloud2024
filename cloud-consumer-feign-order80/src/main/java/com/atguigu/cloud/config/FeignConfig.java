package com.atguigu.cloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xj
 * @version: 2024/6/11
 * @description:  作为调用者者：这里可以配置 openfeign的重试机制等
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer() {
        //return Retryer.NEVER_RETRY;//默认从不重试
        return new Retryer.Default(100,1,3);//设置第一次尝试远程调用接口，100ms后再次尝试重试调用，间隔1s后再次调用；总共调用1+2=3
    }
}
