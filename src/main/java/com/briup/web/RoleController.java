package com.briup.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/role")
public class RoleController {

	
	@ApiOperation(value = "设置角色权限")
	@PostMapping("setroleprivilege")
	public void setRolePrivilege(Integer roleId,Integer[] privilegeIds)
	{
		
	}
	
}
