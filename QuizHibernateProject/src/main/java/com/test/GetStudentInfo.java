package com.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.persistence.Entity;
import java.io.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentInfo {
	
	private static int id;
	private static boolean idflag=true;
	static int marks;
	static Scanner sc = new Scanner(System.in);
	//public static final String ANSI_RED = "\u001B[31m";
	//public static final String ANSI_RESET = "\u001B[0m";
	public static void getInformation() {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		
		
		Configuration cfg = new Configuration();
		cfg.configure("getInfo.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		while(idflag==true) {
			System.out.println("Enter your id");
			id = sc.nextInt();
			InsertStudent is = (InsertStudent) session.get(InsertStudent.class, id);
			if(is==null) {
				System.out.println("\nID not present");
				continue;
			}else {
				System.out.println("==================================================");
				System.out.println(is);
				marks=is.getMarks();
				idflag=false;
			}
		}
		idflag=true;
		String grade=null;
		//final String ANSI_RESET = "\u001B[0m";
		//final String ANSI_RED_BACKGROUND= "\u001B[41m";
		if(marks>=8) {
			System.out.println(" Grade=A \t Result=PASS");
		}else if(marks>=6 && marks<8) {
			System.out.println(" Grade=B \t Result=PASS");
		}else if(marks>=3 && marks<=5) {
			System.out.println(" Grade=C \t Result=PASS");
		}else if(marks<3) {
			System.out.println(" Grade=D \t Result=FAIL");
		}
		System.out.println("=====================================================");

		session.close();
		factory.close();
		
		Application.selectOperation();
		
	} 

}
