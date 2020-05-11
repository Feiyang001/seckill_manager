package com.seckill.zuul.feginClientService;


import com.seckill.zuul.util.AnswerCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("server-admin")
public interface AdminFeginService {


    @RequestMapping("/user/getUser")
    public AnswerCode getUser(@RequestParam("username") String username);
}
