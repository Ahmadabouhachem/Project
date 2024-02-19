package com.example.project.dao;

import com.example.project.entity.Aufgabe;
import com.example.project.entity.Projekt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AufgabeRepository extends JpaRepository<Aufgabe, Integer> {
}
