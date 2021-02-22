package com.my.histrixFeigne.service;

import org.springframework.stereotype.Component;

@Component
public class FailBackService implements HsitrixFeignService {
    @Override
    public String get_histrix_timeout() {
        return "-----------HsitrixFeignService----";
    }

    @Override
    public String get_histrix_ok() {
        return "-----------HsitrixFeignService----";
    }
}
