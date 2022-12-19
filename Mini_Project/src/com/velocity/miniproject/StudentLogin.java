package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentLogin {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		ConnectionTest connectionTest = new ConnectionTest();
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		con = connectionTest.getConnectionDetails();

		pstmt = con.prepareStatement("insert into student(username,password) values(?,?)");

		pstmt.setString(1, "admin");
		pstmt.setString(2, "admin");

		int i = pstmt.executeUpdate();
		System.out.println("Record inserted ");
		pstmt1 = con.prepareStatement("select username, password from student");

		ResultSet rs = pstmt1.executeQuery();
		String username = "";
		String password = "";
		
		StudentAns studentAns= new StudentAns();
		
		while (rs.next()) {

			username = rs.getString("username");
			password = rs.getString("password");

		}
		System.out.println("Enter the Username and Password");
		String uname = sc.next();
		String pword = sc.next();
		
		if (username.equals(uname) && password.equals(pword)) {
			pstmt2 = con.prepareStatement("SELECT questions,op1, op2, op3, op4 FROM questions WHERE questions.sr_no");

			ResultSet rs1 = pstmt2.executeQuery();
			
		
			
			
			while (rs1.next() ) {
				
				for(int j=1;j<=1;j++) {
				System.out.println("questions:" + rs1.getString("questions"));
				System.out.println("op1: " + rs1.getString("op1"));
				System.out.println("op2 " + rs1.getString("op2"));
				System.out.println("op3 " + rs1.getString("op3"));
				System.out.println("op4 " + rs1.getString("op4"));

				System.out.println("------------------------------------------------------------------");
				
				System.out.println("Type the options numbers only");
				studentAns.ans();
				
				
				}
			}
		}
		else
		{
			System.out.println("Invalid Username or Password");
		}
		
		
		
		
		
		
		
		
		
		
		con.close();
		pstmt.close();
		pstmt1.close();
		pstmt2.close();

	}

}
