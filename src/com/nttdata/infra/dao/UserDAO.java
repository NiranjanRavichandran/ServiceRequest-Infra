/*** UserDAO.java
 * created by trgd101
 * created on Feb 14, 2014
 */
package com.nttdata.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.infra.domain.User;

public class UserDAO {
	public final static Logger LOG = Logger.getLogger("UserDAO");

	public User validateUser(final int userId, final String passwd)
			throws InfraAppException {
		LOG.info("inside validateUser method");
		LOG.info("First Argument: " + userId);
		LOG.info("Second Argument: " + passwd);
		Connection con = null;
		List<User> userList = new ArrayList<User>();
		User user1 = null;
		ConnectionHolder conHolder = null;
		ParamMapper inMap = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, userId);
				preStmt.setString(2, passwd);
			}
		};
		try {
			// conHolder = ConnectionHolder.getInstance();
			// con = conHolder.getConnection();
			con = ConnectionFactory.establishConnection();
			userList = DBHelper.executeSelect(con, SQLMapper.VALIDATE_PASSWD,
					SQLMapper.USER_RES_MAPPER, inMap);
			Iterator<User> itr = userList.iterator();
			while (itr.hasNext()) {
				user1 = itr.next();
			}
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		// catch (DBConnectionException e) {
		// // TODO Auto-generated catch block
		// // e.printStackTrace();
		// LOG.error(e.fillInStackTrace());
		// throw new InfraAppException(e.getMessage());
		// }
		return user1;

	}
}
