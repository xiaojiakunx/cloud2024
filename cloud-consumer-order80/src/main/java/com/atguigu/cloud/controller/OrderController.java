package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: xj
 * @version: 2024/6/10
 * @description:消费者：下订单 调用支付接口(下订单做支付)
 */
@RestController
@RequestMapping("/consumer")
@Tag(name = "订单微服务模块", description = "订单微服务的crud") //swagger的注解
public class OrderController {
    @Resource
    RestTemplate restTemplate;//需要支持负载均衡
    //远程调用其他接口的方式：RestTemplate restTemplate=new RestTemplate();
    //public final String paymentStr_url = "http://localhost:8001";//访问 支付微服务的网址(暂时固定硬编码)
    public final String paymentStr_url = "http://cloud-payment-service";//访问 支付微服务的网址(暂时固定硬编码)



   /* @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水方法")
    public ResultData<String> addPay(@org.springframework.web.bind.annotation.RequestBody Pay pay) {*/

    @PostMapping("/pay/add")
    @Operation(summary = "新增", description = "新增一条订单信息")
    public ResultData addOrder(@RequestBody Pay pay) {
        System.out.println(pay);
        //这是使用restful方式的远程调用接口的方式
        //前端请求地址：/consumer/pay/add 然后直接访问地址为：http//localhost:8001/pay/add
        return restTemplate.postForObject(paymentStr_url + "/pay/add", pay, ResultData.class);
    }


    @GetMapping("/pay/getById/{id}")
    @Operation(summary = "查询", description = "查询一条订单数据")
    public ResultData getOrderById(@PathVariable(value = "id") Integer id) {

        //这是使用restful方式的远程调用接口的方式
        //前端请求地址：/consumer/pay/add 然后直接访问地址为：http//localhost:8001/pay/getById/{id}
        //这里注意id需要直接+拼接形参
        return restTemplate.getForObject(paymentStr_url + "/pay/getById/" + id, ResultData.class, id);
    }


    @GetMapping(value = "/pay/getInfo")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(paymentStr_url + "/pay/getInfo", String.class);
    }


}
