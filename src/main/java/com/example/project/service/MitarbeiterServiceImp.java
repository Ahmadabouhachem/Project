package com.example.project.service;

import com.example.project.dao.MitarbeiterRepository;
import com.example.project.entity.Mitarbeiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MitarbeiterServiceImp implements MitarbeiterService{

    private MitarbeiterRepository mitarbeiterRepository;


    @Autowired
    public  MitarbeiterServiceImp(MitarbeiterRepository mitarbeiterRepository){
    this.mitarbeiterRepository = mitarbeiterRepository;
    }

    @Override
    public List<Mitarbeiter> findAll() {
        return mitarbeiterRepository.findAll();
    }

}
