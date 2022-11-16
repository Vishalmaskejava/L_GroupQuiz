package com.quiz.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class StudentInfo {
	
	static int id;
	static String name;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Connection con = ConnectionProvider.CreateConnection();
	
	public static void getStudentInfo() throws IOException {

		System.out.println("Enter your name");
		name= br.readLine();
		System.out.println("Enter your ID");
		id = Integer.parseInt(br.readLine());
		insertStudentInfo();
	}
	
	public static void insertStudentInfo() {
		
		try {
			Connection con = ConnectionProvider.CreateConnection();
			String query = "insert into Students (id,name) values (?,?)";
			PreparedStatement pstmt =  con.prepareStatement(query);
			
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertMarks(int marks) {
		try {
			Connection con = ConnectionProvider.CreateConnection();
			String query = ("update Students set marks='"+marks+"'where id='"+id+"'");
			PreparedStatement pstmt =  con.prepareStatement(query);
			
		//	pstmt.setInt(1,marks);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
