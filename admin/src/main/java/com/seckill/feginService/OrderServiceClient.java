package com.seckill.feginService;


import com.seckill.util.AnswerCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("server-order")
public interface OrderServiceClient {

    @RequestMapping("/getOrder")
    public AnswerCode getOrder(@RequestParam("page") Object page, @RequestParam("limit") Object limit);

}
