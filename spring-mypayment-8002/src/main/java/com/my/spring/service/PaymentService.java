package com.my.spring.service;

import com.my.common.entity.PaymentEntity;

/**
 * Created by 86155 on 2020/8/30.
 */
public interface PaymentService {
    public int creat(PaymentEntity paymentEntity);

    public PaymentEntity getById(long id);
}
