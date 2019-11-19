package com.briup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.service.IPrivilegeService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	
	@Autowired
	IPrivilegeService privilegeService;
	
	@ApiOperation(value = "查询所有权限")
	@GetMapping("findAll")
	public Message findAll()
	{
		return MessageUtil.success(privilegeService.findAll());		
	}
}
