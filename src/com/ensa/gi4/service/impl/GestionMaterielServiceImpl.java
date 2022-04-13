package com.ensa.gi4.service.impl;

import java.util.Scanner;

import com.ensa.gi4.datatabase.DAOFactory;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionChaiseService;
import com.ensa.gi4.service.api.GestionLivreService;
import com.ensa.gi4.service.api.GestionMaterielService;


public class GestionMaterielServiceImpl implements GestionMaterielService {

	private DAOFactory daoFactory;
    private GestionLivreService GLS;
    private GestionChaiseService GCS;
	
    public GestionMaterielServiceImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    	this.GLS = new GestionLivreServiceImpl(daoFactory);
    	this.GCS = new GestionChaiseServiceImpl(daoFactory);
    	init();
    }
	
    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
    	System.out.println("Livres :");
        for(Livre l : daoFactory.getListLivres())
        {
            System.out.println(" "+l.getName());
        }
        System.out.println("Chaises :");
        for(Chaise c : daoFactory.getListChaises())
        {
            System.out.println(" "+c.getName());
        }
    }
    
    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        System.out.print("Entrer le nom du materiel : ");
    	Scanner sc = new Scanner(System.in);
        String nom = sc.next();
    	if(materiel instanceof Livre){
    		GLS.ajouterNouveauLivre(nom);
    	}else if(materiel instanceof Chaise) {
    		GCS.ajouterNouveauChaise(nom);
    	}
        System.out.println("L'ajout du matériel " + materiel.getName() + " effectué avec succés !");
    }

	@Override
	public void chercherMateriel(String name) {
		boolean resultLivres = GLS.chercherLivre(name);
		boolean resultChaises = GCS.chercherChaise(name);
		System.out.println(" Livre trouvé : "+ resultLivres +"\n Chaise trouvée : "+ resultChaises);
	}

	@Override
	public void modifierMateriel(String name, String type) {
		if(type.equals("Livre")) {
			GLS.modifierLivre(name);
		} else if(type.equals("Chaise")) {
			GCS.modifierChaise(name);
		}
	}
	
	@Override
	public void supprimerMateriel(String name, String type) {
		if(type.equals("Livre")) {
			GLS.supprimerLivre(name);
		} else if(type.equals("Chaise")) {
			GCS.supprimerChaise(name);
		}
	}
	
    public void setGestionLivreService(GestionLivreService gestionLivreService) {
        this.GLS = gestionLivreService;
    }

    public void setGestionChaiseService(GestionChaiseService gestionChaiseService) {
        this.GCS = gestionChaiseService;
    }
}
