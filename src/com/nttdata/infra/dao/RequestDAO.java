package com.nttdata.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.infra.domain.RequestDetails;

public class RequestDAO {
	public final static Logger LOG = Logger.getLogger("RequestDAO");

	public int createNewSR(final RequestDetails objSR) throws InfraAppException {
		LOG.info("Inside CreateNewSR");
		LOG.info("Argument " + objSR);
		Connection con = null;
		int result = 0;
		int reID = 0;
		// RequestDetails newSR;
		// List resultList;
		ParamMapper inMap = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, objSR.getUserID());
				preStmt.setString(2, objSR.getLocation());
				preStmt.setInt(3, objSR.getCubicalNo());
				preStmt.setString(4, objSR.getDepartment());
				preStmt.setString(5, objSR.getRequiredByDate());
				preStmt.setInt(6, objSR.getReqTypeID());
				preStmt.setString(7, objSR.getRejectionReason());
				preStmt.setString(8, objSR.getCancellationReason());
				preStmt.setDate(9, objSR.getRequestedDate());
				preStmt.setDate(10, objSR.getAssigndeDate());
				preStmt.setDate(11, objSR.getCommittedDate());
				preStmt.setDate(12, objSR.getCompletedDate());
				preStmt.setString(13, objSR.getJustification());
				preStmt.setInt(14, objSR.getStatusID());
			}
		};

		ConnectionHolder conHolder = null;
		try {
			// conHolder = ConnectionHolder.getInstance();
			// con = conHolder.getConnection();
			con = ConnectionFactory.establishConnection();
			result = DBHelper.executeUpdate(con, SQLMapper.CREATE_SR, inMap);
			if (result == 1) {
				LOG.debug("Validating for successful creation of request");
				conHolder = ConnectionHolder.getInstance();
				con = conHolder.getConnection();
				List<RequestDetails> reList = new ArrayList<RequestDetails>();
				reList = DBHelper.executeSelect(con, SQLMapper.GET_NEW_REQ_ID,
						SQLMapper.SR_DETAILS_RES_MAPPER);
				Iterator<RequestDetails> itr = reList.iterator();
				RequestDetails req = null;
				while (itr.hasNext()) {
					req = new RequestDetails();
					req = itr.next();
					reID = req.getReqID();
				}
			}
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		LOG.info("returns newly created request ID: " + reID);
		// System.out.println(reID);
		return reID;

	}

	public List<RequestDetails> getRequestByCreator(final int userId)
			throws InfraAppException {
		LOG.info("Inside getRequestByCreator");
		LOG.info("Argument " + userId);
		Connection con = null;
		List<RequestDetails> reqDetailsList = null;
		ParamMapper inMap = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, userId);
			}
		};
		try {
			// ConnectionHolder conHolder = ConnectionHolder.getInstance();
			// con = conHolder.getConnection();
			con = ConnectionFactory.establishConnection();
			reqDetailsList = DBHelper.executeSelect(con,
					SQLMapper.REQUEST_BY_CREATOR,
					SQLMapper.SR_DETAILS_RES_MAPPER, inMap);
		}
		// catch (DBConnectionException e) {
		// // TODO Auto-generated catch block
		// LOG.error(e.fillInStackTrace());
		// throw new InfraAppException(e.getMessage());
		// }
		catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		LOG.info("returns request details List");
		return reqDetailsList;
	}

	public List<RequestDetails> getAllRequest() throws InfraAppException {
		LOG.info("Inside getAllRequest");
		LOG.info("No Arguments");
		Connection con = null;
		List<RequestDetails> requestList = null;

		ConnectionHolder conHolder;
		try {
			// conHolder = ConnectionHolder.getInstance();
			// con = conHolder.getConnection();
			con = ConnectionFactory.establishConnection();
			requestList = DBHelper
					.executeSelect(con, SQLMapper.VIEW_ALL_REQUEST,
							SQLMapper.SR_DETAILS_RES_MAPPER);
		}
		// catch (DBConnectionException e) {
		// // TODO Auto-generated catch block
		// LOG.error(e.fillInStackTrace());
		// throw new InfraAppException(e.getMessage());
		// }
		catch (DBFWException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		LOG.info("returns all requests in DB");
		return requestList;

	}

	public RequestDetails getRequestdetails(final int reqID)
			throws InfraAppException {
		LOG.info("Inside getRequestdetails");
		LOG.info("Argument " + reqID);
		Connection con = null;
		List<RequestDetails> reqList;
		RequestDetails reqDetails = new RequestDetails();
		ConnectionHolder conholder;
		ParamMapper inMap = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, reqID);
			}
		};
		try {
			// conholder = ConnectionHolder.getInstance();
			// con = conholder.getConnection();
			con = ConnectionFactory.establishConnection();
			reqList = DBHelper.executeSelect(con,
					SQLMapper.GET_REQUEST_DETIALS,
					SQLMapper.SR_DETAILS_RES_MAPPER, inMap);
			Iterator<RequestDetails> itr = reqList.iterator();
			while (itr.hasNext()) {
				reqDetails = itr.next();
			}
		}
		// catch (DBConnectionException e) {
		// // TODO Auto-generated catch block
		// LOG.error(e.fillInStackTrace());
		// throw new InfraAppException(e.getMessage());
		// }
		catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		LOG.info("returns details for given request");
		return reqDetails;

	}

	public boolean saveSRDetails(final RequestDetails objSR)
			throws InfraAppException {
		LOG.info("Inside saveSRDetails");
		LOG.info("Argument " + objSR);

		Connection con = null;
		// List<RequestDetails> requestList = null;
		ConnectionHolder conHolder;
		int result = 0;
		boolean isInserted = false;
		ParamMapper inMapCancel = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, objSR.getStatusID());
				preStmt.setDate(2, objSR.getCommittedDate());
				preStmt.setDate(3, objSR.getAssigndeDate());
				preStmt.setDate(4, objSR.getCompletedDate());
				preStmt.setString(5, objSR.getCancellationReason());
				preStmt.setInt(6, objSR.getReqID());

			}
		};
		ParamMapper inMapReject = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, objSR.getStatusID());
				preStmt.setDate(2, objSR.getCommittedDate());
				preStmt.setDate(3, objSR.getAssigndeDate());
				preStmt.setDate(4, objSR.getCompletedDate());
				preStmt.setString(5, objSR.getRejectionReason());
				preStmt.setInt(6, objSR.getReqID());

			}
		};
		ParamMapper inMapAssign = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, objSR.getStatusID());
				preStmt.setDate(2, objSR.getCommittedDate());
				preStmt.setDate(3, objSR.getAssigndeDate());
				preStmt.setInt(4, objSR.getReqID());

			}
		};
		ParamMapper inMapComplete = new ParamMapper() {

			public void mapPerams(PreparedStatement preStmt)
					throws SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, objSR.getStatusID());
				preStmt.setDate(2, objSR.getCompletedDate());
				preStmt.setInt(3, objSR.getReqID());

			}
		};
		try {
			// conHolder = ConnectionHolder.getInstance();
			// con = conHolder.getConnection();
			con = ConnectionFactory.establishConnection();
			if (objSR.getStatusID() == 2) {
				LOG.debug("checking for status = 2");
				result = DBHelper.executeUpdate(con,
						SQLMapper.UPDATE_ON_CANCEL, inMapCancel);
			} else if (objSR.getStatusID() == 3) {
				LOG.debug("checking for status = 3");
				result = DBHelper.executeUpdate(con,
						SQLMapper.UPDATE_ON_ASSIGN, inMapAssign);
			} else if (objSR.getStatusID() == 4) {
				LOG.debug("checking for status = 4");
				result = DBHelper.executeUpdate(con,
						SQLMapper.UPDATE_ON_COMPLETE, inMapComplete);
			} else if (objSR.getStatusID() == 5) {
				LOG.debug("checking for status = 5");
				result = DBHelper.executeUpdate(con,
						SQLMapper.UPDATE_ON_REJECT, inMapReject);
			}
			if (result > 0) {
				isInserted = true;
				LOG.debug("Checking for successful updation!");
			}

		}
		// catch (DBConnectionException e) {
		// // TODO Auto-generated catch block
		// LOG.error(e.fillInStackTrace());
		// throw new InfraAppException(e.getMessage());
		// }
		catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		LOG.info("returns 1 on successful updation:" + isInserted);
		return isInserted;

	}
}
