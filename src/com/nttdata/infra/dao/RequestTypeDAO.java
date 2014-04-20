package com.nttdata.infra.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.infra.domain.RequestType;

public class RequestTypeDAO {
	public final static Logger LOG = Logger.getLogger("RequestTypeDAO");

	public List<RequestType> getRequestType() throws InfraAppException {
		LOG.info("Inside getRequestType");
		LOG.info("No Arguments");
		Connection con = null;
		List<RequestType> reqTypeList = new ArrayList<RequestType>();

		ConnectionHolder conHolder;
		try {
			conHolder = ConnectionHolder.getInstance();
			con = conHolder.getConnection();
			// con = ConnectionFactory.establishConnection();
			reqTypeList = DBHelper.executeSelect(con,
					SQLMapper.GET_REQUEST_TYPES, SQLMapper.REQ_TYPE_RES_MAPPER);
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		LOG.info("returns a list");
		return reqTypeList;

	}
}
