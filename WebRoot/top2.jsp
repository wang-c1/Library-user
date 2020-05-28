<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">
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

.input {
	width: 300px;
	height: 35px;
	border-color: #66cc33;
	border-style: solid;
	border-width: 1px;
	list-style: none;
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
							您好，欢迎来到<b><a href="/">铭文书店</a></b>[<a href="login1.jsp">登录</a>][<a
								href="enroll1.jsp">注册</a>]
						</p>
					</s:if>
					<s:else>
						<p>
							<s:property value="#session.loginUser.userName" />
							您好，欢迎来到<b><a href="allBook.jsp">铭文书店</a></b>
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
								<div class="topNav_menu_bd" style="display: none;">
									<ul>
										<li><a title="已买到的商品" target="_top" href="allOrders.jsp">已买到的商品</a></li>
										<li><a title="个人主页" target="_top"
											href="address_edit1.jsp">个人主页</a></li>
									</ul>
								</div>
							</div>
						</li>

						<li>
							<div class="topNav_menu">

								<a href="showShopingCart" class="topNavHover">购物车 <b></b><i></i></a>
								<div class="topNav_menu_bd" style="display:none;">
									<p></p>
								</div>
							</div>
						</li>

						<!-- <li>
							<div class="topNav_menu">
								<a href="#" class="topNavHover">我的收藏<i></i></a>
								<div class="topNav_menu_bd" style="display: none;">
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
		<!-- Header TopNav End -->

		<!-- TopHeader Center -->
		<div class="shop_hd_header">
			<div class="shop_hd_header_logo">
				<h1 class="logo">
					<a href="/"><img src="images/logo.png" alt="ShopCZ" /></a><span>ShopCZ</span>
				</h1>
			</div>
			<div class="shop_hd_header_search">
				<div id="searchBook" style="margin-top: 0px;">
					<br /> <input type="radio" name="searchType" value="bookName"
						checked="checked" />名称 <input type="radio" name="searchType"
						value="bookAuthor" />作者 <input type="radio" name="searchType"
						value="bookPress" />出版社<br /> <input type="text"
						name="searchDescribe" id="searchDescribeID" class="input" /> <input
						type="button" value="" onclick="searchBook()" class="serach" />
				</div>


			</div>
		</div>
		<div class="clear"></div>
		<!-- TopHeader Center End -->

		<!-- Header Menu -->
		<div class="shop_hd_menu">
			<!-- 所有商品菜单 -->

			<div id="shop_hd_menu_all_category" class="shop_hd_menu_all_category">
				<!-- 首页去掉 id="shop_hd_menu_all_category" 加上clsss shop_hd_menu_hover -->
				<div class="shop_hd_menu_all_category_title">
					<h2 title="所有商品分类">
						<a href="javascript:void(0);">所有商品分类</a>
					</h2>
					<i></i>
				</div>
				<div id="shop_hd_menu_all_category_hd"
					class="shop_hd_menu_all_category_hd">
					<ul class="shop_hd_menu_all_category_hd_menu clearfix">
						<!-- 单个菜单项 -->

						<s:action name="bookTypeAction" executeResult="false"></s:action>

						<s:iterator value="#request.bookType">
							<li id="cat_1" class="">
								<h3>
									<a
										href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="typeId"/>"
										title="图书"><s:property value="typeName" /></a>
								</h3>

							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<!-- 所有商品菜单 END -->

			<!-- 普通导航菜单 -->
			<ul class="shop_hd_menu_nav">
				<li class="link"><a href="allBook.jsp"><span>销量排行</span></a></li>
				<li class="link"><a href="newBook.jsp"><span>最新上架</span></a></li>
				<li class="link"><a href="bargainBook.jsp"><span>特价邀约</span></a></li>
				<%-- <li class="link"><a href="goods2.jsp"><span>优惠卷</span></a></li>
				<li class="link"><a href="shoppingCart.jsp"><span>积分中心</span></a></li>
				<li class="link"><a href=""><span>运动专场</span></a></li>
				<li class="link"><a href=""><span>微商城</span></a></li> --%>
			</ul>
			<!-- 普通导航菜单 End -->
		</div>
		<!-- Header Menu End -->

	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

	<!-- Header End -->
</body>
<SCRIPT type="text/javascript">
	function searchBook() {
		var searchType = "";
		for (i = 0; i < document.all.searchType.length; i++) {
			if (document.all.searchType[i].checked) {
				searchType = document.all.searchType[i].value;
			}
		}
		var searchDescribe = document.getElementById("searchDescribeID").value;
		location.href = "oneType.jsp?searchType=" + searchType
				+ "&searchDescribe=" + searchDescribe;
	}
</SCRIPT>
</html>