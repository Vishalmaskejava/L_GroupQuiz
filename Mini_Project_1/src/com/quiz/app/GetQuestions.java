package com.quiz.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class GetQuestions {
	static int count;
	static int right;
	static int wrong;
	static Connection con = ConnectionProvider.CreateConnection();

	public static void Question(ArrayList al) {
		//System.out.println(al);

	try {
		
		
		String query = ("Select Question from Quiz where Q_no='"+al.get(0)+"'");
		//String query2 = "select correctAnswer from Quiz where Q_no=2";
		
		java.sql.Statement stmt = con.createStatement();
		
		
		ResultSet set = stmt.executeQuery(query);
		
		
		while(set.next()) {
			String question = set.getString(1);
			
			System.out.println("\tQ."+question+"\n");
			System.out.println();
			validate(al);
				
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	 
	}
	public static void validate(ArrayList al) {
		Scanner sc = new Scanner(System.in);
		String correctAnswer=null;
		try {
			
		//	Connection con = ConnectionProvider.CreateConnection();
			String query1 = ("Select correctAnswer from Quiz where Q_no ='"+al.get(0)+"'");
			java.sql.Statement stmt1 = con.createStatement();
			ResultSet set1 = stmt1.executeQuery(query1);
			while(set1.next()) {
				correctAnswer = set1.getString(1);
			//	System.out.println(correctAnswer);		
			}
			System.out.println("\tenter your answer:");
			String studentAnswer = sc.next();
			if(correctAnswer.equals(studentAnswer)) {
				System.out.println("\nRight");
				right++;
			}else {
				System.out.println("\nWrong\n");
				System.out.println("Correct Answer is:"+correctAnswer);
				System.out.println();
				wrong++;
			}
			count++;
			if(count<10) {
				al.remove(0);
				Question(al);
			}else {
				try {
					System.out.println("Your score is :"+right+" out of 10");
					StudentInfo.insertMarks(right);
					right=0;
					count=0;
					Start.showOptions();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
