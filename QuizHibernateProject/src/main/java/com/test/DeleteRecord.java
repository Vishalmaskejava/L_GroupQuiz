package com.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteRecord {
	
	private static int id;
	static Scanner sc = new Scanner(System.in);
	static boolean flag=true;
	public static void delete() {
		
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		Configuration cfg = new Configuration();
		cfg.configure("delete.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter id");
		id=sc.nextInt();
		
		InsertStudent is= (InsertStudent) session.get(InsertStudent.class, id);
		if(is==null) {
			flag=false;
			try {
				VerifyInput.verifyToDelete(flag);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				Application.selectOperation();
				
			}
		}else {
			
					
		session.delete(is);
		System.out.println("Record deleted successfully");
		
		}
		transaction.commit();
		session.close();
		factory.close();
		
		Application.selectOperation();

	}

}
