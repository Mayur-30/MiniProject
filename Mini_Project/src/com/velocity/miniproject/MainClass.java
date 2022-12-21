package com.velocity.miniproject;

import java.sql.SQLException;

public class MainClass {
		public static void main(String[] args) throws SQLException {
			StudentData studentData= new StudentData();
			studentData.insertData();
			
			DisplayQuestions displayQuestions=new DisplayQuestions();
				displayQuestions.displayque();
		}
}
