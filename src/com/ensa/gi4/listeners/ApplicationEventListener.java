package com.ensa.gi4.listeners;

import com.ensa.gi4.database.DAOFactoryImpl;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.impl.GestionMaterielServiceImpl;


import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener<T extends Materiel> implements ApplicationListener<MyEvent<T>> {
    
	private DAOFactoryImpl daoFactoryImpl;
	private GestionMaterielService GMSI = new GestionMaterielServiceImpl(daoFactoryImpl);
	
	@Override
    public void onApplicationEvent(MyEvent<T> event) {
        System.out.println("Event triggered");
        System.out.println("event.getEventType() = " + event.getEventType());
        System.out.println("event.getSource() = " + event.getSource());
        //GMSI.ajouterNouveauMateriel((Materiel) event.getSource());  Une exception de type java.lang.NullPointerException
    }
}
