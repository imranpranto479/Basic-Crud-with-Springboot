package com.imranpranto.main.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


        pr.save(programmer);

        return "redirect:/home";
    }

    @PostMapping("/findById")
    public String findById(@RequestParam int pId, Model m){
        Programmer p = pr.getReferenceById(pId);

        m.addAttribute("programmer", p);

        return "ProgrammerInfo.html";


    }

    @GetMapping("/deleteProgrammer")
    public String deleteProgrammer(@RequestParam int pId){
        pr.deleteById(pId);


        return "redirect:/home";


    }

    @PostMapping("/updateProgrammer")
    public String updateProgrammer(@ModelAttribute Programmer programmer){
        Programmer p = pr.getReferenceById(programmer.getpId());

        p.setpName(programmer.getpName());
        p.setpLang(programmer.getpLang());

        pr.save(p);


        return "ProgrammerInfo.html";


    }

}
