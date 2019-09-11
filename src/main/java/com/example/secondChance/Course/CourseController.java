package com.example.secondChance.Course;

import com.example.secondChance.Topic.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){

        return this.courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable("id") String id){
        return this.courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topics(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value= "topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable("id") String id){
        course.setTopic(new Topics(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable("id") String id){
        courseService.deleteCourse(id);
    }
}
