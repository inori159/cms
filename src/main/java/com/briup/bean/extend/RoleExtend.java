package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Privilege;
import com.briup.bean.Role;

public class RoleExtend extends Role{
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	private List<Privilege> privileges;
}
