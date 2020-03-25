package com.javaeetest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Manager;
import com.javaeetest.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager>{

	private Manager model = new Manager();
	private ManagerService managerService;


	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int userId = managerService.loginValid(model);
		if(userId > 0){
			if(session.getAttribute("managerLoginName") != null){
				return ERROR;
			}else{
				session.setAttribute("managerLoginName", model.getManagerName());
				addActionMessage("登陆成功");
				return SUCCESS;
			}
		}else{
			addActionError("请输入正确的密码");
			return INPUT;
		}
	}

	@Override
	public Manager getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
