<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="stylesheet" href="css1/base.css" type="text/css" />
<link rel="stylesheet" href="css1/shop_common.css" type="text/css" />
<link rel="stylesheet" href="css1/shop_header.css" type="text/css" />
<link rel="stylesheet" href="css1/shop_home.css" type="text/css" />
<!-- <link rel="stylesheet" type="text/css" href="css/styles.css"></link> -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/topNav.js"></script>
<script type="text/javascript" src="js/focus.js"></script>
<script type="text/javascript" src="js/shop_home_tab.js"></script>
<style type="text/css">
a {
	font-size: 12px;
	text-decoration: none;
	color: black;
}

a:HOVER {
	color: red;
	text-decoration: none;
}

.serach {
	position: absolute;
	margin-left: 5px;
	margin-top: 3px;
	width: 62px;
	height: 24px;
	background-image: url("images/nc_search_btn.gif");
	background-color: #66cc33;
	border: 0;
	list-style: none;
	border-style: none;
}

.ts_seled {
    color: #F00;
}
 
.ts_sel {
   color:#666;
}

.input {
	width: 300px;
	height: 35px;
	border-color: #66cc33;
	border-style: solid;
	border-width: 1px;
	list-style: none;
}
.move{
    height: 4px;
    width: 110px;
    border-top: 4px solid red;/*只需要将上边显示出来*/
    position: absolute;
    left: 0;
    top: 31px;
    transition: left .2s ease-in-out 0s;/*包含四个过度属性：执行变换属性、执行时间、速率、延迟*/
    -webkit-transition: left .2s ease-in-out 0s;/*chrome和safari*/
    -moz-transition: left .2s ease-in-out 0s;/*firefox*/
    -o-transition: left .2s ease-in-out 0s;/*opera*/
}
li:nth-child(1):hover~ .move{    /*li元素的父元素的第一个子元素，当鼠标停留其上时，move元素的left属性改变*/
    left: 210px;
}
li:nth-child(2):hover~ .move{
    left: 328px;
}
li:nth-child(3):hover~ .move{
    left: 446px;
}
</style>

</head>


