package com.seckill.feginService;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("server-product")
public interface ProductServiceClient {

}
