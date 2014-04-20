/*** InfraSystemFacade.java
 * created by trgd101
 * created on Feb 15, 2014
 */
package com.nttdata.infra.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.infra.dao.InfraAppException;
import com.nttdata.infra.dao.RequestDAO;
import com.nttdata.infra.dao.RequestTypeDAO;
import com.nttdata.infra.dao.StatusDAO;
import com.nttdata.infra.dao.UserDAO;
import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.domain.RequestType;
import com.nttdata.infra.domain.Status;
import com.nttdata.infra.domain.User;

public class InfraSystemFacade {
	public final static Logger LOG = Logger.getLogger("InfraSystemFacade");

	public User userValidate(final int userId, final String passwd)
			throws InfraAppException {
		LOG.info("First argument:" + userId);
		LOG.info("Second argument:" + passwd);
		UserDAO user = new UserDAO();
		User login = null;
		try {
			login = user.validateUser(userId, passwd);

		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new InfraAppException(e.getMessage());
		}
		return login;
	}

	public int createNewSR(final RequestDetails objSR) throws InfraAppException {
		LOG.info("First argument:" + objSR);
		RequestDAO createSR = new RequestDAO();
		int result;
		try {
			result = createSR.createNewSR(objSR);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		return result;
	}

	public List<RequestDetails> getRequestByCreator(final int userId)
			throws InfraAppException {
		LOG.info("First argument:" + userId);
		RequestDAO reqDetails = new RequestDAO();
		List<RequestDetails> reqList = new ArrayList<RequestDetails>();
		try {

			reqList = reqDetails.getRequestByCreator(userId);
			// Iterator<RequestDetails> itr = reqList.iterator();
			// while (itr.hasNext()) {
			// req = new RequestDetails();
			// req = itr.next();
			// System.out.println(req);
			//
			// }
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		return reqList;
	}

	public RequestDetails getSRDetails(final int reqId)
			throws InfraAppException {
		LOG.info("First argument:" + reqId);

		RequestDetails reqDet;
		RequestDAO reqDetails = new RequestDAO();
		try {
			reqDet = reqDetails.getRequestdetails(reqId);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());

		}
		return reqDet;
	}

	public List<Status> getStatusDetails(final int roleid, final int statusid)
			throws InfraAppException {
		LOG.info("First argument:" + roleid);
		LOG.info("Second argument:" + statusid);
		List<Status> statusList = new ArrayList<Status>();
		StatusDAO stsDao = new StatusDAO();
		try {
			statusList = stsDao.getStatusDetails(roleid, statusid);
			// Iterator<Status> itr = statusList.iterator();
			// while (itr.hasNext()) {
			// System.out.println(itr.next());
			// }
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		return statusList;

	}

	public boolean saveSRDetails(final RequestDetails objSR)
			throws InfraAppException {
		LOG.info("First argument:" + objSR);
		RequestDAO reqDetails = new RequestDAO();
		boolean isUpdated;
		try {
			isUpdated = reqDetails.saveSRDetails(objSR);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		return isUpdated;
	}

	public List<RequestType> getRequestTypes() throws InfraAppException {
		List<RequestType> typeList = new ArrayList<RequestType>();
		RequestTypeDAO types = new RequestTypeDAO();
		try {
			typeList = types.getRequestType();
			// Iterator<RequestType> itr = typeList.iterator();
			// while (itr.hasNext()) {
			// System.out.println(itr.next());
			// }
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		return typeList;
	}

	public List<RequestDetails> getAllRequests() throws InfraAppException {
		List<RequestDetails> reqList = new ArrayList<RequestDetails>();
		RequestDAO req = new RequestDAO();
		try {
			reqList = req.getAllRequest();
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			LOG.error(e.fillInStackTrace());
			throw new InfraAppException(e.getMessage());
		}
		return reqList;
	}

	// public List<Status> getStatusList(final int roleId)
	// throws InfraAppException {
	// List<Status> statusList = new ArrayList<Status>();
	// StatusDAO stat = new StatusDAO();
	// try {
	// statusList = stat.getStatusList(roleId);
	// } catch (InfraAppException e) {
	// // TODO Auto-generated catch block
	// // e.printStackTrace();
	// throw new InfraAppException(e.getMessage());
	// }
	// return statusList;
	// }
}
