package com.example.AccountView;

import java.sql.*;
import com.mysql.*;
public class DataBase{

	public Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root","Kambick29!");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void execute(Connection conn, String query)
	{
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			 statement.executeUpdate();
			 System.out.println("insertion successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean login(Connection conn, String user, String pass) {
		boolean visible = false;
	    try {
	        if (user != null && pass != null) {
	            PreparedStatement statement = conn.prepareStatement("Select * from CUSTOMER_LOG Where Username= '" + user + "' and Password= '" + pass + "';");
	            ResultSet result = statement.executeQuery();
	            if (result.next()) {
	            	visible=true;
	                //in this case enter when at least one result comes it means user is valid
	            } else {
	                //in this case enter when  result size is zero  it means user is invalid
	            }
	        }

	        // You can also validate user by result size if its comes zero user is invalid else user is valid

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return visible;

	}
	
	public int getAccount(Connection conn, String name)
	{
		
		    int AccountID=0;
		
		try {
			PreparedStatement statement = conn.prepareStatement("Select * from CUSTOMER_LOG Where Username='" + name +"'");
			ResultSet result2 = statement.executeQuery();
			 AccountID= result2.getInt("CUS_ID");
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return AccountID;
	}
	
	public double getBalance(Connection conn, String name)
	{
		double balance=0;
	  
	
	try {
		
		PreparedStatement statement2 = conn.prepareStatement("Select * from CUSTOMER_LOG Where Username='" + name + "'");
		  ResultSet result = statement2.executeQuery();
		 balance=Double.parseDouble(result.getString("Bal"));
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return balance;
	}
    	}  

