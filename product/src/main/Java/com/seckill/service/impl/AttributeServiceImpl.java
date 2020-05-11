package com.seckill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Attribute;
import com.seckill.mapper.AttributeMapper;
import com.seckill.service.IAttributeService;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl extends ServiceImpl<AttributeMapper, Attribute> implements IAttributeService {

}
