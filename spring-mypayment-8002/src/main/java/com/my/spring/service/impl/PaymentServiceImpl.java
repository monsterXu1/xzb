package com.my.spring.service.impl;

import com.my.common.entity.PaymentEntity;
import com.my.spring.dao.PaymentDao;
import com.my.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 86155 on 2020/8/30.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int creat(PaymentEntity paymentEntity) {
        return paymentDao.creat(paymentEntity);
    }

    @Override
    public PaymentEntity getById(long id) {
        return paymentDao.getById(id);
    }
}
