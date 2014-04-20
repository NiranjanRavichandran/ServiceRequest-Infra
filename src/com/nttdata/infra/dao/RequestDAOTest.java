package com.nttdata.infra.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.nttdata.infra.domain.RequestDetails;

public class RequestDAOTest {
	java.util.Date date = new java.util.Date();
	Date today = new Date(date.getTime());

	@Test
	public void testCreateNewSR() {
		// fail("Not yet implemented");
		RequestDetails newReq = new RequestDetails();
		RequestDAO test = new RequestDAO();
		int id = 0;
		newReq.setUserID(1503);
		newReq.setLocation("DLF");
		newReq.setCubicalNo(9);
		newReq.setDepartment("Delivery");
		newReq.setRequiredByDate("18-05-2014");
		newReq.setReqTypeID(3);
		newReq.setRejectionReason(null);
		newReq.setCancellationReason(null);
		newReq.setRequestedDate(today);
		newReq.setCommittedDate(null);
		newReq.setAssigndeDate(null);
		newReq.setCompletedDate(null);
		newReq.setJustification("Project delivery");
		newReq.setStatusID(1);
		try {

			id = test.createNewSR(newReq);
			System.out.println(id);
			assertEquals(53, id);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRequestByCreator() {
		// fail("Not yet implemented");
		RequestDAO test = new RequestDAO();
		RequestDetails req1 = new RequestDetails();
		RequestDetails req2 = new RequestDetails();
		List<RequestDetails> dataList = new ArrayList<RequestDetails>();
		List<RequestDetails> myList = new ArrayList<RequestDetails>();

		req1.setReqID(37);
		req1.setStatusID(1);
		req2.setReqID(38);
		req2.setStatusID(1);

		myList.add(req1);
		myList.add(req2);

		try {
			dataList = test.getRequestByCreator(1501);
			Iterator<RequestDetails> itr = dataList.iterator();
			Iterator<RequestDetails> itr1 = myList.iterator();
			while (itr.hasNext() && itr1.hasNext()) {
				assertEquals(true, (itr.next()).equals(itr1.next()));
			}
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetRequestByCreator2() {
		// fail("Not yet implemented");
		RequestDAO test = new RequestDAO();
		RequestDetails req1 = new RequestDetails();
		RequestDetails req2 = new RequestDetails();
		List<RequestDetails> dataList = new ArrayList<RequestDetails>();
		List<RequestDetails> myList = new ArrayList<RequestDetails>();

		req1.setReqID(39);
		req1.setStatusID(2);
		req2.setReqID(38);
		req2.setStatusID(2);

		myList.add(req1);
		myList.add(req2);

		try {
			dataList = test.getRequestByCreator(1501);
			Iterator<RequestDetails> itr = dataList.iterator();
			Iterator<RequestDetails> itr1 = myList.iterator();
			while (itr.hasNext() && itr1.hasNext()) {
				assertEquals(false, (itr.next()).equals(itr1.next()));
			}
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAllRequest() {
		// fail("Not yet implemented");
		List<RequestDetails> allList = new ArrayList<RequestDetails>();
		RequestDAO req = new RequestDAO();
		RequestDetails myReq = new RequestDetails();
		myReq.setReqID(37);
		myReq.setUserID(1505);
		myReq.setLocation("CHN-DLF1");
		myReq.setCubicalNo(1);
		myReq.setDepartment("HR");
		myReq.setReqTypeID(1);
		myReq.setStatusID(1);

		RequestDetails getReq = new RequestDetails();
		RequestDetails request = new RequestDetails();

		try {
			allList = req.getAllRequest();
			Iterator<RequestDetails> itr = allList.iterator();
			while (itr.hasNext()) {
				getReq = itr.next();
				if (getReq.getReqID() == myReq.getReqID()) {
					request = getReq;
				}
			}
			assertEquals(true, myReq.equals(request));

		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllRequest1() {
		// fail("Not yet implemented");
		List<RequestDetails> allList = new ArrayList<RequestDetails>();
		RequestDAO req = new RequestDAO();
		RequestDetails expreq = new RequestDetails();
		expreq.setReqID(38);
		expreq.setUserID(1505);
		expreq.setLocation("CHN-PGR3 ");
		expreq.setCubicalNo(1);
		expreq.setDepartment("1");
		expreq.setReqTypeID(2);
		expreq.setStatusID(5);

		RequestDetails actreq = new RequestDetails();
		RequestDetails request = new RequestDetails();

		try {
			allList = req.getAllRequest();
			Iterator<RequestDetails> itr = allList.iterator();
			while (itr.hasNext()) {
				actreq = itr.next();
				if (actreq.getReqID() == expreq.getReqID()) {
					request = actreq;
				}
			}
			assertEquals(false, expreq.equals(request));

		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveSRDetails() {
		// fail("Not yet implemented");
		boolean isUpdated = false;
		RequestDAO test = new RequestDAO();
		RequestDetails update = new RequestDetails();
		int id = 0;
		update.setUserID(1503);
		update.setReqID(53);
		update.setLocation("DLF");
		update.setCubicalNo(9);
		update.setDepartment("Delivery");
		update.setRequiredByDate("18-05-2014");
		update.setReqTypeID(3);
		update.setRejectionReason(null);
		update.setCancellationReason(null);
		update.setRequestedDate(today);
		update.setCommittedDate(today);
		update.setAssigndeDate(today);
		update.setCompletedDate(null);
		update.setJustification("Project delivery");
		update.setStatusID(3);

		try {
			isUpdated = test.saveSRDetails(update);
			assertEquals(true, isUpdated);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSaveSRDetails1() {
		// fail("Not yet implemented");
		boolean isUpdated = false;
		RequestDAO test = new RequestDAO();
		RequestDetails update = new RequestDetails();
		int id = 0;
		update.setUserID(1503);
		update.setReqID(48);
		update.setLocation("DLF");
		update.setCubicalNo(9);
		update.setDepartment("Delivery");
		update.setRequiredByDate("18-05-2014");
		update.setReqTypeID(3);
		update.setRejectionReason(null);
		update.setCancellationReason(null);
		update.setRequestedDate(today);
		update.setCommittedDate(today);
		update.setAssigndeDate(today);
		update.setCompletedDate(null);
		update.setJustification("Project delivery");
		update.setStatusID(6);

		try {
			isUpdated = test.saveSRDetails(update);
			assertEquals(false, isUpdated);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetRequestdetails() {

		RequestDAO test = new RequestDAO();
		RequestDetails req = new RequestDetails();
		RequestDetails staticReq = new RequestDetails();
		staticReq.setUserID(1503);
		staticReq.setReqID(36);
		staticReq.setRequestedDate(today);
		staticReq.setAssigndeDate(null);
		staticReq.setCommittedDate(null);
		staticReq.setCancellationReason(null);
		staticReq.setCompletedDate(null);
		staticReq.setRejectionReason(null);
		staticReq.setDepartment("Infrastructure");
		staticReq.setCubicalNo(45);
		staticReq.setJustification("for upcoming project ");
		staticReq.setLocation("CHN-PGR2 ");
		staticReq.setReqTypeID(2);
		staticReq.setStatusID(1);
		staticReq.setRequiredByDate("15-03-2014 ");

		try {
			req = test.getRequestdetails(36);
			assertEquals(true, staticReq.equals(req));
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetRequestdetails1() {
		RequestDAO test = new RequestDAO();
		RequestDetails req = new RequestDetails();
		RequestDetails staticReq = new RequestDetails();
		staticReq.setUserID(1503);
		staticReq.setReqID(36);
		staticReq.setRequestedDate(today);
		staticReq.setAssigndeDate(null);
		staticReq.setCommittedDate(null);
		staticReq.setCancellationReason(null);
		staticReq.setCompletedDate(null);
		staticReq.setRejectionReason(null);
		staticReq.setDepartment("Infrastructure");
		staticReq.setCubicalNo(45);
		staticReq.setJustification("for upcoming project ");
		staticReq.setLocation("CHN-PGR2 ");
		staticReq.setReqTypeID(2);
		staticReq.setStatusID(2);
		staticReq.setRequiredByDate("15-03-2015 ");
		try {
			req = test.getRequestdetails(7);
			assertEquals(false, staticReq.equals(req));
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetRequestdetails2() {
		RequestDAO test = new RequestDAO();
		RequestDetails req = new RequestDetails();
		RequestDetails staticReq = new RequestDetails();
		staticReq.setUserID(1502);
		staticReq.setReqID(45);
		staticReq.setRequestedDate(today);
		staticReq.setAssigndeDate(null);
		staticReq.setCommittedDate(null);
		staticReq.setCancellationReason(null);
		staticReq.setCompletedDate(null);
		staticReq.setRejectionReason(null);
		staticReq.setDepartment("Infrastructure");
		staticReq.setCubicalNo(45);
		staticReq.setJustification("for upcoming project ");
		staticReq.setLocation("CHN-PGR2 ");
		staticReq.setReqTypeID(2);
		staticReq.setStatusID(2);
		staticReq.setRequiredByDate("15-03-2015 ");
		try {
			req = test.getRequestdetails(0);
			assertEquals(false, staticReq.equals(req));
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
