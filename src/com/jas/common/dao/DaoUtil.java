package com.jas.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DaoUtil {

	private static EntityManagerFactory entityManagerFactory;
	
	// Is called by ContextListener
	public static void setEntityManagerFactory(EntityManagerFactory emf) {
		entityManagerFactory = emf;
	}
	
	// Is called by ContextListener
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
	
	// Is called by REST service
    public static EntityManager createEntityManager() {
        if (entityManagerFactory == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return entityManagerFactory.createEntityManager();
    }
}
