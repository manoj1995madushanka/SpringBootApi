package com.test.springbootstarter.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic("senuri","science","face cute"),
                new Topic("sachini","science","too fat"),
                new Topic("helani","codegen","too crazy")
        );
    }
}
