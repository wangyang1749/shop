package com.wangyang.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wangyang.model.Pagers;
import com.wangyang.model.SystemContext;
import com.wangyang.util.MyBatisUtil;

public class BaesDao<T> {
	/**
	 * 添加一条数据
	 * @param obj
	 */
	public void add(T obj){
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.insert(obj.getClass().getName()+".add", obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			MyBatisUtil.closeSession(session);
		}
	}
	/**
	 * 删除一条数据
	 * @param clz
	 * @param id
	 */
	public void delete(Class<T> clz,int id){
		SqlSession session =null;
		try {
			session = MyBatisUtil.createSession();
			session.delete(clz.getName()+".delete", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			MyBatisUtil.closeSession(session);
		}
	}
	/**
	 * 更新一条数据
	 * @param obj
	 */
	public void update(T obj){
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.update(obj.getClass().getName()+".update",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			MyBatisUtil.closeSession(session);
		}
	}
	/**
	 * 获取所有列表
	 * @param clz
	 * @param maps
	 * @return
	 */
	public List<T> list(Class<T> clz,Map<String, Object> maps){
		return this.list(clz.getName()+".list", maps);
	}
	/**
	 * 通用的获取所有列表
	 * @param sqlId
	 * @param maps
	 * @return
	 */
	public List<T> list(String sqlId,Map<String, Object> maps){
		List<T> list = null;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			list = session.selectList(sqlId, maps);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return list;
	}
	/**
	 * 根据id查找数据
	 * @param clz
	 * @param id
	 * @return
	 */
	public T load(Class<T> clz,int id){
		return this.loadBySqlId(clz.getName()+".load", id);
	}
	/**
	 * 通用的查找所有方法的列表
	 * @param sqlId
	 * @param id
	 * @return
	 */
	public T loadBySqlId(String sqlId,Object obj){
		SqlSession session = null;
		T t =null;
		try {
			session = MyBatisUtil.createSession();
			t =session.selectOne(sqlId, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSession(session);
		}
		return t;
	}
	/**
	 * 通用的查找所有方法的列表
	 * @param sqlId
	 * @param maps
	 * @return
	 */
	public T loadBySqlId(String sqlId,Map<String , Object> maps){
		SqlSession session = null;
		T t =null;
		try {
			session = MyBatisUtil.createSession();
			t =session.selectOne(sqlId, maps);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSession(session);
		}
		return t;
	}
	/**
	 * 分页的列表
	 * @param clz
	 * @param maps
	 * @return
	 */
	public Pagers<T> find(Class<T> clz,Map<String, Object> maps){
		return this.find(clz.getName()+".find", maps);
	}
	/**
	 * 通用的分页列表
	 * @param sqlId
	 * @param maps
	 * @return
	 */
	public Pagers<T> find(String sqlId,Map<String, Object> maps){
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getpageOffset();
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(maps==null)
			maps = new HashMap<String,Object>();
		maps.put("pageSize", pageSize);
		maps.put("pageOffset", pageOffset);
		maps.put("order", order);
		maps.put("sort", sort);
		
		Pagers<T> pages = new Pagers<T>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			List<T> list = session.selectList(sqlId, maps);
			pages.setList(list);
			pages.setPageOffset(pageOffset);
			pages.setPageSize(pageSize);
			int totalRecord = session.selectOne(sqlId+"_count", maps);
			pages.setTotalRecord(totalRecord);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return pages;
	}
	
	
	
	
	
	
	
}
