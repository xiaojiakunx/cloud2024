package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xj
 * @version: 2024/6/9
 * @description:
 */
@RestController
@RequestMapping("/pay")
@Tag(name = "支付微服务模块", description = "支付微服务的crud") //swagger的注解
public class PayController {
    @Resource
    private PayService payService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水方法")
    public ResultData<String> addPay(@RequestBody Pay pay) {

        System.out.println(pay);
        int i = payService.addPay(pay);

        return ResultData.success("新增数据成功");
    }

    @DeleteMapping(value = "/del/{id}")
    @Operation(summary = "删除", description = "删除指定id的方法")
    public String deletePay(@PathVariable(value = "id") Integer id) {
        return "删除成功：" + payService.deletePay(id);
    }

    @PostMapping("/update")
    @Operation(summary = "更新", description = "更是pay数据方法")
    public String updatePay(@RequestBody PayDTO payDTO) {
        int i = payService.updatePayDto(payDTO);
        return "更新成功";
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "查询", description = "查询指定id的数据")
    public ResultData<Pay> getById(@PathVariable(value = "id") Integer id) throws Exception {
        /*if (-4 == id) {
            throw new Exception("不能为负数");
        }*/
        Pay byId = payService.getById(id);
        System.out.println("port:"+port);
        return ResultData.success(byId);
    }


    @GetMapping("/getInfo")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo){     // @Value("${atguigu.info}")  代表我们写入consul中的key 然后获取 value
        System.out.println(atguiguInfo);
        return "atguiguInfo:"+atguiguInfo+"/t"+"port:"+port;
    }

}
