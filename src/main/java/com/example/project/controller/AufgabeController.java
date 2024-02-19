package com.example.project.controller;

import com.example.project.entity.Aufgabe;
import com.example.project.entity.Projekt;
import com.example.project.service.AufgabeService;
import com.example.project.service.ProjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aufgaben")
public class AufgabeController {

    private AufgabeService aufgabeService;

    @Autowired
    public AufgabeController(AufgabeService aufgabeService ){
        this.aufgabeService = aufgabeService;
    }

    @GetMapping({"","/"})
    public String getAufgaben(Model theModel) {
        List<Aufgabe> meineAufgaben = aufgabeService.findAll();
        theModel.addAttribute("aufgabe", meineAufgaben);
        return "/aufgaben/aufgabe";
    }


    @GetMapping("/anlegen")
    public String showForm(Model theModel) {
        Aufgabe aufgabe = new Aufgabe();
        theModel.addAttribute("aufgabe", aufgabe);
        return "/aufgaben/aufgabe-anlegen";
    }

    @PostMapping("/save")
    public String saveAufgabe(@ModelAttribute("aufgabe") Aufgabe aufgabe) {
        aufgabeService.save(aufgabe);
        return "redirect:/aufgaben";
    }

    @GetMapping("/update")
    public String aufgabeUpdate(@RequestParam("aufgabeId")int id, Model theModel){
        Aufgabe aufgabe = aufgabeService.findById(id);

        theModel.addAttribute("aufgabe", aufgabe);

        return "/aufgaben/aufgabe-anlegen";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("aufgabeId") int theId) {
        aufgabeService.deleteById(theId);
        return "redirect:/aufgaben";
    }


}
