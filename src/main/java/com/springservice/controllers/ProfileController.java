package com.springservice.controllers;

import com.springservice.DTO.UserDTO;
import com.springservice.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(ModelMap model, Authentication authentication){
        if (authentication == null) {
            return "redirect:/login";
        }

        System.out.println(authentication);
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDTO user = UserDTO.from((details.getUsers()));
        model.addAttribute("user", user);

        return "profile";
    }
}
