<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>编辑收货地址</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
	<link rel="stylesheet" href="css/shop_common.css" type="text/css" />
	<link rel="stylesheet" href="css/shop_header.css" type="text/css" />
	<link rel="stylesheet" href="css/shop_manager.css" type="text/css" />
	<link rel="stylesheet" href="css/shop_form.css" type="text/css" />
	<!-- <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" /> -->
    <script type="text/javascript" src="js/jquery.js" ></script>
    <script type="text/javascript" src="js/topNav.js" ></script>
<style type="text/css">
	.information {
    display:inline-block;
    width:210px;
    height:18px;
    padding:4px;
    margin-bottom:9px;
    font-size:13px;
    line-height:18px;
    color:#555555;
    border:1px solid #cccccc;
    -webkit-border-radius:3px;
    -moz-border-radius:3px;
    border-radius:3px;
}
.lefts{
	margin-left: 26px;
	}
.submit-btn {
    width: 8em;
    height: 3em;
    background-color: #cccccc;
    border-radius: 4px;
    border: 0px;
    color: #fff;
    font-family: "微软雅黑";
    font-size: 1em;
    font-weight: bold;
}
</style>
</head>
<body>
	
<jsp:include page="top2.jsp"></jsp:include>

	<%request.setCharacterEncoding("UTF-8"); %>
	
	<div class="clear"></div>
	<!-- 面包屑 注意首页没有 -->
	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong>
		<span>
			<a href="">首页</a>&nbsp;›&nbsp;
			<a href="">我的商城</a>&nbsp;›&nbsp;
			<a href="">个人主页</a>
		</span>
	</div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

	<!-- Header End -->	

	<!-- 我的个人中心 -->
	<div class="shop_member_bd clearfix">
		<!-- 左边导航 -->
		<div class="shop_member_bd_left clearfix">
			
			<div class="shop_member_bd_left_pic">
				<a href="javascript:void(0);"><img src="images/avatar.png" /></a>
			</div>
			<div class="clear"></div>

			<dl>
				<dt>我的交易</dt>
				<dd><span><a href="allOrders.jsp">已购买商品</a></span></dd>
				<!-- <dd><span><a href="">我的收藏</a></span></dd> -->
				<!-- <dd><span><a href="">评价管理</a></span></dd> -->
			</dl>

			<dl>
				<dt>我的账户</dt>
				<dd><span><a href="address_edit1.jsp">个人资料</a></span></dd>
				<dd><span><a href="changePassword.jsp">密码修改</a></span></dd>
				<!-- <dd><span><a href="">收货地址</a></span></dd> -->
			</dl>

		</div>
		<!-- 左边导航 End -->
		
		<!-- 右边购物列表 -->
		<div class="shop_member_bd_right clearfix">
			
			<div class="shop_meber_bd_good_lists clearfix">
				<div class="title"><h3 style="color:#66cc33;font-size:15px;">编辑收货地址</h3></div>
				<div class="clear"></div>
				<dic class="shop_home_form">
					<form action="addressAction" method="get">
						<ul>
						</br>
						</br>
							<li class="lefts"><label>收货人姓名：</label><input class="information" style="margin-left:10px" type="text" name="receiverName" id="receiverName" placeholder="姓名" /></li>
							<li class="lefts"><label>省份：</label><input class="information" style="margin-left:45px" type="text" name="province" id="province" placeholder="省份" /></li>
						    <li class="lefts"><label>城市：</label><input class="information" style="margin-left:45px" type="text" name="city" id="city" placeholder="城市" /></li>
							<li class="lefts"><label>详细地址：</label><input class="information" style="margin-left:21px" type="text" name="detailedAddress" id="detailedAddress" placeholder="详细地址" /></li>
							<li class="lefts"><label>手机号：</label><input class="information" style="margin-left:32px" type="text" name="receiverPhone" id="receiverPhone" placeholder="手机号" /></li>
							</br>
							<li class="bn lefts"><label>&nbsp;</label>
							<input class="submit-btn" style="margin-left:15px" type="submit" value="保存修改" /></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
		<!-- 右边购物列表 End -->

	</div>
	<!-- 我的个人中心 End -->

	<!-- Footer - wll - 2013/3/24 -->
	<div class="clear"></div>
	<div class="shop_footer">
            <div class="shop_footer_link">
                <p>
                    <a href="">首页</a>|
                    <a href="">招聘英才</a>|
                    <a href="">广告合作</a>|
                    <a href="">关于我们</a>
                </p>
            </div>
            <div class="shop_footer_copy">
               <p>Copyright 2017-2020 itcast Inc.,All rights reserved.</p>
            </div>
        </div>
	<!-- Footer End -->
</body>
</html>