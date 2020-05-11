package com.seckill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Privilege;
import com.seckill.mapper.PrivilegeMapper;
import com.seckill.service.IPrivilegeService;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl extends ServiceImpl<PrivilegeMapper, Privilege> implements IPrivilegeService {

}
