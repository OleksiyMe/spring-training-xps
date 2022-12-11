package com.cydeo.controller;


import com.cydeo.dto.CourseDTO;

import com.cydeo.service.CourseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/courses/api/v1")
public class CourseController {


    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;

    }

    @GetMapping
 //   @ResponseBody
    public List<CourseDTO> getAllCourses (){

        // return all courses
//courseRepository.save();
        return courseService.getCourses();

    }

    @GetMapping("{id}")
    //   @ResponseBody
    public CourseDTO getCourseById (@PathVariable("id") Long courseId){

        // return all courses

        return courseService.getCourseById(courseId);

    }

    @GetMapping("/category/{category}")
    //   @ResponseBody
    public List<CourseDTO> getCourseById (@PathVariable("category") String category){

        return courseService.getCoursesByCategory(category);
        
    }

    @PostMapping()
    //   @ResponseBody
    public CourseDTO createCourse (@RequestBody CourseDTO course){

        return courseService.createCourse(course);

    }

    @PutMapping("{id}")
    //   @ResponseBody
    public void updateCourse (@PathVariable("id") Long courseID,@RequestBody CourseDTO course){

        courseService.updateCourse(courseID,course);

    }

    @DeleteMapping("{id}")
    //   @ResponseBody
    public void deleteCourseById (@PathVariable("id") Long id){

        courseService.deleteCourseById(id);

    }






}
