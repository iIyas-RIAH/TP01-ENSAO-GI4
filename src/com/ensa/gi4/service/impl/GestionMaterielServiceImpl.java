package com.ensa.gi4.service.impl;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ensa.gi4.database.DAOFactory;
import com.ensa.gi4.database.DAOFactoryImpl;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionChaiseService;
import com.ensa.gi4.service.api.GestionLivreService;
import com.ensa.gi4.service.api.GestionMaterielService;

@Service
public class GestionMaterielServiceImpl implements GestionMaterielService {

	@Qualifier("DAOFactory")
	private DAOFactory daoFactory;
	@Qualifier("LivreServiceBean")
    private GestionLivreService GLS;
	@Qualifier("ChaiseServiceBean")
    private GestionChaiseService GCS;
	
	@Autowired
	public GestionMaterielServiceImpl(DAOFactoryImpl daoFactoryImpl){
        this.daoFactory = daoFactoryImpl;
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

}
