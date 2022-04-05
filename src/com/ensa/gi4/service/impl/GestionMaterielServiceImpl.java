package com.ensa.gi4.service.impl;

import java.util.Scanner;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;


public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here	
	GestionLivreServiceImpl GLSI = new GestionLivreServiceImpl();
	GestionChaiseServiceImpl GCSI = new GestionChaiseServiceImpl();
	
	public GestionMaterielServiceImpl() {
		init();
	}
	
    @Override
    public void init() {
    	GLSI.init();
    	GCSI.init();
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        System.out.println("Liste de mat�riel :\n "+ GLSI.listerLivre() +" Livres \n "+ GCSI.listerChaise() +" Chaises");
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        System.out.print("Entrer le nom du materiel : ");
    	Scanner sc = new Scanner(System.in);
        String nom = sc.next();
    	if(materiel instanceof Livre){
    		GLSI.ajouterNouveauLivre(nom);
    	}else if(materiel instanceof Chaise) {
    		GCSI.ajouterNouveauChaise(nom);
    	}
        System.out.println("L'ajout du mat�riel " + materiel.getName() + " effectu� avec succ�s !");
    }

	@Override
	public void chercherMateriel(String name) {
		boolean resultLivres = GLSI.chercherLivre(name);
		boolean resultChaises = GCSI.chercherChaise(name);
		System.out.println(" Livre trouv� : "+ resultLivres +"\n Chaise trouv�e : "+ resultChaises);
	}

	@Override
	public void modifierMateriel(String name, String type) {
		if(type.equals("Livre")) {
			GLSI.modifierLivre(name);
		} else if(type.equals("Chaise")) {
			GCSI.modifierChaise(name);
		}
	}
	
	@Override
	public void supprimerMateriel(String name, String type) {
		if(type.equals("Livre")) {
			GLSI.supprimerLivre(name);
		} else if(type.equals("Chaise")) {
			GCSI.supprimerChaise(name);
		}
	}
}
