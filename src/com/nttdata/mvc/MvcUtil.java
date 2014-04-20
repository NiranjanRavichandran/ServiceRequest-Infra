package com.nttdata.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class MvcUtil {
	private MvcUtil() {

	}

	private static boolean checkInterface(Class clazz, String interfaceName) {
		Class[] interfaces = clazz.getInterfaces();
		boolean found = false;
		for (int count = 0; count < interfaces.length; count++) {
			if (interfaces[count].getName().equals(interfaceName)) {
				found = true;
			}
		}
		return found;
	}

	public static Map buildHandlers(String propsFile) throws MVCException {
		Map handlers = new HashMap();
		Properties prop = new Properties();
		FileInputStream proStr = null;
		try {
			proStr = new FileInputStream(propsFile);
			prop.load(proStr);
			Enumeration enKeys = prop.propertyNames();
			while (enKeys.hasMoreElements()) {
				String key = (String) enKeys.nextElement();
				String clazz = prop.getProperty(key);
				Class handClazz = Class.forName(clazz);
				if (checkInterface(handClazz,
						"com.nttdata.mvc.HttpRequestHandler")) {
					Object handler = handClazz.newInstance();
					handlers.put(key, handler);
				} else {
					throw new MVCException(
							"Class does not implement HttpRequestHandlerInterface");
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new MVCException(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new MVCException(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new MVCException(e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new MVCException(e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new MVCException(e.getMessage());
		} finally {
			try {
				proStr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				throw new MVCException(e.getMessage());
			}
		}
		return handlers;

	}
}
