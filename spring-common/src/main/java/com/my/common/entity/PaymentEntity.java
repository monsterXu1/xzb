package com.my.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by 86155 on 2020/8/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity implements Serializable {
    private String myname;
    private String age;
    private long id;
}
