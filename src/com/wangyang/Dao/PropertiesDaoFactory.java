package com.wangyang.Dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.wangyang.util.PropertiesUtil;

public class PropertiesDaoFactory implements IDaoFactory {
	private PropertiesDaoFactory() {
	}
	private static IDaoFactory f = new PropertiesDaoFactory();
	private static Map<String,Object> maps = new HashMap<String,Object>();
	public static IDaoFactory getInstance(){
		return f;
	}
	
	@Override
	public Object createDao(String name) {
		Object obj = null;
		Properties daoProp = PropertiesUtil.getDaoProp();
		String daoName = daoProp.getProperty(name);
		if(maps.containsKey(daoName)){
			return maps.get(daoName);
		}
		try {
			Class<?> clz = Class.forName(daoName);
			obj= clz.newInstance();
			maps.put(daoName, obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

}
