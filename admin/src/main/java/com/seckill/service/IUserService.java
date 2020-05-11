package com.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.entity.User;
import com.seckill.util.AnswerCode;

import java.util.Map;

public interface IUserService extends IService<User> {

    public AnswerCode getUser(Map<String, Object> map);

}
