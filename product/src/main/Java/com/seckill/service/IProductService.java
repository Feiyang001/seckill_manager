package com.seckill.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.entity.Product;
import com.seckill.util.AnswerCode;

import java.util.Map;

public interface IProductService extends IService<Product> {

    public AnswerCode gerProduct(Map<String, Object> map);

    public AnswerCode updateStock(Map<String, Object> map) throws Exception;
}
