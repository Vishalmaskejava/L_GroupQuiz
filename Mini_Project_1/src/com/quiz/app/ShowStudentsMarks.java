package com.quiz.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowStudentsMarks {
	
	static Connection con = ConnectionProvider.CreateConnection();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int id;
	static int marks;
	static String name;
	static String grade;
	static int count;
	public static void showSingleStudentsMarks() throws NumberFormatException, IOException {
		
		try {
			System.out.println("Enter your id to see marks");
			id = Integer.parseInt(br.readLine());
			String query = ("select marks from Students where id='"+id+"'");
			java.sql.Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			while(set.next()) {
			 marks = set.getInt(1);
			 count++;
			}
			if(count==0) {
				//System.out.println("\nNo records found of this id,please try again\n");
			}else
			if(marks>=8) {
				grade = "A";
			}else if(marks>=6&&marks<8) {
				grade = "B";
			}else if(marks>=5&&marks<6) {
				grade = "C";
			}else {
				grade = "D";
			
			}
			 ShowMarks();
			// System.out.println(marks);
			
		//	System.out.println("Hi Mr/Mrs "+name+",your score is "+marks+" out of 10");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public static void ShowMarks() {
		try {
			String query1 = ("select name from Students where id ='"+id+"'");	
			java.sql.Statement stmt = con.createStatement();
			ResultSet set1 = stmt.executeQuery(query1);
			while(set1.next()) {
			name = set1.getString(1);
			}
			if(count!=0) {
			System.out.println("\nHello Mr/Mrs. "+name+",your score is "+marks+" out of 10");
			System.out.print("Your grade is "+grade);
			if(grade.equalsIgnoreCase("D")) {
				System.out.println("    Status: FAIL");
			}else {
				System.out.println("    Status: PASS");
			}
			System.out.println();
			}else {
				System.out.println("\nNo records found of this id,please try again\n");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
