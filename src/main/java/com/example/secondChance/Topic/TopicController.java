package com.example.secondChance.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topics> getAllTopics(){
        return this.topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topics getTopic(@PathVariable("id") String id){
        return this.topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "topics")
    public void addTopic(@RequestBody Topics topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value= "topics/{id}")
    public void updateTopic(@RequestBody Topics topic, @PathVariable("id") String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
    public void deleteTopic(@PathVariable("id") String id){
        topicService.deleteTopic(id);
    }
}

