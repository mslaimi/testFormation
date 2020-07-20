package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Emprunteur;
import com.example.demo.model.Ouvrage;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer> {
	//Ouvrage findById(int id);
}
