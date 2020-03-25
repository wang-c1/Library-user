<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>购物车页面</title>
	<link rel="stylesheet" href="css1/base.css" type="text/css" />
	<link rel="stylesheet" href="css1/shop_common.css" type="text/css" />
	<link rel="stylesheet" href="css1/shop_header.css" type="text/css" />
	<link rel="stylesheet" href="css1/shop_gouwuche.css" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/topNav.js"></script>
	<script type="text/javascript" src="js/jquery.goodnums.js"></script>
	<script type="text/javascript" src="js/shop_gouwuche.js"></script>

	<style type="text/css">
.shop_bd_shdz_title {
	width: 1000px;
	margin-top: 10px;
	height: 50px;
	line-height: 50px;
	overflow: hidden;
	background-color: #F8F8F8;
}

.shop_bd_shdz_title h3 {
	width: 120px;
	text-align: center;
	height: 40px;
	line-height: 40px;
	font-size: 14px;
	font-weight: bold;
	background: #FFF;
	border: 1px solid #E8E8E8;
	border-radius: 4px 4px 0 0;
	float: left;
	position: relative;
	top: 10px;
	left: 10px;
	border-bottom: none;
}

.shop_bd_shdz_title p {
	float: right;
}

.shop_bd_shdz_title p a {
	margin: 0 8px;
	color: #555555;
}

.shop_bd_shdz_lists {
	width: 1000px;
}

.shop_bd_shdz_lists ul {
	width: 1000px;
}

.shop_bd_shdz_lists ul li {
	width: 980px;
	border-radius: 3px;
	margin: 5px 0;
	padding-left: 18px;
	line-height: 40px;
	height: 40px;
	border: 1px solid #FFE580;
	background-color: #FFF5CC;
}

.shop_bd_shdz_lists ul li label {
	color: #626A73;
	font-weight: bold;
}

.shop_bd_shdz_lists ul li label span {
	padding: 10px;
}

.shop_bd_shdz_lists ul li em {
	margin: 0 4px;
	color: #626A73;
}

.shop_bd_shdz {
	width: 1000px;
	margin: 10px auto 0;
}

.shop_bd_shdz_new {
	border: 1px solid #ccc;
	width: 998px;
}

.shop_bd_shdz_new div.title {
	width: 990px;
	padding-left: 8px;
	line-height: 35px;
	height: 35px;
	border-bottom: 1px solid #ccc;
	background-color: #F2F2F2;
	font-color: #656565;
	font-weight: bold;
	font-size: 14px;
}

.shdz_new_form {
	width: 980px;
	padding: 9px;
}

.shdz_new_form ul {
	width: 100%;
}

.shdz_new_form ul li {
	clear: both;
	width: 100%;
	padding: 5px 0;
	height: 25px;
	line-height: 25px;
}

.shdz_new_form ul li label {
	float: left;
	width: 100px;
	text-align: right;
	padding-right: 10px;
}

.shdz_new_form ul li label span {
	color: #f00;
	font-weight: bold;
	font-size: 14px;
	position: relative;
	left: -3px;
	top: 2px;
}
</style>

	<script type="text/javascript">
		jQuery(function() {
			jQuery("#new_add_shdz_btn").toggle(function() {
				jQuery("#new_add_shdz_contents").show(500);
			}, function() {
				jQuery("#new_add_shdz_contents").hide(500);
			});
		});
	</script>
