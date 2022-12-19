package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentAns {

	static int marks = 0;

	public void ans() throws SQLException {
		ConnectionTest connectionTest = new ConnectionTest();
		Connection con = null;
		con = connectionTest.getConnectionDetails();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question answer");

		int ans1 = sc.nextInt();
		int answers[] = new int[10];
		int i = 0;

		PreparedStatement pstmt = con.prepareStatement("select ans from questions where questions.sr_no");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			for (i = 1; i <= 10; i++) {
				answers[i] = rs.getInt("ans");
			}
			if (ans1 == answers[i]) {
				marks++;
				System.out.println(marks);
				i++;
			}

		}

	}

}
