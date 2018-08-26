package org.rart.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetContorller {

    @RequestMapping({"/vets", "/vets/vet-index","/vets/vet-index.html"})
    public  String getVetsList(){
        return "vets/vet-index.html";
    }
}
