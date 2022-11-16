package com.springservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //ToDo почему не отображается картинка?
    @GetMapping(value = "/index")
    public String index(Model model) {

        return "index";
    }
}
