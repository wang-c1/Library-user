package com.javaeetest.action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.User;
import com.javaeetest.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EnrollAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserServiceImpl userService;

	public UserServiceImpl getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	/**
	 * 用户注册
	 */
	public String execute() {

		System.out.println(userService.saveUser(user));

		return SUCCESS;

	}

	/**
	 * 判断用户输入是否合法
	 */
	public void validate() {

		String patternName = "[a-zA-Z][a-zA-Z0-9]{5,15}";
		String patternEmail = "\\w+@(\\w+.)+[a-z]{2,3}";
		String patternTel = "^((13[0-9])|(17[0-9])|(15[0-9])|18[0,5-9])\\d{8}$";

		if (user.getUserName() == null || "".equals(user.getUserName().trim())) {
			this.addFieldError("userName", "用户名不能为空!");

		} else if (!Pattern.compile(patternName)
				.matcher(user.getUserName().trim()).matches()) {
			this.addFieldError("username", "用户名必须以字母开始，且长度在6~20之间!");

		}

		if (user.getUserPassword().trim().length() < 6
				|| user.getUserPassword().trim().length() > 50) {
			this.addFieldError("userPassword", "密码长度必须在6~50之间!");

		}
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(ServletActionContext.HTTP_REQUEST);
		// System.out.println(request.getAttribute("userRePassword"));
		if (!request.getParameter("userRePassword").equals(
				user.getUserPassword())) {
			this.addFieldError("userRePassword", "两次输入的密码不一致!");

		}

		if ("".equals(user.getUserEmail().trim())) {
			this.addFieldError("userEmail", "邮箱不能为空!");

		}

		if (!Pattern.compile(patternEmail).matcher(user.getUserEmail().trim())
				.matches()) {
			this.addFieldError("userEmail", "邮箱输入有误!");

		}
		if (!Pattern.compile(patternTel).matcher(user.getUserPhone().trim())
				.matches()) {
			this.addFieldError("userPhone", "联系电话输入有误!");

		}

	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
