package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetAllStudents {
	
	public static void getAll() {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		Configuration cfg = new Configuration();
		cfg.configure("getInfo.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query=session.createQuery("from InsertStudent");
		List list = query.list();
		Iterator<InsertStudent> iterator = list.iterator();
		System.out.println("=====================================");
		System.out.println("Id"+"\t"+"name"+"\t\t"+"marks"+"\t"+"Grade"+"\t"+"Result");
		while(iterator.hasNext()) {
			InsertStudent istd = (InsertStudent) iterator.next();
			int marks = istd.getMarks();
			String grade = null;
			String result=null;
			if(marks>=8) {
				grade="A";result="PASS";
			}else if(marks>=6 && marks<8) {
				grade="B";result="PASS";
			}else if(marks>=3 && marks<6) {
				grade="C";result="PASS";
			}else {
				grade="D";result="FAIL";
			}
			System.out.println(istd.getId()+"\t"+istd.getName()+"\t\t"+istd.getMarks()+"\t"+grade+"\t"+result);
		}
		System.out.println("======================================");

		transaction.commit();
		session.close();
		factory.close();
		
		//GetSortedMarks.getSorted();
		Application.selectOperation();
	}

}
