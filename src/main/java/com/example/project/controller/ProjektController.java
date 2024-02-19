package com.example.project.controller;

import com.example.project.entity.Projekt;
import com.example.project.service.ProjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projekte")
public class ProjektController {

    private ProjektService projektService;

    @Autowired
    public ProjektController (ProjektService projektService ){
        this.projektService = projektService;
    }

    @GetMapping({"","/"})
    public String getProjekte(Model theModel) {
        List<Projekt> meineProjekte = projektService.findAll();
        theModel.addAttribute("projekt", meineProjekte);
        return "/projekte/projekt";
    }


    @GetMapping("/anlegen")
    public String showForm(Model theModel) {
        Projekt projekt = new Projekt();
        theModel.addAttribute("projekt", projekt);
        return "/projekte/projekt-anlegen";
    }

    @PostMapping("/save")
    public String saveProjekt(@ModelAttribute("projekt") Projekt projekt) {
        projektService.save(projekt);
        return "redirect:/projekte";
    }

    @GetMapping("/update")
    public String projektUpdate(@RequestParam("projektId")int id, Model theModel){
        Projekt projekt = projektService.findById(id);

        theModel.addAttribute("projekt", projekt);

        return "/projekte/projekt-anlegen";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("projektid") int theId) {
        projektService.deleteById(theId);
        return "redirect:/projekte";
    }


}
