package com.wangyang.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wangyang.model.Address;
import com.wangyang.model.ShopException;
import com.wangyang.model.User;
import com.wangyang.util.DaoUtil;

public class AddressDao extends BaesDao<Address> implements IAdderssDao {
	private IUserDao ud;
	public AddressDao() {
		ud = (IUserDao)DaoUtil.createDaoFactory().createDao("userDao");
	}
	
	@Override
	public void add(Address address,int userId) {
		User u =ud.load(userId);
		if(u==null)throw new ShopException("添加地址的用户不存在");
		address.setUser(u);
		super.add(address);
	}

	@Override
	public void delete(int id) {
		super.delete(Address.class, id);
	}

	@Override
	public void update(Address address) {
		super.update(address);
	}

	@Override
	public List<Address> list(int userId) {
		Map<String, Object> maps = new HashMap<String,Object>();
		maps.put("userId", userId);
		return super.list(Address.class, maps);
	}

}
