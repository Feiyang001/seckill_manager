package com.seckill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Systemsetting;
import com.seckill.mapper.SystemsettingMapper;
import com.seckill.service.ISystemsettingService;
import org.springframework.stereotype.Service;

@Service
public class SystemsettingServiceImpl extends ServiceImpl<SystemsettingMapper, Systemsetting> implements ISystemsettingService {

}
