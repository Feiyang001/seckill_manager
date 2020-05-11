package com.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.entity.Menu;
import com.seckill.entity.MenuTree;
import com.seckill.feginService.OrderServiceClient;
import com.seckill.mapper.MenuMapper;
import com.seckill.service.IMenuService;
import com.seckill.util.AnswerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    OrderServiceClient orderServiceClient;

    @Override
    public AnswerCode getMenu() {
        return AnswerCode.success("success",getRootMenu());
    }

    @Override
    public AnswerCode getOrder(Map<String,Object> map) {
        return orderServiceClient.getOrder(map.get("page"),map.get("limit"));
    }

    public List<MenuTree> getRootMenu(){
        Map<String,Object> map = new HashMap<>();
        map.put("pid","0");
        List<Menu> menus = menuMapper.selectByMap(map);
        List<MenuTree> list = new ArrayList<>();
        for (Menu menu : menus) {
            MenuTree menuTree1 = new MenuTree();
            menuTree1.setId(menu.getId()+"");
            menuTree1.setHref(menu.getUrl());
            menuTree1.setName(menu.getName());
            list.add(menuTree1);
            getChildMenu(menuTree1);
        }
        return list;
    }

    public  void getChildMenu(MenuTree menuTree){
        String id = menuTree.getId();
        Map<String,Object> map = new HashMap<>();
        map.put("pid",id);
        List<Menu> menus = menuMapper.selectByMap(map);
        for (Menu menu : menus) {
            menuTree.initChild();
            MenuTree menuTree1 = new MenuTree();
            menuTree1.setId(menu.getId()+"");
            menuTree1.setHref(menu.getUrl());
            menuTree1.setName(menu.getName());
            menuTree.getChildren().add(menuTree1);
            getChildMenu(menuTree1);
        }
    }

}
