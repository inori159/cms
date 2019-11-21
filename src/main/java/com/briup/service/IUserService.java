package com.briup.service;

import java.util.List;

import com.briup.bean.User;
import com.briup.bean.extend.UserExtend;

public interface IUserService {

	public List<User> findAll();
	
	public List<UserExtend> cascadeRoleFindAll();
	
	public void deleteById(Integer id);
	
	public void saveOrUpdate(User user);	
	
	public UserExtend findById(Integer id);
	
	public void insertOrUpdateUserRold(Integer userId,List<Integer> roleIds);
}
