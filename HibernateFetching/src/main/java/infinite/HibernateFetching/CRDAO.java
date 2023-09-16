package infinite.HibernateFetching;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

import jakarta.persistence.PersistenceException;

import java.util.*;
import java.lang.Exception;

public class CRDAO {

	public static void main(String[] args) throws PersistenceException, HibernateException  {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    Session session = factory.openSession();  
    Transaction t = session.beginTransaction();  
    CR e1=new CR();    
   
	System.out.println("successfully saved");    
	    

	}
}
