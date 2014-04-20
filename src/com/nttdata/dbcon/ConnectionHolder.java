package com.nttdata.dbcon;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public final class ConnectionHolder {

	private static ConnectionHolder instance = null;
	private DataSource ds = null;

	private ConnectionHolder() {

	}

	public static ConnectionHolder getInstance() throws DBConnectionException {
		synchronized (ConnectionHolder.class) {
			if (instance == null) {
				instance = new ConnectionHolder();
				instance.initAppServerDataSource();
			}
		}
		return instance;
	}

	private void initAppServerDataSource() throws DBConnectionException {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/MyDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new DBConnectionException(e.getMessage());
		}
	}

	public Connection getConnection() throws DBConnectionException {
		try {

			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new DBConnectionException(e.getMessage());
		}

	}

	public void dispose() throws DBConnectionException {
		BasicDataSource bds = (BasicDataSource) ds;
		try {
			bds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new DBConnectionException(e.getMessage());

		}
	}
}
