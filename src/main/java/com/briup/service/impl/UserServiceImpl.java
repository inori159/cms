package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.bean.UserExample;
import com.briup.bean.extend.UserExtend;
import com.briup.dao.UserMapper;
import com.briup.dao.extend.UserExtendMapper;
import com.briup.service.IUserService;
import com.briup.util.CustomerException;
import com.briup.vm.UserVm;

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
	public UserExtend findById(Integer id) {	
		return userExtendMapper.findById(id);
	}

	@Override
	public void insertOrUpdateUserRold(Integer userId,List<Integer> roleIds) {
		//如果用户的角色为空即直接插入
		//不为空的话即判断数据库已存在用户的的角色
		UserExtend userExtend = userExtendMapper.findById(userId);
		if(userExtend!=null)
		{
			List<Role> roles = userExtend.getRoles();
			List<Integer> new_roles = new ArrayList<>();
			//数据库的角色和新传入的角色ids,新ids不包含旧的ids,即删除数据库里旧的角色id
			for(Role r:roles)
			{
				if(!roleIds.contains(r.getId()))
				{
					//通过id删除桥表里的角色
					userExtendMapper.deleteUserRold(userId,r.getId());
				}
				else
				{
					new_roles.add(r.getId());
				}
			}
			//旧的ids里有新ids没有的id,即重新存储起来，并判断新ids是否包含新的id,将新的id最后插入数据库
			for(Integer i:roleIds)
			{
				if(!new_roles.contains(i))
				{
					userExtendMapper.insertUserRold(userId, i);
				}
			}
		}
		else
		{
			for(Integer i:roleIds)
			{
				userExtendMapper.insertUserRold(userId, i);
			}	
		}
		
		

	}

	@Override
	public User login(UserVm userVm) throws CustomerException {
	      UserExample example = new UserExample();
	      System.out.println(userVm.getUsername()+userVm.getPassword());
	        example.createCriteria().andUsernameEqualTo(userVm.getUsername());
	        List<User> list = userMapper.selectByExample(example);
	        if(list.size()<=0){
	            throw new CustomerException("该用户不存在");
	        }
	        User user = list.get(0);
	        if(!user.getPassword().equals(userVm.getPassword())){
	            throw new CustomerException("密码不匹配");
	        }
	        return user;
	}

	@Override
	public UserExtend cascadeFindById(Integer id) {
		
		return userExtendMapper.cascadeFindById(id);
	}

}
