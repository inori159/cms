package com.briup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.service.IRoleService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	IRoleService roleService;
	
	@ApiOperation(value = "设置角色权限")
	@PostMapping("setroleprivilege")
	public Message setRolePrivilege(@RequestParam(value = "roldId")Integer roldId,@RequestParam(value = "privilegeIds")List<Integer> privilegeIds)
	{
		roleService.insertOrUpdateRolePrivilege(roldId, privilegeIds);
		return MessageUtil.success("更新成功");
	}
	@ApiOperation(value = "查询所有角色")
	@GetMapping("findAll")
	public Message findAll()
	{
		return MessageUtil.success(roleService.findAll());
	}
}
