<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>用户登录</title>
	<link rel="stylesheet" href="css1/base.css" />
	<link rel="stylesheet" href="css1/global.css" />
	<link rel="stylesheet" href="css1/login-register.css" />
	
</head>
<body>
	
	<div class="header wrap1000">
		<a href=""><img src="images/logo.png" alt="logo" /></a>
	</div>
	
	<div class="main">
		<div class="login-form fr">
			<div class="form-hd">
				<h3>用户登录</h3>
			</div>
			<div class="form-bd">
				<form action="loginAction" id="formed" method = 'post'>
					<dl>
						<dt>用户名</dt>
						<dd><input type="text" name="userName" id="userName" class="text" placeholder="Username"/></dd>
					</dl>
					<!-- <dl>
						<dt>密&nbsp;&nbsp;&nbsp;&nbsp;码</dt>
						<dd><input type="password" name="userPassword" id="userPassword" onblur="jiam(id)" class="text" placeholder="password"/></dd>
					</dl>-->
					<dl>
						<dt>密&nbsp;&nbsp;&nbsp;&nbsp;码</dt>
						<dd><input type="password" id="userPassword" class="text" placeholder="password"  name="userPassword"/></dd>
					</dl>
					<dl>
						<dt>验证码</dt>
						<dd><input type = "text" id = "input" name="code" class="text" size="10" style="width:58px;"/>
						<input type = "button" id="code" onclick="createCode()"/>看不清，<a href="login1.jsp">换一张</a>
						</dd>
						
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<!-- 此用户中所有的session清空，与其他用户无关 -->
						<%session.invalidate();%>
						<dd><input type="button" value="登  录" class="submit" onclick = "validate()"/> <a href="" class="forget">忘记密码?</a></dd>
					</dl>
				</form>
				<dl>
					<dt>&nbsp;</dt>
					<dd> 还不是本站会员？立即 <a href="enroll1.jsp" class="register">注册</a></dd>
				</dl>
				<dl class="other">
					<dt>&nbsp;</dt>
					<dd>
						<p>您可以用合作伙伴账号登录：</p>
						<a href="" class="qq"></a>
						<a href="" class="sina"></a>
					</dd>
				</dl>
			</div>		
		</div>
		
		<!-- <div class="login-form-left fl">
			<img src="images/left.jpg" alt="" />
		</div> -->
	</div>
	
	<div class="footer clear wrap1000">
		<p> <a href="">首页</a> | <a href="">招聘英才</a> | <a href="">广告合作</a> |  <a href="">联系我们</a></p>
		<p>Copyrights Reserved harbin institute of technology at WeiHai.</p>
	</div>
	<script src="./js/login.js"></script>
	<script src="./js/MD5.js"></script>
	<script type="text/javascript">
	
	function jiam(id){
		var sd=document.getElementById(id).value;
		document.getElementById(id).value= hex_md5(sd);

	}
	</script>
</body>
</html>
