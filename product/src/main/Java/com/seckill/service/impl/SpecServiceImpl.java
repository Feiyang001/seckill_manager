package com.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Spec;
import com.seckill.mapper.SpecMapper;
import com.seckill.service.ISpecService;
import org.springframework.stereotype.Service;

@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements ISpecService {

}
