package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
    return "home.html";  //end point amazon.com/login   (or register, or something)

    }


    @RequestMapping("/login")
    public String srg(){
        return "hereWeGo.html";  //end point amazon.com/login   (or register, or something)

    }

    @RequestMapping()
    public String asef(){
        return "hereWeGo.html";  //end point amazon.com/login   (or register, or something)

    }

}
