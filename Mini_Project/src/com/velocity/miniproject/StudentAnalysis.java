package com.velocity.miniproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentAnalysis {

	public int addMarks(int marks)
	{
		if(marks<5)
		{
			System.out.println("Performance: Fail");
		}
		else if(marks==5)
		{
			System.out.println("Performance: Class C");
		}
		else if(marks<8)
		{
			System.out.println("Performance: Class B");
		}
		else if(marks>=8)
		{
			System.out.println("Performance: Class A");
		}
		return marks;
		

	}

		

		
	

	

}
