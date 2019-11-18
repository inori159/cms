package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Privilege;

public class PrivilegeExtend extends Privilege{
	
	public List<Privilege> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Privilege> childrens) {
		this.childrens = childrens;
	}

	private List<Privilege> childrens;
}
