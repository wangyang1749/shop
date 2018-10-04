package com.wangyang.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wangyang.model.Pagers;
import com.wangyang.model.ShopException;
import com.wangyang.model.SystemContext;
import com.wangyang.model.User;
import com.wangyang.util.MyBatisUtil;

public class UserDao extends BaesDao<User> implements IUserDao {

	@Override
	public void add(User user) {
		User u = this.loadByUsername(user.getUsername());
		if(u!=null)throw new ShopException("用户名已经存在");
		super.add(user);
	}

	@Override
	public void delete(int id) {
		super.delete(User.class, id);
	}

	@Override
	public void update(User user) {
		super.update(user);
	}

	@Override
	public User load(int id) {
		return super.load(User.class, id);
	}

	@Override
	public User loadByUsername(String username) {
		return super.loadBySqlId(User.class.getName()+".load_by_username", username);
	}

	@Override
	public User login(String username, String password) {
		User u = this.loadByUsername(username);
		if(u==null)throw  new ShopException("用户名不存在");
		if(!password.equals(u.getPassword()))throw new ShopException("用户密码错误");
		return u;
	}

	@Override
	public Pagers<User> find(String name) {
		Map<String, Object> maps = new HashMap<String,Object>();
		if(name!=null&&!"".equals(name))
			maps.put("name","%"+name+"%");
		return super.find(User.class, maps);
	}

}
