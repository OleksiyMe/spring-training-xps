package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {

    @RequestMapping("/mentor")
    public String homepage(Model model) {

        Mentor mentor1 = new Mentor("Albert", "Smith", 22, Gender.MALE);
        Mentor mentor2 = new Mentor("Bill", "Jonnathan", 25, Gender.MALE);
        Mentor mentor3 = new Mentor("Ann", "Green", 24, Gender.FEMALE);

        model.addAttribute("mentor1", mentor1);
        model.addAttribute("mentor2", mentor2);
        model.addAttribute("mentor3", mentor3);
        return "/student/mentor";
    }


}
