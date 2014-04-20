/*** StatusDAO.java
 * created by trgd101
 * created on Feb 14, 2014
 */
package com.nttdata.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.infra.domain.Status;

public class StatusDAO {
	public final static Logger LOG = Logger.getLogger("StatusDAO");

	public List<Status> getStatusDetails(final int roleId, final int statusId)
			throws InfraAppException {
		LOG.info("Inside getStatusDetails");
		LOG.info("First Argument " + roleId);
		LOG.info("Second Argument " + statusId);
		Connection con = null;
		List<Status> statusList;
		ConnectionHolder conHolder;
		ParamMapper inMap = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, roleId);
				preStmt.setInt(2, statusId);
			}
		};
		try {
			conHolder = ConnectionHolder.getInstance();
			con = conHolder.getConnection();
			// con = ConnectionFactory.establishConnection();
			statusList = DBHelper.executeSelect(con, SQLMapper.GET_STATUS_LIST,
					SQLMapper.STATUS_LIST_MAPPER, inMap);

		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		return statusList;

	}

	// public List<Status> getStatusList(final int roleId)
	// throws InfraAppException {
	// Connection con = null;
	// List<Status> statusList;
	// ConnectionHolder conHolder;
	// ParamMapper inMap = new ParamMapper() {
	//
	// public void mapPerams(PreparedStatement preStmt)
	// throws SQLException {
	// // TODO Auto-generated method stub
	// preStmt.setInt(1, roleId);
	// }
	// };
	// try {
	// conHolder = ConnectionHolder.getInstance();
	// con = conHolder.getConnection();
	// statusList = DBHelper.executeSelect(con, SQLMapper.GET_STATUS_LIST,
	// SQLMapper.STATUS_LIST_MAPPER, inMap);
	// } catch (DBConnectionException e) {
	// // TODO Auto-generated catch block
	// // e.printStackTrace();
	// throw new InfraAppException();
	// } catch (DBFWException e) {
	// // TODO Auto-generated catch block
	// // e.printStackTrace();
	// throw new InfraAppException();
	// }
	// return statusList;
	// }
}
