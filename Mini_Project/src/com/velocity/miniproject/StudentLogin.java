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
		 int marks=0;
		con = connectionTest.getConnectionDetails();

		pstmt = con.prepareStatement("insert into student(username,password) values(?,?)");

		pstmt.setString(1, "admin");
		pstmt.setString(2, "admin");

		pstmt.executeUpdate();
		
		pstmt1 = con.prepareStatement("select username, password from student where studentid=1");

		ResultSet rs = pstmt1.executeQuery();
		String username = "";
		String password = "";

		while (rs.next()) {

			username = rs.getString("username");
			password = rs.getString("password");

		}
		
		System.out.println("Enter the Username and Password");
		String uname = sc.next();
		String pword = sc.next();
		
		System.out.println("Enter the Question answer");
		
		if (username.equals(uname) && password.equals(pword)) {
			pstmt2 = con.prepareStatement("SELECT * FROM questions WHERE questions.sr_no order by rand()");
			
			ResultSet rs1 = pstmt2.executeQuery();

			while (rs1.next()) {
					
					System.out.println("questions:" + rs1.getString("questions"));
					System.out.println("op1: " + rs1.getString("op1"));
					System.out.println("op2 " + rs1.getString("op2"));
					System.out.println("op3 " + rs1.getString("op3"));
					System.out.println("op4 " + rs1.getString("op4"));

					System.out.println("------------------------------------------------------------------");

					System.out.println("Type the options numbers only");
					int ans1 = sc.nextInt();
					if(ans1==rs1.getInt("ans"))
					{
						marks++;
						System.out.println(marks);
					}
		}
		} else {
			System.out.println("Invalid Username or Password");
		}
		
		
       
		PreparedStatement pstmt3=con.prepareStatement("update student set marks=? where studentid=?");
		pstmt3.setInt(1,marks);
		pstmt3.setInt(2, 1);
		pstmt3.addBatch();
		pstmt3.executeBatch();
		
		StudentAnalysis studentAns=new StudentAnalysis();
		
		studentAns.addMarks(marks);

		con.close();
		pstmt.close();
		pstmt1.close();
		pstmt2.close();
		sc.close();

	}

}
