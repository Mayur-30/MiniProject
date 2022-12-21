package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayQuestions extends StudentData {
	static int marks = 0;

	public void displayque() throws SQLException {
		Scanner sc = new Scanner(System.in);
		ConnectionTest connectionTest = new ConnectionTest();
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		con = connectionTest.getConnectionDetails();

		pstmt1 = con.prepareStatement("select username, password from student");
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
				if (ans1 == rs1.getInt("ans")) {
					marks++;
				}
			}
		} else {
			System.out.println("Invalid Username or Password");
		}

		PreparedStatement pstmt3 = con.prepareStatement("update student set marks=? where studentid=?");
		pstmt3.setInt(1, marks);
		pstmt3.setInt(2, stud_id);
		pstmt3.executeUpdate();
		StudentAnalysis studentAns = new StudentAnalysis();

		studentAns.addMarks(marks);

		PreparedStatement pstmt4 = con.prepareStatement("select * from student order by marks desc");

		ResultSet rs2 = pstmt4.executeQuery();

		while (rs2.next()) {
			System.out.println("Student Id " + rs2.getInt(1));
			System.out.println("Student Name " + rs2.getString(2));
			System.out.println("Student Marks " + rs2.getInt(4));
		}

	}

}
