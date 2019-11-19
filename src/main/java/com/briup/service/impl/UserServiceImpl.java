package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.User;
import com.briup.bean.UserExample;
import com.briup.bean.extend.UserExtend;
import com.briup.dao.UserMapper;
import com.briup.dao.extend.UserExtendMapper;
import com.briup.service.IUserService;
import com.briup.util.CustomerException;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserExtendMapper userExtendMapper;
	
	@Override
	public List<User> findAll() {	
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public List<UserExtend> cascadeRoleFindAll() {		
		return userExtendMapper.cascadeRoleFindAll();
	}

	@Override
	public void deleteById(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.getId()!=null)
		{
			userMapper.updateByPrimaryKey(user);
		}
		else
		{
			List<User> list = findAll();
			for(User u:list)
			{
				if(u.getUsername().equals(user.getUsername()))
				{
					throw new CustomerException();
				}
			}
			userMapper.insert(user);
			
		}
	}

	@Override
	public void setRoles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserExtend findById(Integer id) {	
		return userExtendMapper.findById(id);
	}

	@Override
	public void insertUserRold(Integer userId, Integer[] roleIds) {
		userExtendMapper.insertUserRold(userId, roleIds);
	}

}
