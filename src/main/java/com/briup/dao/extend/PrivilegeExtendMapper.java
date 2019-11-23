package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.extend.PrivilegeExtend;

public interface PrivilegeExtendMapper {

	public List<PrivilegeExtend> findAll();
	
	public List<PrivilegeExtend> findById(Integer id);
	
	public List<PrivilegeExtend> findParantIdByUserId(Integer userId);
}
