package com.wangyang.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.wangyang.Dao.IDaoFactory;

public class DaoUtil {

	public static IDaoFactory createDaoFactory(){
		Properties daoProp = PropertiesUtil.getDaoProp();
		String str = daoProp.getProperty("factory");
		IDaoFactory factory=null;
		try {
			Class<?> dao = Class.forName(str);
			String method = "getInstance";
			Method mm = dao.getMethod(method);
			factory = (IDaoFactory)mm.invoke(dao);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factory;
	}
}
