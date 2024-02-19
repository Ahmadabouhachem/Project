package com.example.project.dao;

import com.example.project.entity.Projekt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjektRepository extends JpaRepository<Projekt, Integer> {
}
