package com.lulu.dbAssesment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuisnessLogic {

	void createData() throws SQLException {
		Connection connection = ConnectDB.setupConnection();
		String query ="INSERT INTO Product ( id, name,cost, description ) VALUES( ?,?, ?,?)";
		PreparedStatement myStmt = connection.prepareStatement(query);
     	myStmt.setInt(1, 555);
		myStmt.setString(2, "Vivo");
		myStmt.setInt(3, 20000);
		myStmt.setString(4, "Discover affordability in our smartphones!");

		int success = myStmt.executeUpdate();
		System.out.println("Created Successfully " + success);
  	}

		void readData() throws SQLException {

			Connection connection=ConnectDB.setupConnection();
			 java.sql.Statement statement;

			 statement = connection.createStatement();
	         ResultSet resultSet;
	         resultSet = statement.executeQuery("select * from Product where id>=111");

	         int id;
	         String name;
	         int  cost;
	         String description;

	         while (resultSet.next()) {
	             id = resultSet.getInt("id");
	             name = resultSet.getString("name");
	             cost= resultSet.getInt("cost");
	             description=resultSet.getString("description");
	             System.out.println("ID: " + id+ " Name: " + name +" Cost: "+cost+" Description: "+ description);
	    }

    }
		void updateData() throws SQLException{
			Connection connection = ConnectDB.setupConnection();
			String query = "UPDATE Product SET name = ? WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, "Oppo");
			stmt.setInt(2, 555 );
			boolean success = stmt.execute();
			System.out.println("Updated Successfully " + success);
			
		}
		void deleteData() throws SQLException{
			
			Connection connection = ConnectDB.setupConnection();
			String query = "delete from Product where id = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, 555);
			boolean success = stmt.execute();
			System.out.println("Deleted Successfully " + success);}
}

 
