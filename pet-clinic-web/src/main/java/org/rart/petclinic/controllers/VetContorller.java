package org.rart.petclinic.controllers;

import org.rart.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetContorller {

    private final VetService vetService;

    @Autowired
    public VetContorller(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/vet-index","/vets/vet-index.html"})
    public  String getVetsList(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/vet-index.html";
    }
}
