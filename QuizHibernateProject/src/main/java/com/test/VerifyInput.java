package com.test;

public class VerifyInput {
	
	public static void verify(String input) throws InvalidInputException {
		if(input.equals("a")||input.equals("b")||input.equals("c")||input.equals("d")) {
			System.out.println("Answer submitted successfully");
		}else {
			throw new InvalidInputException("Please enter valid input");		

		}
	}
	public static void verifyName(String name) throws InvalidInputException{
		char[] chars = name.toCharArray();
		for(char c:chars) {
			if(Character.isDigit(c)) {
				throw new InvalidInputException("Name can contain only characters");
			}
		}
	}
	
	public static void verifyToDelete(boolean flag) throws InvalidInputException {
		if(flag==false) {
			throw new InvalidInputException("Id not present");
		}
	}

}
