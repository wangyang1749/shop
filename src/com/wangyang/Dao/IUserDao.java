package com.wangyang.Dao;

import com.wangyang.model.Pagers;
import com.wangyang.model.User;

public interface IUserDao {
	public void add(User user);
	public void delete(int id);
	public void update(User user);
	public User load(int id);
	public User loadByUsername(String username);
	public User login(String username,String password);
	public Pagers<User> find(String name);
}
