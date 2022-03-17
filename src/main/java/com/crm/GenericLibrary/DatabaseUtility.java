package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class consisting all generic methods realted data from dabase
 * @author "soujanya"
 *
 */

public class DatabaseUtility {
	Connection con=null;
	/**
	 * this method will register the driver and estiblish connection with database
	 * @throws Throwable
	 */
	
	public void connectToDB() throws Throwable

	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUserName,IPathConstants.dbPassWord);
		
	}
	/**
	 * THIS METHOD WILL CLOSE THE DATABASE
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();	
	}
	/**
	 * this method will execute the query and return matching data to user
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws Throwable
	{
		String data=null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;//flag rising
				break;
			}
			
		}
		if(flag)
		{
			System.out.println(data+"------->data verified");
			return expData;
		}
		else
		{
			System.out.println("data not verified");
			return "";
			
		}
	
	}


}
