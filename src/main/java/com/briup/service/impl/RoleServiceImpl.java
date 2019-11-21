package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Privilege;
import com.briup.bean.Role;
import com.briup.bean.RoleExample;
import com.briup.bean.extend.RoleExtend;
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
	public List<Role> findAll() {
		
		return roleMapper.selectByExample(new RoleExample());
	}


	@Override
	public void insertOrUpdateRolePrivilege(Integer roldId, List<Integer> privilegeIds) {
		RoleExtend roleExtend = roleExtendMapper.findById(roldId);
		
		if(roleExtend!=null)
		{
			List<Privilege> privileges = roleExtend.getPrivileges();
			List<Integer> new_privileges = new ArrayList<Integer>();
			for(Privilege p:privileges)
			{
				if(!privilegeIds.contains(p.getId()))
				{
					roleExtendMapper.deleteRolePrivilege(p.getId());
				}
				else
				{
					new_privileges.add(p.getId());
				}
			}
			for(Integer i :privilegeIds)
			{
				if(!new_privileges.contains(i))
				{
					roleExtendMapper.insertOrUpdateRolePrivilege(roldId, i);
				}
			}		
		}
		else
		{
			for(Integer i :privilegeIds)
			{
				roleExtendMapper.insertOrUpdateRolePrivilege(roldId, i);
			}
		}

	}

}
