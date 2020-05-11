package com.seckill.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.User;
import com.seckill.mapper.UserMapper;
import com.seckill.service.IUserService;
import com.seckill.util.AnswerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public AnswerCode getUser(Map<String,Object> map) {
        List<User> users = userMapper.selectByMap(map);
        if (users.size()>0){
            return AnswerCode.success("success",users.get(0));
        }
        return AnswerCode.success("success",null);
    }
}
