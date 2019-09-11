package com.example.secondChance.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*private List<Topics> list = new ArrayList<>(Arrays.asList(
            new Topics("senuri","science","face cute"),
            new Topics("sachini","science","too fat"),
            new Topics("helani","codegen","too crazy")
    ));*/

    public List<Course> getAllCourses(String id){
        //return this.list;
        List<Course> courses= new ArrayList<>();
        courseRepository.findByTopicId(id).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){

        // return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course){
        //this.list.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course){
        /*for(int i=0; i< list.size();i++){
            Topics t = list.get(i);
            if(t.getId().equals(id)){
                list.set(i,topic);
                return;
            }
        }*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        // list.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
