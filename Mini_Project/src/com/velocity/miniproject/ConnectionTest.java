package com.velocity.miniproject;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	
	public  Connection getConnectionDetails()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root", "root");

		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}

}
