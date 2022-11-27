package com.cydeo.controller;


import com.cydeo.dto.CourseDTO;

import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/courses")
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
    public CourseDTO getCourseById (@PathVariable("id") Long id){

        // return all courses

        return courseService.getCourseById(id);

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




 /*   @PostMapping
  //  @ResponseBody
    public void createCourse() (){

        return "view";

    }*/


}
