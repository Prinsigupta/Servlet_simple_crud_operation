package com.tcs.servlet_simple_crud_operation.connection;

import java.sql.Connection;

import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class UserConnection {
	public static Connection getUserConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-a5", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

}
