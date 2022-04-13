package com.ensa.gi4.datatabase;

import java.util.ArrayList;
import java.util.List;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

public class DAOFactory {

	private List<Livre> Livres = new ArrayList<>();
	private List<Chaise> Chaises = new ArrayList<>();

	public DAOFactory()
    {      
        Livre l1 = new Livre();
        l1.setName("livre1");
        Livre l2 = new Livre();
        l2.setName("livre2");
        
        Chaise c1 = new Chaise();
        c1.setName("chaise1");
        Chaise c2 = new Chaise();
        c2.setName("chaise2");

        Livres.add(l1);
        Livres.add(l2);
        Chaises.add(c1);
        Chaises.add(c2);
    }
	
	public List<Livre> getListLivres() {
		return Livres;
    }
	
	public List<Chaise> getListChaises() {
		return Chaises;
    }

    public void setListLivres(List<Livre> listLivres) {
    	this.Livres = listLivres;
    }
    
    public void setListChaises(List<Chaise> listChaises) {
    	this.Chaises = listChaises;
    }
}
