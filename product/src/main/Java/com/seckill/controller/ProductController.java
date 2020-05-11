package com.seckill.controller;

import com.seckill.service.IProductService;
import com.seckill.util.AnswerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {


    @Autowired
    IProductService service;

    @RequestMapping("/getProduct")
    public AnswerCode getProduct(@RequestParam Map<String,Object> map){

        return service.gerProduct(map);
    }


    @RequestMapping("/updateStock")
    public AnswerCode updateStock(@RequestParam Map<String,Object> map) throws Exception{
            return service.updateStock(map);

    }
}
