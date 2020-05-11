package com.seckill.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.entity.Menu;
import com.seckill.util.AnswerCode;

import java.util.Map;

public interface IMenuService extends IService<Menu> {

    public AnswerCode getMenu();

    public AnswerCode getOrder(Map<String, Object> map);

}
