package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void init();
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void chercherMateriel(String name);
    void modifierMateriel(String name, String type);
    void supprimerMateriel(String name, String type);
}