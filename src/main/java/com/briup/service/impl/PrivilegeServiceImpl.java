package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Privilege;
import com.briup.bean.PrivilegeExample;
import com.briup.bean.extend.PrivilegeExtend;
import com.briup.dao.PrivilegeMapper;
import com.briup.dao.extend.PrivilegeExtendMapper;
import com.briup.service.IPrivilegeService;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Autowired
	PrivilegeMapper privilegeMapper;
	
	@Autowired
	PrivilegeExtendMapper privilegeExtendMapper;
	
	@Override
	public List<PrivilegeExtend> findAll() {	
		return privilegeExtendMapper.findAll();
	}

	@Override
	public List<PrivilegeExtend> findById(Integer id) {
		
		return privilegeExtendMapper.findById(id);
	}

	@Override
	public List<Privilege> findByParentId(Integer id) {
        PrivilegeExample example = new PrivilegeExample();
       
        example.createCriteria().andParentIdEqualTo(id); 
        System.out.println("执行权限");
        return privilegeMapper.selectByExample(example);
	}

	@Override
	public List<PrivilegeExtend> findParantIdByUserId(Integer userId) {	
		return privilegeExtendMapper.findParantIdByUserId(userId);
	}

}
