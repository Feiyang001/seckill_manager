package com.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Product;
import com.seckill.mapper.ProductMapper;
import com.seckill.service.IProductService;
import com.seckill.util.AnswerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {


    @Autowired
    private ProductMapper mapper;


    @Override
    public AnswerCode gerProduct(Map<String, Object> map) {
        return AnswerCode.success("success",mapper.selectByMap(map));
    }

    @Override
    public AnswerCode updateStock(Map<String, Object> map) throws Exception {
        int i = mapper.updateStock(map);
        if (i==0){
            throw new Exception("库存不足");
        }
        return AnswerCode.success("success");
    }
}
