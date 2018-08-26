package org.rart.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value={"/",""})
    public  String getHomePage(){
        return "index.html";
    }

}
