package com.crm.comcast.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * Utility for Database
 * @author sarav
 *
 */

public class DataBaseUtility {
	Connection connection=null;
	/**
	 * This method will do the connection to data
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentimfo","root","root");
	}
	/**
	 * This method will close the database connection
	 * @throws SQLException 
	 */
	
	public void closeDB() throws SQLException {
		connection.close();
	}
	/**
	 * Method will fetch all the data from the database
	 * @param querry
	 * @return
	 * @throws SQLException
	 */
	
	public ResultSet getAllData(String querry) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * Method will update the data in database and it will verify
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	
	public boolean updateData(String querry) throws Throwable {
		boolean flag=false;
		int result = connection.createStatement().executeUpdate(querry);
		if(result==1) {
		System.out.println("data is Updated in database");
		flag=true;
		}else {
			System.out.println("data is not Updated in database");
		}
		return  flag;
	}
	public String getTheData(String querry,int columnNumber,String expectedData) throws Throwable {
	boolean flag=false;
	String actualData = null;
	ResultSet result = connection.createStatement().executeQuery(querry);
	while(result.next()) {
		String data = result.getString(columnNumber);
		if(data.equals(expectedData)) {
		actualData=data;
		flag=true;
		break;
		}
	}
	if(flag==true) {
		System.out.println("data is present in the database");
		return actualData;
	}
	else {
		System.out.println("data is not present in the database");
		return actualData;
	}
	}
}

