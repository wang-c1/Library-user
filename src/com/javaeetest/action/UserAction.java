package com.javaeetest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.User;
import com.javaeetest.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String userName;
	private String userPassword;
	private UserServiceImpl userService;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserServiceImpl getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	/**
	 * 用户登录
	 */
	@Override
	public String execute() throws Exception {
		String page = "fail";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = new User();
		user = userService.loginValid(userName, userPassword);

		System.out.println(user);
		if (user != null) {
			page = "success";
			// 将该用户信息存入session中
			if (session.getAttribute("loginUser") != null) {
				session.removeAttribute("loginUser");
			}
			session.setAttribute("loginUser", user);

		}

		System.out.println(page);
		return page;
	}

	/**
	 * 更改密码
	 * 
	 */
	public String changePassword() {
		String page = "fail";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String updateType = request.getParameter("updateType");
		User user = new User();
		System.out.println(((User) session.getAttribute("loginUser"))
				.getUserPassword());
		if ("change".equals(updateType)) {
			String password = request.getParameter("password");
			if (password.equals(((User) session.getAttribute("loginUser"))
					.getUserPassword())) {
				user.setUserPassword(userPassword);
				user.setUserId(((User) session.getAttribute("loginUser"))
						.getUserId());
				user.setUserName(((User) session.getAttribute("loginUser"))
						.getUserName());
				user.setUserEmail(((User) session.getAttribute("loginUser"))
						.getUserEmail());
				user.setUserNickName(((User) session.getAttribute("loginUser"))
						.getUserNickName());
				user.setUserPhone(((User) session.getAttribute("loginUser"))
						.getUserPhone());
				user.setUserRemark(((User) session.getAttribute("loginUser"))
						.getUserRemark());
				user.setUserSex(((User) session.getAttribute("loginUser"))
						.getUserSex());
				boolean flag = userService.changePassword(user);
				System.out.println(user.getUserPassword());
				System.out.println(flag);
				page = "success";

			} else {
				page = "fail";
				request.setAttribute("pwE", "F");
			}
		}
		return page;
	}
}
