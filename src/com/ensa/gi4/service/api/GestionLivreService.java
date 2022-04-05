package com.ensa.gi4.service.api;

public interface GestionLivreService {

	int listerLivre();
    void ajouterNouveauLivre(String name);
    boolean chercherLivre(String name); 
    void modifierLivre(String name);
    void supprimerLivre(String name);
}
