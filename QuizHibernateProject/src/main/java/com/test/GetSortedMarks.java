package com.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetSortedMarks {
	
	public static void getSorted() {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		
		Configuration cfg = new Configuration();
		cfg.configure("getInfo.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query=session.createQuery("from InsertStudent");
		List list = query.list();
		
		Collections.sort(list);
		
		Iterator<InsertStudent> iterator = list.iterator();
		System.out.println("=====================================================");

		System.out.println("Id"+"\t"+"name"+"\t"+"marks");
		while(iterator.hasNext()) {
			InsertStudent istd = (InsertStudent) iterator.next();
			System.out.println(istd.getId()+"\t"+istd.getName()+"\t"+istd.getMarks());
		}
		System.out.println("=====================================================");

		
		//Collections.sort(list);
		
		//System.out.println(list);
		
		
		transaction.commit();
		session.close();
		factory.close();
		Application.selectOperation();
	}

}
