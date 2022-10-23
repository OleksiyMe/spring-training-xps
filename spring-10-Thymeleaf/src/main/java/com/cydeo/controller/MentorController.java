package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {


    //   @RequestMapping(value = "/register", method = RequestMethod.GET) //localhost:8080/mentor/register
    @GetMapping("/register")
    public String register(Model model) {

        List<String> batchList = new ArrayList<>(Arrays.asList("JD1", "JD2", "JD3"));
        model.addAttribute("batchList", batchList);

        model.addAttribute("mentor", new Mentor());

        return "mentor/mentor-register";
    }


    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor  ) {
     //how to access mentor attribute in this method


   return "redirect:/mentor/register";

        //     return "/mentor/mentor-confirmation";
    }

  /*  @GetMapping("/confirm")
    public String submitForm2() {

        return "/mentor/mentor-confirmation";
    }*/

}
