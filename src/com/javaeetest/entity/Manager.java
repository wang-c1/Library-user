package com.javaeetest.entity;

public class Manager {
	private Integer managerId;
	private String managerName;
	private String managerPassword;

	public Manager() {
		
	}

	public Manager(String managerName, String managerPassword) {
		this.managerName = managerName;
		this.managerPassword = managerPassword;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

}
