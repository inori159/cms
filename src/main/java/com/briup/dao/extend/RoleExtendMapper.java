package com.briup.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.bean.extend.RoleExtend;

public interface RoleExtendMapper {
	public void insertOrUpdateRolePrivilege(@Param(value = "roldId")Integer roldId,@Param(value = "privilegeId")Integer privilegeId);
	public RoleExtend findById(Integer roldId);
	public void deleteRolePrivilege(Integer id);
	public List<RoleExtend> cascadePrivilegeFindAll();
}
