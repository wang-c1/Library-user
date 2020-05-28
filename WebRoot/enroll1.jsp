<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>用户注册</title>
	<link rel="stylesheet" href="css1/base.css" />
	<link rel="stylesheet" href="css1/global.css" />
	<link rel="stylesheet" href="css1/login-register.css" />
	<script src="./js/login.js"></script>
</head>
<body>
	<div class="header wrap1000">
		<a href=""><img src="images/logo.png" alt="" /></a>
	</div>
	
	<div class="main">
		<div class="login-form fr">
			<div class="form-hd">
				<h3>用户注册</h3>
			</div>
			<div class="form-bd">
				<font color="red"><s:fielderror></s:fielderror></font>
				<form action="enrollAction">
					<dl>
						<dt>用户名</dt>
						<dd><input type="text" name="userName" class="text" /></dd>
					</dl>
					<dl>
						<dt>密码</dt>
						<dd><input type="password" name="userPassword" id="userPassword" onblur="jiam(id)" class="text"/></dd>
					</dl>
					<dl>
						<dt>确认密码</dt>
						<dd><input type="password" name="userRePassword" id="userRePassword" onblur="jiam(id)" class="text"/></dd>
					</dl>
					<dl>
						<dt>邮箱</dt>
						<dd><input type="text" name="userEmail" class="text"/></dd>
					</dl>
					
					<dl>
						<dt>昵称</dt>
						<dd><input type="text" name="userNickName" class="text"/></dd>
					</dl>
					
					<dl>
						<dt>性别</dt>
						<dd><s:radio name="userSex" 
					labelposition="left" list="#{'man':'男','woman':'女'}" value="'man'">
					</s:radio>
					
					</dd>
					</dl>
					
					
					<dl>
						<dt>联系电话</dt>
						<dd><input type="text" name="userPhone" class="text" 
						     
						/></dd>
					</dl>
					
					<dl>
						<dt>备注</dt>
						<dd><input type="text" name="userRemark" class="text" 
						     
						/></dd>
					</dl>
					
					<dl>
						<dt>验证码</dt>
						<dd><input type = "text" id = "input" name="code" class="text" size="10" style="width:58px;"/>
						<input type = "button" id="code" onclick="createCode()"/>看不清，<a href="login1.jsp">换一张</a>
						</dd>
						
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd><input type="submit" value="立即注册" class="submit"/> <input type= "checkbox" checked="checked"/>阅读并同意<a href="" class="forget">服务协议</a></dd>
					</dl>
				</form>
				
			</div>
			<div class="form-ft">
			
			</div>		
		</div>
		
			<div class="if">
				<span>如果您是本站用户 &nbsp;&nbsp;&nbsp;&nbsp;</span>
				<span>我已经注册过账号，立即 <a href="login1.jsp" class="register">登录</a> 或是 <a href="" class="findpwd">找回密码？</a></span>
			</div>
	</div>
	
	<script src="./js/MD5.js"></script>
	<script type="text/javascript">
	
	function jiam(id){
		var sd=document.getElementById(id).value;
		document.getElementById(id).value= hex_md5(sd);

	}
	</script>
	
</body>
</html>
