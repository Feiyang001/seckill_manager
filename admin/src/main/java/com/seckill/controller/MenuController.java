package com.seckill.controller;

import com.seckill.service.IMenuService;
import com.seckill.util.AnswerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;
    @RequestMapping("/getMenu")
    public AnswerCode getMenu(){

        return menuService.getMenu();
    }


    @RequestMapping("/getOrder")
    public AnswerCode getOrder(@RequestParam Map<String,Object> map){

        return menuService.getOrder(map);
    }



}
