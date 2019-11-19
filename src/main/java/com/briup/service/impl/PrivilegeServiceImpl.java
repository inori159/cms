package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.PrivilegeExample;
import com.briup.bean.extend.PrivilegeExtend;
import com.briup.dao.PrivilegeMapper;
import com.briup.dao.extend.PrivilegeExtendMapper;
import com.briup.service.IPrivilegeService;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Autowired
	PrivilegeExtendMapper privilegeExtendMapper;
	
	@Override
	public List<PrivilegeExtend> findAll() {	
		return privilegeExtendMapper.findAll();
	}

}
