package com.seckill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Catalog;
import com.seckill.mapper.CatalogMapper;
import com.seckill.service.ICatalogService;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl extends ServiceImpl<CatalogMapper, Catalog> implements ICatalogService {

}
