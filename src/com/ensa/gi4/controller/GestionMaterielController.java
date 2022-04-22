package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.impl.GestionMaterielServiceImpl;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public GestionMaterielController() {}
	
    @Autowired
	public GestionMaterielController(GestionMaterielService materielServiceBean) {
        this.gestionMaterielService = materielServiceBean;
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
        	gestionMaterielService.listerMateriel();
        } else if ("2".equals(next)) {
            System.out.println("1- pour ajouter un livre, entrer 1");
            System.out.println("2- pour ajouter une chaise, entrer 2");
        	Scanner sc = new Scanner(System.in);
            String materiel = sc.next();
            Materiel m;
            if("1".equals(materiel)) {
            	m = new Livre();
            	gestionMaterielService.ajouterNouveauMateriel(m);
            }else if("2".equals(materiel)) {
            	m = new Chaise();
            	gestionMaterielService.ajouterNouveauMateriel(m);
            }
        } else if("3".equals(next)) {
        	System.out.print("Entrer le nom du materiel : ");
        	Scanner sc = new Scanner(System.in);
            String name = sc.next();
            gestionMaterielService.chercherMateriel(name);
        } else if("4".equals(next)) {
        	System.out.println("1- pour modifier un livre, entrer 1");
            System.out.println("2- pour modifier une chaise, entrer 2");        	
            Scanner scType = new Scanner(System.in);
            String type = scType.next();
        	System.out.print("Entrer le nom du materiel : ");
        	Scanner sc = new Scanner(System.in);
            String name = sc.next();
            if("1".equals(type)) {
            	gestionMaterielService.modifierMateriel(name, "Livre");
            } else if("2".equals(type)) {
            	gestionMaterielService.modifierMateriel(name, "Chaise");
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
            	gestionMaterielService.supprimerMateriel(name, "Livre");
            } else if("2".equals(type)) {
            	gestionMaterielService.supprimerMateriel(name, "Chaise");
            } else {
            	System.out.println("Choix invalide !!!");
            }
        } else {
            System.out.println("Choix invalide !!!");
        }
        System.out.println("------------------------------------------------------");
    }

	private void sortirDeLApplication() {
        System.exit(0);
    }
	

}