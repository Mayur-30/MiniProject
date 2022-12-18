package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class InsertQuestions {

	public static void main(String[] args) {
		
		
		try {
			
			String insert1="insert into questions(questions, op1, op2, op3, op4, ans)"+ "values('Number of primitive data types in Java are?','1:6','2:7','3:8','4:9','3'),"
					+ "('which one from this is not an OOPS concept?','1:Polymorphism','2:Abstractclass','3:Encapsulation','4:Inheritance','2'),"+
					"('What is the Full-form of JIT Compiler?','1:Just in take','2:Just in time','3:Just in table','4:Just in test','2'),"
					+ "('Automatic type conversion is possible in which of the possible cases?','1:Byte to int','2:Int to long', '3:Long to int', '4:Short to int','2'),"
					+"('When an array is passed to a method, what does the method receive?','1:The referance of the array','2:A copy of the array','3:Length of the array', '4:Copy of first element','1'),"
					+"('Identify the corrected definition of a package.','1:A package is a collection of editing tools','2:A Package is colletions of classes','3:A package is a collection of classes and interfaces','4:A package is a collections of interfaces','3'),"
					+"('Identify the keyword among the following that makes a variable belong to a class,rather than being defined for each instance of the class.','1:Final','2:Static','3:Volatile','4:Abstract','2'),"
					+"('compareTo() returns','1:True','2:False','3:An int value','4:None','3'),"
					+"('Identify the return type of a method that does not return any value.','1:int','2:void','3:double','4:None','2'),"
					+"('Where does the system stores parameters and local variables whenever a method is invoked?','1:Heap', '2:Stack', '3:Array', '4:Tree', '2')";
		
				
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "root");
			
			Statement stmt=con.createStatement(); 
			
			
			stmt.execute(insert1);
			
			System.out.println("Insertion Sucessful.. ");
			con.close();
			stmt.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
