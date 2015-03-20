package com.jas.myweb;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UserProfileListener
 *
 */
@WebListener
public class MyWebContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public MyWebContextAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         System.out.println("attributeAdded: " + event.getName());
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	System.out.println("attributeRemoved: " + event.getName());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	System.out.println("attributeReplaced: " + event.getName());
    }
	
}
