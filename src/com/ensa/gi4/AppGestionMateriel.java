package com.ensa.gi4;

import com.ensa.gi4.controller.GestionMaterielController;
import com.ensa.gi4.database.DAOFactory;
import com.ensa.gi4.database.DAOFactoryImpl;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Livre;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class AppGestionMateriel {
    private static final ApplicationContext APPLICATION_CONTEXT;
    
    static { // bloc static pour initilialisation
    	//APPLICATION_CONTEXT = new ClassPathXmlApplicationContext("/beans/app-context.xml");
        APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = APPLICATION_CONTEXT.getBean(DAOFactoryImpl.class);
        final GestionMaterielController gestionMaterielController = APPLICATION_CONTEXT.getBean(GestionMaterielController.class);
        final ApplicationPublisher publisher = APPLICATION_CONTEXT.getBean(ApplicationPublisher.class);
        publisher.publish(new MyEvent<>(new Livre(), EventType.ADD));
        while (true) { // pour que l'appliation tourne jusqu'à la demande de l'utilisateur de l'arrêter
            gestionMaterielController.afficherMenu();
        }

    }
}
