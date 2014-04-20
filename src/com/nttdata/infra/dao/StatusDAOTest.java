package com.nttdata.infra.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.nttdata.infra.domain.Role;
import com.nttdata.infra.domain.Status;

public class StatusDAOTest {

	@Test
	public void testGetStatusDetails() {
		List<Status> statusList = new ArrayList<Status>();
		StatusDAO sts = new StatusDAO();
		Role role2 = new Role();
		Status stat1 = new Status();
		Status getSts = new Status();
		Status stat = new Status();
		role2.setId(2);
		role2.setName("EMPLOYEE");

		stat1.setRole(role2);
		stat1.setStatusId(1);
		stat1.setStatusDesc("Requested");

		try {
			statusList = sts.getStatusDetails(2, 1);
			Iterator<Status> itr = statusList.iterator();
			while (itr.hasNext()) {
				getSts = itr.next();
				if ((getSts.getStatusId() == stat1.getStatusId())) {
					stat = getSts;
				}

			}

			assertEquals(true, stat1.equals(stat));

		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetStatusDetails1() {
		Role role1 = new Role();
		Status myStat = new Status();
		StatusDAO sts = new StatusDAO();
		Status stat = new Status();
		Status stats = new Status();
		List<Status> getList = new ArrayList<Status>();
		role1.setId(1);
		role1.setName("Admin");
		stat.setRole(role1);
		stat.setStatusId(5);
		stat.setStatusDesc("Rejected");
		try {
			getList = sts.getStatusDetails(1, 5);
			Iterator<Status> itr1 = getList.iterator();
			while (itr1.hasNext()) {
				myStat = itr1.next();
				if ((myStat.getStatusId() == stat.getStatusId())) {
					stats = myStat;
				}
			}
			assertEquals(true, stat.equals(stats));
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testGetStatusDetails2() {
		Role role1 = new Role();
		role1.setId(1);
		role1.setName("SR_ADMIN");
		StatusDAO sts = new StatusDAO();
		Status stat = new Status();
		Status stats = new Status();
		Status myStat = new Status();
		List<Status> getList = new ArrayList<Status>();
		stat.setRole(role1);
		stat.setStatusId(2);
		stat.setStatusDesc("Cancelled");
		try {
			getList = sts.getStatusDetails(9, 2);
			Iterator<Status> itr1 = getList.iterator();
			while (itr1.hasNext()) {
				myStat = itr1.next();
				if ((myStat.getStatusId() == stat.getStatusId())) {
					stats = myStat;
				}
			}
			assertEquals(false, stat.equals(stats));

		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
