package com.quiz.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowAllStudentsMarks {
	
	static Connection con = ConnectionProvider.CreateConnection();
	static int count;
	public static void ShowAllMarks() {
		try {
			String query = ("select *from Students;");
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			System.out.println("\tid\t"+"Name\t\t"+"\tMarks");
			while(set.next()) {
				System.out.println("\t"+set.getString(1)+" \t"+set.getString(2)+" \t\t"+set.getString(3));
				count++;
			}
			System.out.println();
			if(count==0) {
				System.out.println("No students have attempted Quiz yet");
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
