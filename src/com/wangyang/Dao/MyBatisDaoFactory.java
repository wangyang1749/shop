package com.wangyang.Dao;

public class MyBatisDaoFactory {
	
	public static IUserDao createUserDao(){
		return new UserDao();
	}
	public static IAdderssDao createAddressDao(){
		return new AddressDao();
	}
}
