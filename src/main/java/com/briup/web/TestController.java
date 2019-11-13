package com.briup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Test;
import com.briup.service.ITestService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	ITestService its; 
	
	@GetMapping("findAll")
	public List<Test> findAll()
	{
		return its.findAll();
	}
	
	@PostMapping("saveUpdata")
	public String saveUpdata(Test test)
	{
		its.saveOrUpdate(test);
		return "更新成功";
	}
	
	
}
