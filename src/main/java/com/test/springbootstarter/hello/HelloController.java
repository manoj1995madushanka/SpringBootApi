package com.test.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // requestMapping defalt map to get method and if u need other methods u need to specify them
    @RequestMapping("/hello")
    public String sayHi(){
        return "hi";
    }
}
