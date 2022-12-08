package com.test;

import java.util.ArrayList;



import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ImportQuestions {
	static String answer;
	static int score=0;
	static int id;
	static String name;
	static boolean status;
	static boolean flag=true;
	static boolean nameflag=true;
	
	public static void showQuestions() {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		Scanner sc = new Scanner(System.in);

		//System.out.println("Step 1");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		//System.out.println("Step 2");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=10;i++) {
			list.add(i);
			
		}
		Collections.shuffle(list);
		//System.out.println(list);
		//System.out.println("Step 3");
		while(nameflag==true) {
		System.out.println("Enter your name:");
		name=sc.next();
		try {
			VerifyInput.verifyName(name);
			nameflag=false;
		} catch (InvalidInputException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		//	continue;
		}	
		}
		nameflag=true;
		while(flag==true) {
			System.out.println("Enter id");
			id = sc.nextInt();
		InsertStudent is = (InsertStudent) session.get(InsertStudent.class, id);
		if(is!=null) {
			System.out.println("Id already present");
			continue;
		}else {
		flag=false;
		}
		}
		flag=true;
		for(int i=0;i<10;i++) {
		QuestionBank question=(QuestionBank)session.get(QuestionBank.class, list.get(i));
		System.out.println(question);
		try {
		System.out.println("Write your answer here:");
		answer = sc.next();
		
		VerifyInput.verify(answer);
		}catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			/*
			 * while(status==false) {
			 * if(answer.equals("a")||answer.equals("b")||answer.equals("c")||answer.equals(
			 * "d")) { status=true;
			 * 
			 * }else { System.out.println("please select valid choice"); answer = sc.next();
			 * } }
			 */
			i--;
			continue;
		}
		if(answer.equalsIgnoreCase(question.getCorrectAnswer())){
			score++;
		}
		//list.remove(0);
		}
		session.close();
		factory.close();
		
		System.out.println("Your score is:"+score);
		
		InsertStudent.insert(id, name, score);
		score=0;
		Application.selectOperation();
		
		//Transaction transaction = session.beginTransaction();
		//session.save(is);
		//transaction.commit();
		
		
	}

}
