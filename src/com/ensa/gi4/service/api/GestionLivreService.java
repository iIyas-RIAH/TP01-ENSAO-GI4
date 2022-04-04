package com.ensa.gi4.service.api;


public interface GestionLivreService {

	int listerLivre();
    void ajouterNouveauLivre(String name);
    void modifierLivre(String name);
    void supprimerLivre(String name);
}
