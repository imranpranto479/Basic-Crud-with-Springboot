package com.imranpranto.main.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.imranpranto.main.springmvc.model.Programmer;
import com.imranpranto.main.springmvc.repository.ProgrammerRepo;

@Controller
@ControllerAdvice
public class MainController {

    @Autowired
    ProgrammerRepo pr;

    @ModelAttribute
    public void welcome(Model m) {
        m.addAttribute("msg", "Welcome to Spring Boot Tutorial");
    }

    // @RequestMapping("/home")
    @GetMapping("/home")
    public String homePage() {
        return "HomePage.html";
    }

    // @RequestMapping(value="/addProgrammer", method=RequestMethod.POST)
    @PostMapping("/addProgrammer")
    public String addProgrammer(
            @ModelAttribute("p") Programmer programmer) { // for getting data @RequestParam

        // ModelAndView mv =new ModelAndView();

        // mv.setViewName("ProgrammerInfo.html");

        // return mv;

        // model.addAttribute("pName", n);
        // model.addAttribute("pId", i);
        // model.addAttribute("pLang", pLang);

        pr.save(programmer);

        return "ProgrammerInfo.html";
    }

    @GetMapping("/allProgrammer")
    public String allProgrammer(Model m){
        List<Programmer> p = new ArrayList<Programmer>();
        p.add((new Programmer(101, "karim", "Java")));
        p.add((new Programmer(102, "Rahim", "Python")));
        p.add((new Programmer(103, "Momin", "C#")));

        m.addAttribute("programmers", p);
        return "AllProgrammer.html";
    }
}
