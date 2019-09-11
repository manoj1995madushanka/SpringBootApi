package com.example.secondChance.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    /*private List<Topics> list = new ArrayList<>(Arrays.asList(
            new Topics("senuri","science","face cute"),
            new Topics("sachini","science","too fat"),
            new Topics("helani","codegen","too crazy")
    ));*/

    public List<Topics> getAllTopics(){
        //return this.list;
        List<Topics> topics= new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topics getTopic(String id){

        // return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topics topic){
        //this.list.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topics topic){
        /*for(int i=0; i< list.size();i++){
            Topics t = list.get(i);
            if(t.getId().equals(id)){
                list.set(i,topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        // list.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}

