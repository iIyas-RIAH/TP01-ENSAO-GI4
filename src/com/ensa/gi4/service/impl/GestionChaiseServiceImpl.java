package com.ensa.gi4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.ensa.gi4.datatabase.DAOFactory;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionChaiseService;

public class GestionChaiseServiceImpl implements GestionChaiseService{

    private DAOFactory daoFactory;

    public GestionChaiseServiceImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }
    
    @Override
    public void init() {}

    @Override
    public void listerChaise() {}
	
    public void ajouterNouveauChaise(String nom) {
        List<Chaise> Chaises = daoFactory.getListChaises();
    	Chaise chaise = new Chaise();
    	chaise.setName(nom);
		Chaises.add(chaise);
    	daoFactory.setListChaises(Chaises);
    }
    
    public boolean chercherChaise(String nom) {
        List<Chaise> Chaises = daoFactory.getListChaises();
    	return Chaises.stream()
			   .filter(item -> item.getName().equals(nom))
			   .findFirst().orElse(null) != null;
    }
    
	public void modifierChaise(String name) {
        List<Chaise> Chaises = daoFactory.getListChaises();
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
    	daoFactory.setListChaises(Chaises);
	}

	public void supprimerChaise(String name) {
        List<Chaise> Chaises = daoFactory.getListChaises();
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
    	daoFactory.setListChaises(Chaises);
	}
}
