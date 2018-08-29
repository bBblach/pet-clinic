package org.rart.petclinic.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.rart.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    final static Logger logger = Logger.getLogger(OwnerController.class);
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
        logger.log(Priority.DEBUG, "owner service size " + ownerService.findAll());
    }

    @RequestMapping({"","/owner-index","/index.html"})
    public String getOwnerList(Model theModel){
        theModel.addAttribute("owners", this.ownerService.findAll());

        return "owners/owner-index";
    }
    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }
}
