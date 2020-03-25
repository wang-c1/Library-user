package com.javaeetest.interceptor;

import java.util.Map;

import com.javaeetest.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserLoginCheck extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map session=ai.getInvocationContext().getSession();
		User user=(User)session.get("loginUser");
		
		if(user!=null)
		{
			return ai.invoke();
		}
		else{
			return "nologin";
		}
		
	}

}
