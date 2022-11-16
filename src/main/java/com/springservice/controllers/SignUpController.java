package com.springservice.controllers;

import com.springservice.forms.UserForm;
import com.springservice.services.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }
    @PostMapping("/signUp")
    public String signUp(UserForm userForm){
        signUpService.signUp(userForm);
        return "redirect:/login";
    }
}
