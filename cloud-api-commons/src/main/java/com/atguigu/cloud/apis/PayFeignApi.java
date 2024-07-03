package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: xj
 * @version: 2024/6/10
 * @description:
 */
@FeignClient(value = "cloud-payment-service") //这里是注册中心中的服务
public interface PayFeignApi {
    /**
     * Resilience4j CircuitBreaker 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);


    /**
     * 这里的访问路径｜参数｜方法名必须与 生产者保持一致！！
     *
     * @param pay
     * @return
     */
    @PostMapping("/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay);

    @DeleteMapping(value = "/pay/del/{id}")
    public String deletePay(@PathVariable(value = "id") Integer id);

    @PostMapping("/pay/update")
    @Operation(summary = "更新", description = "更是pay数据方法")
    public String updatePay(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/getById/{id}")
    @Operation(summary = "查询", description = "查询指定id的数据")
    public ResultData<Pay> getById(@PathVariable(value = "id") Integer id);


    @GetMapping("/pay/getInfo")
    public String getInfoByConsul();
}
