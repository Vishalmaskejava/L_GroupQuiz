package com.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class InsertStudent implements Comparable <InsertStudent>{
	@Id
	private int id;
	private String name;
	private int marks;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getMarks() {
		return marks;
	}



	public void setMarks(int marks) {
		this.marks = marks;
	}

	


	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}



	public static void insert(int id,String name,int marks) {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		//System.out.println("Step 1");
		Configuration cfg = new Configuration();
		cfg.configure("insert.cfg.xml");
		//System.out.println("Step 2");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		InsertStudent is = new InsertStudent();
		is.setId(id);
		is.setName(name);
		is.setMarks(marks);
		session.save(is);
		transaction.commit();
		session.close();
		factory.close();
		//GetStudentInfo.getInformation();
		
	}



	public int compareTo(InsertStudent o) {
		// TODO Auto-generated method stub
		if(this.marks>o.marks) {
			return -1;
		}else if(this.marks<o.marks) {
			return 1;
		}
		return this.name.compareTo(o.name);
	}



	
	
	
	
}
