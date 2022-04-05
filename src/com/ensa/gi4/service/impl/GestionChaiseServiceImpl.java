package com.ensa.gi4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.service.api.GestionChaiseService;

public class GestionChaiseServiceImpl implements GestionChaiseService{

	private List<Chaise> Chaises;
	
	public void init() {
    	Chaises = new ArrayList<>();
    }
	
	public int listerChaise() {
		return Chaises.size();
	}
	
    public void ajouterNouveauChaise(String nom) {
    	Chaise chaise = new Chaise();
    	chaise.setName(nom);
		Chaises.add(chaise);
    }
    
    public boolean chercherChaise(String nom) {
    	return Chaises.stream()
			   .filter(item -> item.getName().equals(nom))
			   .findFirst().orElse(null) != null;
    }
    
	public void modifierChaise(String name) {
		boolean trouve = false;
		if(Chaises.size()==0) {
			System.out.println("Pas de chaise");
		} else {
			ListIterator<Chaise> iterator = Chaises.listIterator();
			while (iterator.hasNext()) {
			    Chaise next = iterator.next();
			    if (next.getName().equals(name)) {
			    	System.out.print("Entrer le nouveau nom du materiel : ");
			    	Scanner sc = new Scanner(System.in);
			        String nom = sc.next();
			        trouve = true;
			        next.setName(nom);
			    }
			}
			if(trouve==false) {
				System.out.println("Cette chaise n'existe pas dans la collection");
			}
		}
	}

	public void supprimerChaise(String name) {
		Chaise chaise = null;
		if(Chaises.size()==0) {
			System.out.println("Pas de chaise");
		} else {
			for(Chaise C : Chaises) {
				if(C.getName().equals(name)) {
					chaise = C;
				}
			}
			if(chaise==null) {
				System.out.println("Cette chaise n'existe pas dans la collection");
			} else {
				Chaises.remove(chaise);
			}
		}
	}
}
