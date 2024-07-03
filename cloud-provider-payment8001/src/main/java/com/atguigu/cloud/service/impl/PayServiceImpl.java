package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xj
 * @version: 2024/6/9
 * @description:
 */
@Service
public class PayServiceImpl implements PayService {


    @Resource
    PayMapper mapper;

    @Override
    public int addPay(Pay pay) {
        int i = mapper.insertSelective(pay);
        return i;
    }

    @Override
    public int deletePay(Integer id) {
        int i = mapper.deleteByPrimaryKey(id);

        return i;
    }

    @Override
    public int updatePayDto(PayDTO paydto) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(paydto, pay);
        int i = mapper.updateByPrimaryKeySelective(pay);
        return i;
    }

    @Override
    public Pay getById(Integer id) {
        Pay pay = mapper.selectByPrimaryKey(id);
        return pay;
    }

    @Override
    public List<Pay> getAll() {
        List<Pay> pays = mapper.selectAll();
        return pays;
    }
}
