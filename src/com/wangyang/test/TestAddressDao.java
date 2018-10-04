package com.wangyang.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wangyang.Dao.IAdderssDao;
import com.wangyang.Dao.MyBatisDaoFactory;
import com.wangyang.model.Address;

public class TestAddressDao {
	IAdderssDao ad ;
	
	@Before
	public void init(){
		ad=MyBatisDaoFactory.createAddressDao();
	}
	@Test
	public void add(){
		Address address = new Address();
		address.setName("赵镇吴村");
		address.setPhone("13087691131");
		address.setPostcode("713206");
		ad.add(address, 1);
	}
	@Test
	public void delete(){
		ad.delete(2);
	}
	@Test
	public void update(){
		Address address = new Address();
		address.setId(1);
		address.setName("赵镇吴村");
		address.setPhone("13892078448");
		address.setPostcode("713206");
		ad.update(address);
	}
	@Test
	public void list(){
		List<Address> list = ad.list(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
