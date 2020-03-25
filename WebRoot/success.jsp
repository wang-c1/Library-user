<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>购买成功</title>
	<link rel="stylesheet" href="css1/base.css" type="text/css" />
	<link rel="stylesheet" href="css1/shop_common.css" type="text/css" />
	<link rel="stylesheet" href="css1/shop_header.css" type="text/css" />
	<link rel="stylesheet" href="css1/shop_list.css" type="text/css" />
   
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/topNav.js" ></script>
    <style type="text/css">
		.shop_bd_error{width:1000px; height:50px; padding:100px 0; margin:10px auto 0; border:1px solid #ccc;}
		.shop_bd_error p{height:45px; line-height:66px; width:980px; text-align: center; font-size:20px; font-weight: bold; color:#55556F;}
		.shop_bd_error p span{display:inline-block;width:50px; height:55px; line-height:45px; overflow:hidden; text-indent: 99em; vertical-align:top; padding-right:10px; background:url('images/success.jpg') no-repeat left top;}
    </style>
</head>
 <body>
	<jsp:include page="top2.jsp"></jsp:include>

	<!-- Header End -->

	<!-- Body -->
	<div class="shop_bd_error">
		<p><span>成功</span>&nbsp&nbsp&nbsp成功</p>
	</div>
	<!-- Body End -->

	<!-- Footer - wll - 2013/3/24 -->
	<div class="clear"></div>
	<div class="shop_footer">
            <div class="shop_footer_link">
                <p>
                    <a href="">首页</a>|
                    <a href="">招聘英才</a>|
                    <a href="">广告合作</a>|
                    <a href="">关于ShopCZ</a>|
                    <a href="">关于我们</a>
                </p>
            </div>
            <div class="shop_footer_copy">
                <p>Copyright 2007-2013 ShopCZ Inc.,All rights reserved.<br />d by ShopCZ 2.4 </p>
            </div>
        </div>
	<!-- Footer End -->
</body>
</html>