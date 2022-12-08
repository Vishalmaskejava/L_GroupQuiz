package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {
	
	public static void selectOperation() {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println();
			System.out.println("Press 1 to Play Quiz");
			System.out.println("Press 2 to See Marks");
			System.out.println("Press 3 to See All Students' marks");
			System.out.println("Press 4 to see Sorted Marks");
			System.out.println("Press 5 to Delete record");
			System.out.println("Press 6 to exit the app");
			
			int choice =Integer.parseInt(br.readLine());
			
			if(choice==1) {
				ImportQuestions.showQuestions();
			}else if(choice==2) {
				GetStudentInfo.getInformation();
			}else if(choice==3) {
				GetAllStudents.getAll();
			}else if(choice==4) {
				GetSortedMarks.getSorted();
			}else if(choice==5) {
				DeleteRecord.delete();
			}else if(choice==6){
				System.out.println("Thank you for using Quiz App");
			}else {
				System.out.println("Invalid choice,please choose correct option");
				selectOperation();
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Invalid input");
			selectOperation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Invalid input");

			selectOperation();

		}
	}
	
	public static void main(String[] args) {

		//Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		//ImportQuestions.getQuestions();
		System.out.println("Welcome to Quiz Application");
		selectOperation();

	}

}
