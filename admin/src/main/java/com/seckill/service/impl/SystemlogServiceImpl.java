package com.seckill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Systemlog;
import com.seckill.mapper.SystemlogMapper;
import com.seckill.service.ISystemlogService;
import org.springframework.stereotype.Service;

@Service
public class SystemlogServiceImpl extends ServiceImpl<SystemlogMapper, Systemlog> implements ISystemlogService {

}
