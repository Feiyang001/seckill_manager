package com.seckill.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.entity.Product;

import java.util.Map;

public interface ProductMapper extends BaseMapper<Product> {
    public int updateStock(Map<String, Object> map);
}
