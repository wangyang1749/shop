package com.wangyang.Dao;

import java.util.List;

import com.wangyang.model.Address;

public interface IAdderssDao {
	public void add(Address address,int userId);
	public void delete(int id);
	public void update(Address address);
	public List<Address> list(int useId);
}
