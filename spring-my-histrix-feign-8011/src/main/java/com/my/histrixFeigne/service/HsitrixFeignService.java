package com.my.histrixFeigne.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "service-histrix-8010",fallback = FailBackService.class)
public interface HsitrixFeignService {

    @GetMapping("/get_histrix_timeout")
    public String get_histrix_timeout();


    @GetMapping("/get_histrix_ok")
    public String get_histrix_ok();
}
