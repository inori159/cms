package com.briup.dao.extend;

import org.apache.ibatis.annotations.Param;

public interface RoleExtendMapper {
	public void insertRolePrivilege(@Param(value = "roldId")Integer roldId,@Param(value = "privilegeIds")Integer[] privilegeIds);
}
