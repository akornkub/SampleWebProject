package com.jas.jpa.controller;

import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jas.common.dao.DaoUtil;

@WebListener
public class SampleWebContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent event) {
        DaoUtil.setEntityManagerFactory(Persistence.createEntityManagerFactory("UserProfilePersistenceUnit"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    	DaoUtil.closeEntityManagerFactory();
    }
}
