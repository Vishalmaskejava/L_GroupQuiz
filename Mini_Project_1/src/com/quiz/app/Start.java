package com.quiz.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
//import java.util.Scanner;

public class Start {
	
	public static void showOptions() throws IOException {
		
		System.out.println("Welcome to quiz");
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		while(true) {
			
			try {
				System.out.println("Press 1 to play Quiz");
				System.out.println("Press 2 to see marks");
				System.out.println("Press 3 to see all students' marks");
				System.out.println("Press 4 to sort students according to marks");
				System.out.println("Press 5 to exit the app");
				int choice =Integer.parseInt(br.readLine()) ;
				System.out.println();
				
				if(choice==1) {
					//get student Info b
					StudentInfo.getStudentInfo();
					//insert it into table            
					//call quiz method
					
					//hash set
					int min=1;
					int max=10;
					
					LinkedHashSet<Integer> set = new LinkedHashSet<>();
					
					while(set.size()!=10) {
						int b=(int)(Math.random()*(max-min+1)+min);
						set.add(b);
					}
					ArrayList al = new ArrayList<>();
					al.addAll(set);
					
					//System.out.println(al);
					GetQuestions.Question(al);
					
				}else if(choice==2){
					//fetch marks of his/her id
					ShowStudentsMarks.showSingleStudentsMarks();
					
				}else if(choice==3) {
					
					//show students table
					ShowAllStudentsMarks.ShowAllMarks();
					
				}else if(choice==4) {
					
					//sort students according to marks
					SortByMarks.ShowSorted();
					
				}else if(choice==5) {
					
					System.out.println("Thank you for using this app");
					System.out.println("See you again, Bye !!");
					break;
					
				}else {
					
					System.out.println("Invalid Choice");
					System.out.println("Please choose again\n");
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			showOptions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
