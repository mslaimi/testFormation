package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmprunteurRepository;
import com.example.demo.dao.OuvrageRepository;
import com.example.demo.model.Chercheur;
import com.example.demo.model.Emprunteur;
import com.example.demo.model.Enseignant;
import com.example.demo.model.Etudiant;
import com.example.demo.model.Ouvrage;

@Service
public class EmprunteurService {

	private EmprunteurRepository emprunteurRepo;
	private OuvrageRepository ouvrageRepo;

	public boolean verifierLimiteEmprunt(String nom, String prenom) {
		Emprunteur em = emprunteurRepo.findByNomAndPrenom(nom, prenom);
		if (em != null) {
			em.verifierLimite();
		}
		return true;
	}

	public boolean enregistrerEmprunt(String nom, String prenom, String type, int ouvrage) {
		Emprunteur em = emprunteurRepo.findByNomAndPrenom(nom, prenom);
		Ouvrage ouv = ouvrageRepo.findById(ouvrage).get();
		{
			if (em == null) {
				if (type.toUpperCase() == "ENSEIGNANT") {
					em = new Enseignant();
					em.setNom(nom);
					em.setPrenom(prenom);
					emprunteurRepo.save(em);
					((Enseignant) em).setCurrentEmp(1);
				} else if (type.toUpperCase() == "CHERCHEUR") {
					em = new Chercheur();
					emprunteurRepo.save(em);
				} else if (type.toUpperCase() == "ETUDIANT") {
					em = new Etudiant();
					emprunteurRepo.save(em);
				}
				// enregistrer emprunt
			} else {
				if (em.verifierLimite()) {
					// enregistrer emprunt;
				}

			}
		}

		return false;
	}

	public boolean ajouterEmprunteur(String nom, String prenom, String type) {
		Emprunteur em = emprunteurRepo.findByNomAndPrenom(nom, prenom);
		if (em == null) {
			if (type.toUpperCase() == "ENSEIGNANT") {
				em = new Enseignant();
			} else if (type.toUpperCase() == "CHERCHEUR") {
				em = new Chercheur();
			} else if (type.toUpperCase() == "ETUDIANT") {
				em = new Etudiant();
			}
			// enregistrer emprunt
		} else return false;
		
		em.setNom(nom);
		em.setPrenom(prenom);
		emprunteurRepo.save(em);
		emprunteurRepo.flush();

		return true;
	}

}
