package com.springservice.controllers;


import com.springservice.models.Storehouses;
import com.springservice.services.implementations.StorehousesServiceImpl;
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
 * Склады конфет
 */

@Controller
public class StorehousesController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StorehousesServiceImpl storehousesService;

    @GetMapping(value="/storehouses")
    public String getStorehouses(Model model){
        List<Storehouses> storehouses = storehousesService.findAll();

        model.addAttribute("storehouses", storehouses);

        return "storehouse-list";
    }

    @GetMapping(value = "/storehouses/{storehouseId}")
    public String getStorehousesById(Model model, @PathVariable long storehouseId){
        Storehouses storehouse = null;

        try{
            storehouse = storehousesService.findById(storehouseId);
            model.addAttribute("allowDelete", false);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }

        model.addAttribute("storehouse", storehouse);
        return "storehouseInf";
    }

    @GetMapping(value = {"/storehouses/add"})
    public String showAddStorehouse(Model model){
        Storehouses storehouse = new Storehouses();

        model.addAttribute("add", true);
        model.addAttribute("storehouse", storehouse);

        return "storehouse-edit";
    }

    @PostMapping(value = "/storehouses/add")
    public String addStorehouse(Model model, @ModelAttribute("storehouse") Storehouses storehouse){
        try {
            Storehouses new_storehouse = storehousesService.save(storehouse);
            return "redirect:/storehouses/" + String.valueOf(new_storehouse.getId());

        } catch (Exception ex){

            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);

            return "storehouse-edit";
        }
    }

    @GetMapping(value = {"storehouses/{storehouseId}/edit"})
    public String showEditStorehouse(Model model, @PathVariable long storehouseId){
        Storehouses storehouse = null;

        try {
            storehouse = storehousesService.findById(storehouseId);

        } catch (Exception ex){

            model.addAttribute("errorMessage", ex.getMessage());
        }

        model.addAttribute("add", false);
        model.addAttribute("storehouse", storehouse);

        return "storehouse-edit";
    }

    @PostMapping(value = "storehouses/{storehouseId}/edit")
    public String updateStorehouse(Model model, @PathVariable long storehouseId, @ModelAttribute("storehouse") Storehouses storehouse){
        try {
            storehouse.setId(storehouseId);
            storehousesService.update(storehouse);

            return "redirect:/storehouses/" + String.valueOf(storehouse.getId());
        } catch (Exception ex){


            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            return "storehouse-edit";
        }
    }

    @GetMapping(value = {"storehouses/{storehouseId}/delete"})
    public String showDeleteStorehouseById(Model model, @PathVariable long storehouseId){
        Storehouses storehouse = null;

        try {
            storehouse = storehousesService.findById(storehouseId);

        } catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
        }

        model.addAttribute("allowDelete", true);
        model.addAttribute("storehouse", storehouse);

        return "storehouseInf";
    }

    @PostMapping(value = "storehouses/{storehouseId}/delete")
    public String deleteStorehouseById(Model model, @PathVariable long storehouseId){
        try {
            storehousesService.deleteById(storehouseId);

            return "redirect:/storehouses";

        } catch (Exception ex){
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            return "storehouseInf";
        }
    }

}
