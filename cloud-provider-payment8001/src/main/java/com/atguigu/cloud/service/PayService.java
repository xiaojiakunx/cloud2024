package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author: xj
 * @version: 2024/6/9
 * @description:
 */
public interface PayService {
    public int addPay(Pay pay);

    public int deletePay(Integer id);

    public int updatePayDto(PayDTO pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();

}
