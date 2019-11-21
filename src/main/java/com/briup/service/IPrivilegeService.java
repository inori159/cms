package com.briup.service;

import java.util.List;

import com.briup.bean.extend.PrivilegeExtend;

public interface IPrivilegeService {

	public List<PrivilegeExtend> findAll();
	
	public List<PrivilegeExtend> findById(Integer id);
}


