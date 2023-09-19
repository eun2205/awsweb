package com.aws.web.springboot.web;

import com.aws.web.springboot.web.dto.HelloResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResDto(name, amount);
    }
}
