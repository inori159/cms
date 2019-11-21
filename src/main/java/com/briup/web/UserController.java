package com.briup.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.service.IUserService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;
import com.briup.vm.UserVm;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;
	
	@ApiOperation(value = "查询所有用户")
	@GetMapping("findAll")
	public Message findAll()
	{
		return MessageUtil.success("查询成功", userService.findAll());
	}
	
	@ApiOperation(value = "所有用户")
	@GetMapping("cascadeRoleFindAll")
	public Message cascadeRoleFindAll()
	{
		return MessageUtil.success("查询成功", userService.cascadeRoleFindAll());
	}
	
	
	
	
	@ApiOperation(value = "登录")
	@PostMapping(value = "login")
	public Message login(@RequestBody UserVm userVm)
	{
		Map<String,String> map = new HashMap<>();
		map.put("token", "admin-token");	
		return MessageUtil.success(map);
	}
	
    @ApiOperation(value = "退出")
    @PostMapping(value = "logout")
    public Message logout(){
        // 1. 将缓存中token移除
        // 2. 其他
        return MessageUtil.success("success");
    }
    
    @ApiOperation(value = "通过token获取用户信息")
    @GetMapping(value = "info")
    public Message info(String token)
    {    	
		return MessageUtil.success(userService.findById(1));
    }
    
    
    
    
    
    @ApiOperation(value ="设置用户角色")
    @PostMapping(value = "insertOrUpdateUserRold")
    public Message insertOrUpdateUserRold(@RequestParam(value ="userId")Integer userId,@RequestParam(value ="roleIds")List<Integer> roleIds)
    {
    	userService.insertOrUpdateUserRold(userId, roleIds);
		return MessageUtil.success("更新成功");
    }
}
