package com.test.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return this.topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable("id") String id){
        return this.topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value= "topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
    public void deleteTopic(@PathVariable("id") String id){
        topicService.deleteTopic(id);
    }
}
