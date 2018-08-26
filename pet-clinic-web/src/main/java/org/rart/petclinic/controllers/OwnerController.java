package org.rart.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"","/owner-index","/index.html"})
    public String getOwnerList(){
        return "owners/owner-index";
    }
}
