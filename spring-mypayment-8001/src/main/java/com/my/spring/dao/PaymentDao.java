package com.my.spring.dao;

import com.my.common.entity.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 86155 on 2020/8/30.
 */
@Mapper
//@Repository          ----mybatis下推荐mapper
public interface PaymentDao  {
    public int creat(PaymentEntity paymentEntity);

    public PaymentEntity getById(long id);
}
