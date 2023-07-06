package com.connection;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConnection {

		public static SessionFactory factory;
		public static SessionFactory getfactory()
		{	
		Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory() ;
		
		return factory;
		}
		
		public void closeFactory()
		{
			if(factory.isOpen())
			{
				factory.close();
			}
		}
	

	
}
