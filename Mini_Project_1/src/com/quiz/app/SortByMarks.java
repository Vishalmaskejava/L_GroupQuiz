package com.quiz.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SortByMarks {
	static Connection con = ConnectionProvider.CreateConnection();
	static int count;
	public static void ShowSorted() {
		
		try {
			String query = ("select *from Students order by marks desc;");
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			System.out.println("List Sorted by marks in descending order:");
			System.out.println();
			System.out.println("\tid"+"\tname\t"+"\tmarks");
			while(set.next()) {
				System.out.println("\t"+set.getString(1)+"\t"+set.getString(2)+"\t"+set.getString(3));
				count++;
			}
			if(count==0) {
				System.out.println("No students have attempted quiz yet");
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
