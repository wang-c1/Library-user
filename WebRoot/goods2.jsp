<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>商品详细页面</title>
<link rel="stylesheet" href="css1/base.css" type="text/css" />
<link rel="stylesheet" href="css1/shop_common.css" type="text/css" />
<link rel="stylesheet" href="css1/shop_header.css" type="text/css" />
<link rel="stylesheet" href="css1/shop_list.css" type="text/css" />
<link rel="stylesheet" href="css1/shop_goods.css" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/topNav.js"></script>
<script type="text/javascript" src="js/shop_goods.js"></script>

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
	background-color: darkorange;
	border: 0;
	list-style: none;
	border-style: none;
}

.input {
	width: 300px;
	height: 35px;
	border-color: #FF6600;
	border-style: solid;
	border-width: 1px;
	list-style: none;
}
</style>

</head>
<body>

	<jsp:include page="top2.jsp"></jsp:include>


	</div>
	<div class="clear"></div>
	<!-- 面包屑 注意首页没有 -->
	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong> <span> <a href="">首页</a>&nbsp;›&nbsp; <a
			href="">商品详情</a>&nbsp;›&nbsp;
		</span>
	</div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

	<!-- Header End -->
	<s:action name="singleBookAction" executeResult="false"></s:action>
	<!-- Goods Body -->
	<div class="shop_goods_bd clear">

		<!-- 商品展示 -->
		<div class="shop_goods_show">
			<div class="shop_goods_show_left">
				<!-- 京东商品展示 -->
				<link rel="stylesheet" href="css1/shop_goodPic.css" type="text/css" />
				<script type="text/javascript" src="js/shop_goodPic_base.js"></script>
				<script type="text/javascript" src="js/lib.js"></script>
				<script type="text/javascript" src="js/163css.js"></script>
				<div id="preview">
					<div class=jqzoom id="spec-n1" onClick="window.open('/')">
						<IMG height="350"
							src='upload/<s:property value="#request.singleBook.bookPicture"/>'
							jqimg='upload/<s:property value="#request.singleBook.bookPicture"/>'
							width="350"></IMG>
					</div>
				</div>

				<SCRIPT type=text/javascript>
					$(function() {
						$(".jqzoom").jqueryzoom({
							xzoom : 400,
							yzoom : 400,
							offset : 10,
							position : "right",
							preload : 1,
							lens : 1
						});
						$("#spec-list").jdMarquee({
							deriction : "left",
							width : 350,
							height : 56,
							step : 2,
							speed : 4,
							delay : 10,
							control : true,
							_front : "#spec-right",
							_back : "#spec-left"
						});
						$("#spec-list img").bind("mouseover", function() {
							var src = $(this).attr("src");
							$("#spec-n1 img").eq(0).attr({
								src : src.replace("\/n5\/", "\/n1\/"),
								jqimg : src.replace("\/n5\/", "\/n0\/")
							});
							$(this).css({
								"border" : "2px solid #ff6600",
								"padding" : "1px"
							});
						}).bind("mouseout", function() {
							$(this).css({
								"border" : "1px solid #ccc",
								"padding" : "2px"
							});
						});
					})
				</SCRIPT>
				<!-- 京东商品展示 End -->

			</div>
			<s:action name="singleBookAction" executeResult="false"></s:action>
			<div class="shop_goods_show_right">
				<ul>
					<li><strong style="font-size:22px; font-weight:bold;">
							<s:property value="#request.singleBook.bookName" />
					</strong></li>
					<li><label>作者：</label> <span><s:property
								value="#request.singleBook.bookAuthor" /></span></li>
					<li><label>出版社：</label> <span><s:property
								value="#request.singleBook.bookPress" /></span></li>

					<li><label>累计售出：</label> <span><s:property
								value="#request.singleBook.bookSales" /></span></li>
					<li><label>类别：</label> <span><s:property
								value="#request.singleBook.type.typeName" /></span></li>
					<li><label>库存：</label> <span id="bookAmont"><s:property
								value="#request.singleBook.bookAmount" /> </span></li>
					<s:if
						test="%{#request.singleBook.bookPrice!=#request.singleBook.bookNewPrice}">
						<li><label>原价：</label> <span><font
								style="text-decoration: line-through;color:black;"><s:property
										value="#request.singleBook.bookPrice" /></font>元</span></li>
						<li><label>现价：</label> <span><strong><s:property
										value="#request.singleBook.bookNewPrice" /> </strong></span></li>

					</s:if>
					<s:else>
						<li><label>价格：</label> <span><strong><s:property
										value="#request.singleBook.bookPrice" /> </strong></span></li>

					</s:else>
					<form id="addG" action="shoppingCartAction" method="get">
					
						<li class="goods_num">
						<label>购买数量：</label>
						<span><a class="good_num_jian" id="good_num_jian" href="javascript:void(0);"></a>
						<input name="num" type="text" value="1" id="good_nums" class="good_nums" />
						<a href="javascript:void(0);" id="good_num_jia" class="good_num_jia"></a></span>
						</li>
					 	<input name="bookId" value="<s:property value="#request.singleBook.bookId"/>" style="display: none;"/>
						<li style="padding:20px 0;"><label>&nbsp;</label> 
						<span>
							<a href='#'
							class="goods_sub goods_sub_gou" onclick="addGoods()">加入购物车</a>
							<script type="text/javascript">
								function addGoods(){
									var bookAmont=document.getElementById("bookAmont").innerHTML;
									var bookOrderNum=document.getElementById("good_nums").value;
									
									if(bookAmont<bookOrderNum){
										alert("购买数量大于库存");
									}
									else{
										$("#addG").submit();
										alert("成功加入购物车");
									}
									
									/* window.location.href="allBook.jsp";  */
									
								}
									
							</script>
						</span>
						</li>
					</form>
				</ul>
			</div>
		</div>
		<!-- 商品展示 End -->

		<div class="clear mt15"></div>
		<!-- Goods Left -->
		<div class="shop_bd_list_left clearfix">



			<div class="clear"></div>

		</div>
		<!-- Goods Left End -->


	</div>
	<!-- Goods Body End -->

	<!-- Footer - wll - 2013/3/24 -->
	<div class="clear"></div>
	<div class="shop_footer">
		<div class="shop_footer_link">
			<p>
				<a href="">首页</a>| <a href="">招聘英才</a>| <a href="">广告合作</a>| <a href="">关于我们</a>
			</p>
		</div>
		<div class="shop_footer_copy">
			<p>Copyright 2017-2020 itcast Inc.,All rights reserved.</p>
		</div>
	</div>
	<!-- Footer End -->




</body>
</html>