package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.List;
import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }
    
    public void ajouterNouveauMateriel(Materiel materiel) {
    	gestionMaterielService.ajouterNouveauMateriel(materiel);
    }
    
    public void chercherMateriel(String name) {
		gestionMaterielService.chercherMateriel(name);
    }
    
    public void modifierMateriel(String name, String type) {
    	gestionMaterielService.modifierMateriel(name, type);
    } 
    
    public void supprimerMateriel(String name, String type) {
    	gestionMaterielService.supprimerMateriel(name, type);
    }
   

    public void afficherMenu() {
        System.out.println("1- pour lister le materiel, entrer 1");
        System.out.println("2- pour ajouter un nouveau materiel, entrer 2");
        System.out.println("3- pour chercher un materiel, entrer 3");
        System.out.println("4- pour modifier un materiel, entrer 4");
        System.out.println("5- pour supprimer un  materiel, entrer 5");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            System.out.println("1- pour ajouter un livre, entrer 1");
            System.out.println("2- pour ajouter une chaise, entrer 2");
        	Scanner sc = new Scanner(System.in);
            String materiel = sc.next();
            Materiel m;
            if("1".equals(materiel)) {
            	m = new Livre();
            	ajouterNouveauMateriel(m);
            }else if("2".equals(materiel)) {
            	m = new Chaise();
            	ajouterNouveauMateriel(m);
            }
        } else if("3".equals(next)) {
        	System.out.print("Entrer le nom du materiel : ");
        	Scanner sc = new Scanner(System.in);
            String name = sc.next();
            chercherMateriel(name);
        } else if("4".equals(next)) {
        	System.out.println("1- pour modifier un livre, entrer 1");
            System.out.println("2- pour modifier une chaise, entrer 2");        	Scanner scType = new Scanner(System.in);
            String type = scType.next();
        	System.out.print("Entrer le nom du materiel : ");
        	Scanner sc = new Scanner(System.in);
            String name = sc.next();
            if("1".equals(type)) {
            	modifierMateriel(name, "Livre");
            } else if("2".equals(type)) {
            	modifierMateriel(name, "Chaise");
            } else {
            	System.out.println("Choix invalide !!!");
            }
        } else if("5".equals(next)) {
            System.out.println("1- pour supprimer un livre, entrer 1");
            System.out.println("2- pour supprimer une chaise, entrer 2");        	
            Scanner scType = new Scanner(System.in);
            String type = scType.next();
        	System.out.print("Entrer le nom du materiel : ");
        	Scanner sc = new Scanner(System.in);
            String name = sc.next();
            if("1".equals(type)) {
            	supprimerMateriel(name, "Livre");
            } else if("2".equals(type)) {
            	supprimerMateriel(name, "Chaise");
            } else {
            	System.out.println("Choix invalide !!!");
            }
        } else {
            System.out.println("Choix invalide !!!");
        }
    }

	private void sortirDeLApplication() {
        System.exit(0);
    }

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
