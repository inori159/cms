package com.briup.service;

import java.util.List;

import com.briup.bean.Role;

public interface IRoleService {

	public List<Role> findAll();
	
	public void insertRolePrivilege(Integer roldId,Integer[] privilegeIds);
}
