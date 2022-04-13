package com.ensa.gi4.service.impl;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.ensa.gi4.datatabase.DAOFactory;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionLivreService;

public class GestionLivreServiceImpl implements GestionLivreService{

    private DAOFactory daoFactory;

    public GestionLivreServiceImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }
    
    @Override
    public void init() {}

    @Override
    public void listerLivre() {}
	
    public void ajouterNouveauLivre(String nom) {
        List<Livre> Livres = daoFactory.getListLivres();
    	Livre livre = new Livre();
        livre.setName(nom);
    	Livres.add(livre);
    	daoFactory.setListLivres(Livres);
    }
    
    public boolean chercherLivre(String nom) {
        List<Livre> Livres = daoFactory.getListLivres();
    	return Livres.stream()
		       .filter(item -> item.getName().equals(nom))
			   .findFirst().orElse(null) != null;
    }
    
	public void modifierLivre(String name) {
        List<Livre> Livres = daoFactory.getListLivres();
		boolean trouve = false;
		if(Livres.size()==0) {
			System.out.println("Pas de livres");
		} else {
			ListIterator<Livre> iterator = Livres.listIterator();
		while (iterator.hasNext()) {
		    Livre next = iterator.next();
		    	if (next.getName().equals(name)) {
				   	System.out.print("Entrer le nouveau nom du materiel : ");
				   	Scanner sc = new Scanner(System.in);
				    String nom = sc.next();
				    trouve = true;
				    next.setName(nom);
				}
			}
			if(trouve==false) {
				System.out.println("Ce livre n'existe pas dans la collection");
			}
		}
    	daoFactory.setListLivres(Livres);
	}

	public void supprimerLivre(String name) {
        List<Livre> Livres = daoFactory.getListLivres();
		Livre livre = null;
		if(Livres.size()==0) {
			System.out.println("Pas de livres");
		} else {
			for(Livre L : Livres) {
				if(L.getName().equals(name)) {
					livre = L;
				}
			}
			if(livre==null) {
				System.out.println("Ce livre n'existe pas dans la collection");
			} else {
				Livres.remove(livre);
			}
		}
    	daoFactory.setListLivres(Livres);
	}

}
