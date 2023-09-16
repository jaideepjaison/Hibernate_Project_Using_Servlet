package com.java.hib;

import java.util.List;

//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;




public class PersonShow {
	public static void main(String[] args) {
		SessionFactory sf = SessionHelper.getSession();
		Session session =sf.openSession();
		Query q = session.createQuery("from Employ");
		List<PersonData> employList = q.list();
		for (PersonData employ : employList) {
			System.out.println(employ);
		}
	}

}
