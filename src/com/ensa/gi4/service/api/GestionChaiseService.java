package com.ensa.gi4.service.api;

public interface GestionChaiseService {
	
	int listerChaise();
    void ajouterNouveauChaise(String name);
    void modifierChaise(String name);
    void supprimerChaise(String name);
}
