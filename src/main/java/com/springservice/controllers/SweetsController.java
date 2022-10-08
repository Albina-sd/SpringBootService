package com.springservice.controllers;

import com.springservice.models.Sweets;
import com.springservice.services.implementations.SweetsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * конфеты и их типы
 */

@Controller
public class SweetsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SweetsServiceImpl sweetsService;

    @GetMapping(value = "/sweets")
    public String getSweets(Model model){
        List<Sweets> sweets = sweetsService.findAll();

        model.addAttribute("sweets", sweets);

        return "sweets-list";
    }

    @GetMapping(value = "/sweets/{sweetId}")
    public String getSweetsById(Model model, @PathVariable long sweetId){
        Sweets sweet = null;

        try{
            sweet = sweetsService.findById(sweetId);
            model.addAttribute("allowDelete", false);
        } catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }

        model.addAttribute("sweet",sweet);
        return "sweetInf";
    }

    //ToDo исправить проблему с добавлением (boolean значения)
    @GetMapping(value = "/sweets/add")
    public String showAddSweet(Model model){
        Sweets sweet = new Sweets();

        model.addAttribute("add", true);
        model.addAttribute("sweet", sweet);

        return "sweet-edit";
    }

    @PostMapping(value = "/sweets/add")
    public String addSweet(Model model, @ModelAttribute("sweet") Sweets sweet){
        try{
            Sweets newSweet = sweetsService.save(sweet);
            return "redirect:/sweets/"+String.valueOf(newSweet.getId());

        } catch (Exception ex){

            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            return "sweet-edit";
        }
    }

    //ToDo проблема аффектится и на изменение записи о конфете
    @GetMapping(value = {"sweets/{sweetId}/edit"})
    public String showEditSweet(Model model, @PathVariable long sweetId){
        Sweets sweet = null;

        try{
            sweet = sweetsService.findById(sweetId);
        } catch (Exception ex){

            model.addAttribute("errorMessage", ex.getMessage());
        }

        model.addAttribute("add", false);
        model.addAttribute("sweet", sweet);

        return "sweet-edit";
    }

    @PostMapping(value = "sweets/{sweetId}/edit")
    public String updateSweet(Model model, @PathVariable long sweetId, @ModelAttribute("sweet") Sweets sweet){
        try {
            sweet.setId(sweetId);
            sweetsService.update(sweet);

            return "redirect:/sweets/" + String.valueOf(sweet.getId());

        } catch (Exception ex){

            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            return "sweet-edit";
        }
    }

    @GetMapping(value = "/sweets/{sweetId}/delete")
    public String showDeleteSweetById(Model model, @PathVariable long sweetId){
        Sweets sweet = null;

        try {
            sweet = sweetsService.findById(sweetId);
        }catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("sweet", sweet);

        return "sweetInf";
    }

    @PostMapping(value = "sweets/{sweetId}/delete")
    public String deleteSweetById(Model model, @PathVariable long sweetId){
        try{
            sweetsService.deleteById(sweetId);

            return "redirect:/sweets";

        }catch (Exception ex){
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            return "sweetInf";
        }
    }

}
