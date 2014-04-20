package com.nttdata.infra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection establishConnection() {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String userName = "trg02";
			String password = "trg02";
			String url = "jdbc:oracle:thin:@10.248.4.29:1521:blrtrg";
			con = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return con;
	}
}