<body>
	<!-- Header  -wll-2013/03/24 -->
	<div class="shop_hd">
		<!-- Header TopNav -->
		<div class="shop_hd_topNav">
			<div class="shop_hd_topNav_all">
				<!-- Header TopNav Left -->
				<div class="shop_hd_topNav_all_left">
					<s:if test="%{#session.loginUser == null}">
						<p>
							您好，欢迎光临<b><a href="/">铭文书店</a></b>[<a href="login1.jsp">登录</a>][<a
								href="enroll1.jsp">注册</a>]
						</p>
					</s:if>
					<s:else>
						<p>
							<s:property value="#session.loginUser.userName" />
							您好，欢迎光临<b><a href="allBook.jsp">铭文书店</a></b>
						</p>
					</s:else>
				</div>
				<!-- Header TopNav Left End -->

				<!-- Header TopNav Right -->
				<div class="shop_hd_topNav_all_right" style="margin-right: -174px;">
					<ul class="topNav_quick_menu">

						<li>
							<div class="topNav_menu">
								<a href="#" class="topNavHover">我的商城<i></i></a>
								<div class="topNav_menu_bd" style="display:none;">
									<ul>
										<li><a title="已买到的商品" target="_top" href="showAllOrders">已买到的商品</a></li>
										<li><a title="" target="_top" href="address_edit1.jsp">个人主页</a></li>
									</ul>
								</div>
							</div>
						</li>


						<li>
							<div class="topNav_menu">

								<a href="showShopingCart" class="topNavHover">购物车 <b></b><i></i></a>
								<div class="topNav_menu_bd" style="display:none;">
									<!--
						            <ul>
						              <li><a title="已售出的商品" target="_top" href="#">已售出的商品</a></li>
						              <li><a title="销售中的商品" target="_top" href="#">销售中的商品</a></li>
						            </ul>
						        	-->
									<p></p>
								</div>
							</div>
						</li>

						<!-- <li>
							<div class="topNav_menu">
								<a href="#" class="topNavHover">我的收藏<i></i></a>
								<div class="topNav_menu_bd" style="display:none;">
									<ul>
										<li><a title="收藏的商品" target="_top" href="#">收藏的商品</a></li>
										<li><a title="收藏的店铺" target="_top" href="#">收藏的店铺</a></li>
									</ul>
								</div>
							</div>
						</li> -->
						
						<li>
							<div class="topNav_menu">
								<a href="login1.jsp">安全退出</a>
							</div>
						</li>

					</ul>
				</div>
				<!-- Header TopNav Right End -->
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<!-- Header TopNav End -->

	<!-- TopHeader Center -->
	<div class="shop_hd_header">
		<div class="shop_hd_header_logo">
		    <img src="images/logo.png" alt="" width="350" height="90"/>
		    <!-- 
			<h1 class="logo">
				<a href="/"><img src="images/logo.png" alt="" width="350" height="90"/></a><span>冰菓</span>
				<!-- <img src="images/logo.png" alt="" />-->
			</h1>
			-->
		</div>
		<div class="shop_hd_header_search">
			
			<div id="searchBook" style="margin-top: 0px;">
				<br/> 
				<input type="radio" name="searchType" value="bookName" checked="checked" />名称 
				<input type="radio" name="searchType" value="bookAuthor" />作者
				<input type="radio" name="searchType" value="bookPress" />出版社
				<br/> 
				<input type="text" name="searchDescribe" id="searchDescribeID" class="input" /> 
				<input type="button" value="" onclick="searchBook()" class="serach" />
			</div>


		</div>
	</div>
	<div class="clear"></div>
	<!-- TopHeader Center End -->


	<!-- Header Menu -->
	<div class="shop_hd_menu">
		<!-- 所有商品菜单 -->

		<div class="shop_hd_menu_all_category shop_hd_menu_hover">
			<!-- 首页去掉 id="shop_hd_menu_all_category" 加上clsss shop_hd_menu_hover -->
			<div class="shop_hd_menu_all_category_title">
				<h2 title="所有图书分类">
					<a href="javascript:void(0);">所有图书分类</a>
				</h2>
				<i></i>
			</div>
			<div id="shop_hd_menu_all_category_hd" class="shop_hd_menu_all_category_hd">
				<ul class="shop_hd_menu_all_category_hd_menu clearfix">
					<s:action name="bookTypeAction" executeResult="false"></s:action>
					<s:iterator value="#request.bookType">
						<li id="cat_1" class="">
							<h3>
								<a href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="typeId"/>"
									title="图书"><s:property value="typeName" /></a>
							</h3>

						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<!-- 所有商品菜单 END -->



     <div class="nav-box">
		<ul class="shop_hd_menu_nav">
			<li class="link"><a href="allBook.jsp"><span>销量排行</span></a></li>
			<li class="link"><a href="newBook.jsp"><span>最新上架</span></a></li>
			<li class="link"><a href="bargainBook.jsp"><span>特价邀约</span></a></li>
			<li class="move"></li>
		</ul>
		<div class="nav-line" ></div>
	</div>


        <script type="text/javascript" src="js/jquery.js"></script>
		<SCRIPT type="text/javascript">
			function searchBook() {
				var searchType = "";
				for (i = 0; i < document.all.searchType.length; i++) {
					if (document.all.searchType[i].checked) {
						searchType = document.all.searchType[i].value;
					}
				}
				var searchDescribe = document
						.getElementById("searchDescribeID").value;
				 
				  location.href = "oneType.jsp?searchType=" + searchType
						+ "&searchDescribe=" + searchDescribe;  
			}
		</SCRIPT>
</body>
</html>