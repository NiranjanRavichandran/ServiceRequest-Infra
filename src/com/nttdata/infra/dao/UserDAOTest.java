package com.nttdata.infra.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nttdata.infra.domain.User;

public class UserDAOTest {

	@Test
	public void testValidateUser() {
		User login = new User();
		UserDAO test = new UserDAO();
		boolean validate = true;

		try {
			login = test.validateUser(1501, "123456");
			// System.out.println(login);
			if (login != null) {
				validate = true;
			} else {
				validate = false;
			}
			assertEquals(true, validate);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testValidateUser1() {
		User login = new User();
		UserDAO test = new UserDAO();
		boolean validate = true;

		try {
			login = test.validateUser(1501, "098776");
			// System.out.println(login);
			if (login == null) {
				validate = false;
			} else {
				validate = true;
			}
			assertEquals(false, validate);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testValidateUser2() {
		User login = new User();
		UserDAO test = new UserDAO();
		boolean validate = true;

		try {
			login = test.validateUser(1234, "qwerty");
			// System.out.println(login);
			if (login == null) {
				validate = false;
			} else {
				validate = true;
			}
			assertEquals(false, validate);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testValidateUser3() {
		User login = new User();
		UserDAO test = new UserDAO();
		boolean validate = true;

		try {
			login = test.validateUser(1234, "qwerty1234");
			// System.out.println(login);
			if (login == null) {
				validate = false;
			} else {
				validate = true;
			}
			assertEquals(false, validate);
		} catch (InfraAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
