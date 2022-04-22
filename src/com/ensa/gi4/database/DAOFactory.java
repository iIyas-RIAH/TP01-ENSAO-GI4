package com.ensa.gi4.database;

import java.util.List;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;

public interface DAOFactory {

	public List<Livre> getListLivres();
	public List<Chaise> getListChaises();
	public void setListLivres(List<Livre> listLivres);
	public void setListChaises(List<Chaise> listChaises);
}
