package com.my.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 86155 on 2020/8/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResults<T> {
    private Integer code;
    private String msg;
    private  T data;

    public CommonResults(Integer code, String msg){
        this(code,msg,null);

    }
}
