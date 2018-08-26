package org.rart.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping({"owners","owners/owner-index","owners/index.html"})
    public String getOwnerList(){
        return "owners/owner-index.html";
    }
}
