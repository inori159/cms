package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.RoleExample;
import com.briup.dao.RoleMapper;
import com.briup.dao.extend.RoleExtendMapper;
import com.briup.service.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	RoleExtendMapper roleExtendMapper;
	
	@Override
	public void insertRolePrivilege(Integer roldId, Integer[] privilegeIds) {
		roleExtendMapper.insertRolePrivilege(roldId, privilegeIds);
	}

	@Override
	public List<Role> findAll() {
		
		return roleMapper.selectByExample(new RoleExample());
	}

}