</head>
<body>
 
    <jsp:include page="top2.jsp"></jsp:include>
    
	
	<!-- 面包屑 注意首页没有 -->
	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong> <span> <a href="">首页</a>&nbsp;›&nbsp; <a
			href="">我的商城</a>&nbsp;›&nbsp; <a href="shoppingCart1.jsp">我的购物车</a>
		</span>
	</div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

	<!-- Header End -->

	<!-- 购物车 Body -->
	<div class="shop_gwc_bd clearfix">
		<div class="shop_gwc_bd_contents clearfix">

			<!-- 购物流程导航 -->
			<div class="shop_gwc_bd_contents_lc clearfix">
				<ul>
					<li class="step_a">确认购物清单</li>
					<li class="step_b">确认收货人资料及送货方式</li>
					<li class="step_c">购买完成</li>
				</ul>
			</div>
			<!-- 购物流程导航 End -->
			<div class="clear"></div>
			<!-- 收货地址 title -->
			<div class="shop_bd_shdz_title">
				<h3>收货人地址</h3>
				<p>
					<a href="address_edit1.jsp">新增收货地址</a>
					<!--<a href="#">管理收货地址</a>-->
						
				</p>
			</div>
			<div class="clear"></div>
			<!-- 收货人地址 Title End -->
			
			
			<div class="shop_bd_shdz clearfix">
				<div class="shop_bd_shdz_lists clearfix">
				<s:iterator value="#session.userAddress" status="st"> .
					<ul>
						<li>
						<label>寄送至：
						<span>
							<input type="radio" name="radios" value="<s:property value="addressId" />"/>
						</span>
						</label>
						<em>
							<s:property value="receiverName" />
						</em>
						<em>
							<s:property value="receiverPhone" />
						</em>
						<em>
							<s:property value="province" />
						</em><em>
							<s:property value="city" />
						</em><em>
							<s:property value="detailedAddress" />
						</em>
						</li>
					</ul>
					</s:iterator>
				</div>
			</div>
			<div class="clear"></div>
			<!-- 购物车列表 -->
			<div class="shop_bd_shdz_title">
				<h3>确认购物清单</h3>
			</div>
			<div class="clear"></div>
			<table>
				<thead>
					<tr>
						<th colspan="2"><span>商品</span></th>
						<th><span>单价(元)</span></th>
						<th><span>数量</span></th>
						<th><span>小计</span></th>
						<th><span>操作</span></th>
					</tr>
				</thead>
				<tbody>
					<s:if test="%{#session.shoppingBook!=null}">
						<s:iterator value="#session.shoppingBook" status="st">
             
							<tr>
								<td class="gwc_list_pic"><a><img
									src='../upload/<s:property value="bookPicture"/>' /></a></td>
								<td class="gwc_list_title"><a><s:property value="bookName" /></a></td>
								<td class="gwc_list_danjia"><span>￥<strong
										id="danjia${st.getIndex()+1}">
										 <s:if test="%{bookNewPrice==0.00}">
										 <s:property value="bookPrice" />
										</s:if>
										<s:else>
										<s:property value="bookNewPrice" />
										</s:else>
										</strong></span></td>
								<td class="gwc_list_danjia"><span>
										<a><s:property value="bookSalesAmount"/> </a>
										</span></td>
								
								
								
								
								<td class="gwc_list_xiaoji"><span>￥<strong
										id="xiaoji${st.getIndex()+1}" class="good_xiaojis">
									<s:if test="%{bookNewPrice!=0f}">
										<s:property value="%{bookSalesAmount*bookNewPrice}"/>
									</s:if>
									<s:else>
										<s:property value="%{bookSalesAmount*bookPrice}"/>
									</s:else>
								<%-- 	<s:property value="#st.getIndex()+1"/> --%>
										</strong></span></td>
								<td class="gwc_list_caozuo">
								<a href="javascript:void(0);" onclick="deleteBook('<s:property value="bookId"/>')" >删除</a></td>
							</tr>

						</s:iterator>
						<tfoot>
							<tr>
								<td colspan="6">
									<div class="gwc_foot_zongjia">
										商品总价(不含运费)<span>￥<strong id="good_zongjia"> <a
												id="demo"><s:property value="#session.totalMoney"/></a></strong></span>
									</div>
									<div class="clear"></div>
									<div class="gwc_foot_links">
										<a href="" class="go">返回上一步</a> <a href="javascript:void(0)" class="op"
											onclick="addOrders();">结账</a>
									</div>
								</td>
							</tr>
						</tfoot>

					</s:if>

				</tbody>

			</table>
			<!-- 购物车列表 End -->

		</div>
	</div>
	<!-- 购物车 Body End -->

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
	<script>
	 
	
	
		
	    function deleteBook(bookId){
			if(confirm("确定要删除吗？")){
				location.href = "com.javaeetest.action/updateCartAction.action?updateType=delete&bookId="+bookId;
			}
		}

		function addOrders() {
			if (confirm("确定要购买吗？")) {
				var x=document.getElementById("demo").innerHTML;
				location.href="com.javaeetest.action/orderAction?updateType=add&totalMoney="+x+"&addressId="+$("input[name='radios']:checked").val();
			}
		}
	</script>

</body>
</html>