package com.sys.springbootsentine;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
      * @Auther: willow
      * @Date: 2019/5/7 17:42
      * @Description:
      */
 @RestController
 public class SentinelController {
 @RequestMapping("/test")
 @SentinelResource(value = "test", blockHandler = "handleException")
 public String sentinel(){
return "sentinel ....";
}
 @RequestMapping("/hello")
 public String hello(){
  return "sentinel  hello....";
 }

 @GetMapping(value = "/index")
 @SentinelResource(value = "test", blockHandler = "handleException")
 public String test() {
  return "Hello TestResource";
 }

 // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
 public String handleException(BlockException ex) {
  return "handleException";
 }







}