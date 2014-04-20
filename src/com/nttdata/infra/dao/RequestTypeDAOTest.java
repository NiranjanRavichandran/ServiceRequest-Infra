package com.nttdata.infra.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.nttdata.infra.domain.RequestType;

public class RequestTypeDAOTest {

	@Test
	public void testGetRequestType() {
		List<RequestType> typeList = new ArrayList<RequestType>();
		List<RequestType> correctList = new ArrayList<RequestType>();
		RequestType type1 = new RequestType();
		RequestType type2 = new RequestType();
		RequestType type3 = new RequestType();

		type1.setId(1);
		type1.setDesc("Job Request");

		type2.setId(2);
		type2.setDesc("Software Request");

		type3.setId(3);
		type3.setDesc("Hardware Request");

		correctList.add(type1);
		correctList.add(type2);
		correctList.add(type3);
		// System.out.println(correctList);
		RequestTypeDAO test = new RequestTypeDAO();
		try {
			typeList = test.getRequestType();
			Iterator<RequestType> itr = typeList.iterator();
			Iterator<RequestType> itr1 = correctList.iterator();
			while (itr.hasNext() && itr1.hasNext()) {
				// System.out.println(itr.next());
				// System.out.println(itr1.next());
				assertEquals(true, (itr.next()).equals(itr1.next()));
			}

		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRequestType2() {
		List<RequestType> typeList = new ArrayList<RequestType>();
		List<RequestType> correctList = new ArrayList<RequestType>();
		RequestType type1 = new RequestType();
		RequestType type2 = new RequestType();
		RequestType type3 = new RequestType();

		type1.setId(4);
		type1.setDesc("Man Power");

		type2.setId(5);
		type2.setDesc("Stationary Req");

		type3.setId(6);
		type3.setDesc("Audio System");

		correctList.add(type1);
		correctList.add(type2);
		correctList.add(type3);
		// System.out.println(correctList);
		RequestTypeDAO test = new RequestTypeDAO();
		try {
			typeList = test.getRequestType();
			Iterator<RequestType> itr = typeList.iterator();
			Iterator<RequestType> itr1 = correctList.iterator();
			while (itr.hasNext() && itr1.hasNext()) {
				// System.out.println(itr.next());
				// System.out.println(itr1.next());
				assertEquals(false, (itr.next()).equals(itr1.next()));
			}

		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
