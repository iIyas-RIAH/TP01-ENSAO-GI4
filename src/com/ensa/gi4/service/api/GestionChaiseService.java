package com.ensa.gi4.service.api;

public interface GestionChaiseService {
    void init();
	void listerChaise();
    void ajouterNouveauChaise(String name);
    boolean chercherChaise(String name); 
    void modifierChaise(String name);
    void supprimerChaise(String name);
}
