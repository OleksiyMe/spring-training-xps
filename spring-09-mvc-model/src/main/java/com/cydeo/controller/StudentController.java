package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homepage(Model model) {
        String name ="ABCD efg";

        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        String subject ="Spring boot";
        model.addAttribute("subject", subject);

        int studentID = new Random().nextInt();
        model.addAttribute("studentID", studentID);

        List<Integer> numbers =new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        model.addAttribute("numbers", numbers);

        LocalDate dt =LocalDate.now();
        model.addAttribute("date", dt);

        Student student =new Student(1,"Mike", "Smith");
        model.addAttribute("student",student);

        //method from Model Interface
        return"/student/welcome";
    }
}
