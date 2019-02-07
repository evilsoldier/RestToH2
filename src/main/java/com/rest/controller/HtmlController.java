package com.rest.controller;

import com.rest.repository.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlController {

    private final PersonService personService;

    @Autowired
    private HtmlController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/person")
    public String person(Model model, @RequestParam(value = "id", defaultValue = "1") Long id) {
        model.addAttribute("person", personService.findById(id));
        return "person";
    }

    @GetMapping("/persons")
    public String persons(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "persons";
    }

    @GetMapping(value = "/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }

}
