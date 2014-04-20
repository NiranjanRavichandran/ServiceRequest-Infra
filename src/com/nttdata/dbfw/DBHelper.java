package com.nttdata.dbfw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public final class DBHelper {
	public final static Logger LOG = Logger.getLogger("DBHelper");

	private DBHelper() {

	}

	public static List executeSelect(Connection con, final String sqlStmt,
			ResultMapper outMap) throws DBFWException {
		PreparedStatement prepStmt = null;
		ResultSet resSet = null;
		List resultList = new ArrayList();
		try {
			prepStmt = con.prepareStatement(sqlStmt);
			resSet = prepStmt.executeQuery();
			while (resSet.next()) {
				Object obj = outMap.mapRow(resSet);
				resultList.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new DBFWException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (prepStmt != null) {
					prepStmt.close();
				}
				if (resSet != null) {
					resSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error(e.fillInStackTrace());
				throw new DBFWException(e.getMessage());
			}
		}
		return resultList;
	}

	public static List executeSelect(Connection con, String sqlStmt,
			ResultMapper outMap, ParamMapper inMap) throws DBFWException {
		PreparedStatement prepStmt = null;
		ResultSet resSet = null;
		List resultList = new ArrayList();
		try {

			prepStmt = con.prepareStatement(sqlStmt);
			inMap.mapPerams(prepStmt);
			resSet = prepStmt.executeQuery();
			while (resSet.next()) {
				Object obj = outMap.mapRow(resSet);
				resultList.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new DBFWException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (prepStmt != null) {
					prepStmt.close();
				}
				if (resSet != null) {
					resSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error(e.fillInStackTrace());
				throw new DBFWException(e.getMessage());
			}
		}
		return resultList;

	}

	public static int executeUpdate(Connection con, String sqlStmt,
			ParamMapper inMap) throws DBFWException {
		PreparedStatement preStmt = null;
		int result = 0;
		try {
			preStmt = con.prepareStatement(sqlStmt);
			inMap.mapPerams(preStmt);
			result = preStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new DBFWException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (preStmt != null) {
					preStmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error(e.fillInStackTrace());
				throw new DBFWException(e.getMessage());
			}

		}
		return result;
	}
}
