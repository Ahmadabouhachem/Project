package com.example.project.service;

import com.example.project.dao.AufgabeRepository;
import com.example.project.dao.ProjektRepository;
import com.example.project.entity.Aufgabe;
import com.example.project.entity.Projekt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AufgabeServiceImpl implements AufgabeService{

    private AufgabeRepository aufgabeRepository;

    @Autowired
    public AufgabeServiceImpl(AufgabeRepository aufgabeRepository){
        this.aufgabeRepository = aufgabeRepository;
    }


    @Override
    public List<Aufgabe> findAll() {
        return aufgabeRepository.findAll();
    }
    @Override
     public Aufgabe save (Aufgabe aufgabe){
        return aufgabeRepository.save(aufgabe);
    }


    @Override
    public Aufgabe findById(int theId) {
        Optional<Aufgabe> result = aufgabeRepository.findById(theId);

        Aufgabe aufgabe = null;

        if (result.isPresent()) {
            aufgabe = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find projekt id: " + theId);
        }

        return aufgabe;
    }

    @Override
    public void deleteById(int theId) {
        aufgabeRepository.deleteById(theId);

    }


}
