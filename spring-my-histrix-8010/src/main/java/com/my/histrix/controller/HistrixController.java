package com.my.histrix.controller;

import com.my.histrix.service.HistrixServiceImpl;
import com.my.histrix.service.Histrixservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HistrixController {

    @Resource
    private Histrixservice histrixService;

    @GetMapping("/get_histrix_ok")
    public String get_histrix_ok(){
        return  histrixService.histrix_ok(1);
    }
    @GetMapping("/get_histrix_timeout")
    public String get_histrix_timeout(){
        return  histrixService.histrix_timeout(1);
    }
}
