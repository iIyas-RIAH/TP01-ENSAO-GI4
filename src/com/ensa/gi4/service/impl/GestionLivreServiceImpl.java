package com.ensa.gi4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionLivreService;

public class GestionLivreServiceImpl implements GestionLivreService{

	private List<Livre> Livres;
	
	public void init() {
        Livres = new ArrayList<>();
    }
	
	public int listerLivre() {
		return Livres.size();
	}
	
    public void ajouterNouveauLivre(String nom) {
    	Livre livre = new Livre();
        livre.setName(nom);
    	Livres.add(livre);
    }
    
    public boolean chercherLivre(String nom) {
    	return Livres.stream()
		       .filter(item -> item.getName().equals(nom))
			   .findFirst().orElse(null) != null;
    }
    
	public void modifierLivre(String name) {
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
	}

	public void supprimerLivre(String name) {
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
	}

}
