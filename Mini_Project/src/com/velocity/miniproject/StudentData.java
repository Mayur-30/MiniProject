package com.velocity.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentData {
	static int stud_id;
	
	public void insertData()throws SQLException{
		Connection con=null;
		ConnectionTest connectionTest = new ConnectionTest();
		connectionTest.getConnectionDetails();
		con = connectionTest.getConnectionDetails();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter student id");
		stud_id=sc.nextInt();
		
		System.out.println("Enter A username");
		String uname=sc.next();
		
		System.out.println("Enter  A password");
		
		String pword=sc.next();
		
		
		
		
		
		PreparedStatement pstmt = con.prepareStatement("insert into student( studentid,username,password) values(?,?,?)");
		pstmt.setInt(1,stud_id);
		pstmt.setString(2, uname);
		pstmt.setString(3, pword);
		
		pstmt.executeUpdate();
	}

}
