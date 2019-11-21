package com.briup.service;

import java.util.List;

import com.briup.bean.Role;

public interface IRoleService {

	public List<Role> findAll();
	
	public void insertOrUpdateRolePrivilege(Integer roldId,List<Integer> privilegeIds);
}
