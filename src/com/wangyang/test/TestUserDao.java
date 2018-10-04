package com.wangyang.test;

import org.junit.Before;
import org.junit.Test;

import com.wangyang.Dao.IUserDao;
import com.wangyang.Dao.MyBatisDaoFactory;
import com.wangyang.model.Pagers;
import com.wangyang.model.SystemContext;
import com.wangyang.model.User;

public class TestUserDao {
	
	IUserDao ud; 
	
	@Before
	public void init(){
		ud= MyBatisDaoFactory.createUserDao();
	}
	@Test
	public void add(){
		User user = new User();
		user.setNickname("猪八戒");
		user.setUsername("zbj");
		user.setPassword("123456");
		user.setType(1);
		ud.add(user);
	}
	@Test
	public void delete(){
		ud.delete(4);
	}
	@Test
	public void update(){
		User u = ud.loadByUsername("wangyang");
		u.setPassword("1749");
		ud.update(u);
	}
	@Test
	public void load(){
		System.out.println(ud.load(1).getUsername());
	}
	@Test
	public void find(){
		SystemContext.setPageSize(5);
		SystemContext.setpageOffset(0);
		//SystemContext.setSort("id");
		//SystemContext.setOrder("");
		Pagers<User> pages = ud.find("zbj");
		System.out.println(pages.getList());
		System.out.println(pages.getTotalRecord());
	}
}
