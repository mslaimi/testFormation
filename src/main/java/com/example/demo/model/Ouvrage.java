package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ouvrage {
	@Id
	private Integer Id;
	private String titre;
	private int nbExemplaireDisponible;
	private int nbEmpruntEncours;
}
