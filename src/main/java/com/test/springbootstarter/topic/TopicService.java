package com.test.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> list = new ArrayList<>(Arrays.asList(
            new Topic("senuri","science","face cute"),
            new Topic("sachini","science","too fat"),
            new Topic("helani","codegen","too crazy")
    ));

    public List<Topic> getAllTopics(){
        return this.list;
    }

    public Topic getTopic(String id){
        return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        this.list.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for(int i=0; i< list.size();i++){
            Topic t = list.get(i);
            if(t.getId().equals(id)){
                list.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        list.removeIf(t -> t.getId().equals(id));
    }
}
