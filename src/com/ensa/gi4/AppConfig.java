package com.ensa.gi4;

import com.ensa.gi4.controller.GestionMaterielController;
import com.ensa.gi4.database.DAOFactoryImpl;
import com.ensa.gi4.service.api.GestionChaiseService;
import com.ensa.gi4.service.api.GestionLivreService;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.impl.GestionChaiseServiceImpl;
import com.ensa.gi4.service.impl.GestionLivreServiceImpl;
import com.ensa.gi4.service.impl.GestionMaterielServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.ensa.gi4")
public class AppConfig {

	@Bean(name = "DAOFactoryImpl")
	@Scope("singleton")
	public DAOFactoryImpl DaoFactory() {
        return new DAOFactoryImpl();
	}
	
    @Bean
    public GestionMaterielService MaterielServiceBean(DAOFactoryImpl DAOFI){
        return new GestionMaterielServiceImpl(DAOFI);
    }
    
    @Bean
    public GestionLivreService LivreServiceBean(DAOFactoryImpl DAOFI){
        return new GestionLivreServiceImpl(DAOFI);
    }
    
    @Bean
    public GestionChaiseService ChaiseServiceBean(DAOFactoryImpl DAOFI){
        return new GestionChaiseServiceImpl(DAOFI);
    }
    
    @Bean(name = "GestionMaterielController")
    @Lazy
    public GestionMaterielController gestionMaterielControllerBean(GestionMaterielService MaterielServiceBean){
        return new GestionMaterielController(MaterielServiceBean);
    }
}
