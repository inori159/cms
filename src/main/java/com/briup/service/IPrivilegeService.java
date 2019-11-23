package com.briup.service;

import java.util.List;

import com.briup.bean.Privilege;
import com.briup.bean.extend.PrivilegeExtend;

public interface IPrivilegeService {

	public List<PrivilegeExtend> findAll();
	
	public List<PrivilegeExtend> findById(Integer id);
	
	public List<Privilege> findByParentId(Integer parentId);
	
	public List<PrivilegeExtend> findParantIdByUserId(Integer userId);
	
}


