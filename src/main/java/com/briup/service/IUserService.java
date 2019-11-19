package com.briup.service;

import java.util.List;

import com.briup.bean.User;
import com.briup.bean.extend.UserExtend;

public interface IUserService {

	public List<User> findAll();
	
	public List<UserExtend> cascadeRoleFindAll();
	
	public void deleteById(Integer id);
	
	public void saveOrUpdate(User user);
	
	public void setRoles();
	
	public UserExtend findById(Integer id);
	
	public void insertUserRold(Integer userId,Integer[] roleIds);
}
