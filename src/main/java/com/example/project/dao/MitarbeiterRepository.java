package com.example.project.dao;

import com.example.project.entity.Mitarbeiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Integer> {
}
