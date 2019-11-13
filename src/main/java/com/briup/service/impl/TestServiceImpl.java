package com.briup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Test;
import com.briup.bean.TestExample;
import com.briup.dao.TestMapper;
import com.briup.service.ITestService;

@Service
public class TestServiceImpl implements ITestService{
	
	@Resource
	TestMapper tm;
	
	@Override
	public List<Test> findAll() {	
		
		return tm.selectByExample(new TestExample());
	}

	@Override
	public void saveOrUpdate(Test test) {
		if(test!=null)
		{
			System.out.println(1);
			tm.updateByPrimaryKey(test);
		}
		else
		{
			System.out.println(2);
			tm.insert(test);
		}
	}

}
