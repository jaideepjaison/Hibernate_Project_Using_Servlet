package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDAO {
	SessionFactory sf;
	Session session;
	public List<PersonData> showEmploy() {
		SessionFactory sf = SessionHelper.getSession();
		Session session =sf.openSession();
		Query q = session.createQuery("from Person");
		List<PersonData> employList = q.list();
		return employList;
}
}