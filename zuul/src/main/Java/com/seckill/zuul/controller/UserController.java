package com.seckill.zuul.controller;

import com.seckill.zuul.feginClientService.AdminFeginService;
import com.seckill.zuul.util.AnswerCode;
import com.seckill.zuul.util.CookieUtil;
import com.seckill.zuul.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    AdminFeginService adminFeginService;


    @RequestMapping("/login")
    public  Object login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(username)){
            return AnswerCode.error("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)){
            return AnswerCode.error("密码不能为空");
        }
        AnswerCode user = adminFeginService.getUser(username);
        if (user==null){
            return AnswerCode.error("用户不存在");
        }
        Map<String,String> mapUser = (Map<String,String>)user.get(AnswerCode.DATA_KEY);
        String userPassword = mapUser.get("password");
        if (!password.equals(userPassword)){
            return AnswerCode.error("密码不正确");
        }
        String s = CookieUtil.setLoginCookie(request, response);
        redisUtil.set(s,mapUser);
        return AnswerCode.success();
    }


    @RequestMapping("/getUser")
    public  Object getUser(HttpServletRequest request){

        return AnswerCode.success("success",CookieUtil.getLoginCookie(request));
    }

}
