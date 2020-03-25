<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>我的订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
<body>
	
    	<jsp:include page="top.jsp"></jsp:include>	
		
			<div id="shoppingBook" style="padding-top: 20px;padding-left: 8px;">
			<s:action name="singleOrdersAction" executeResult="false"></s:action>
				<ul class="shoppingBookUl">
					<li class="shoppingBookHead" style="color: white;">
						&nbsp;&nbsp;&nbsp;&nbsp;
						收件人信息：
						&nbsp;&nbsp;&nbsp;&nbsp;
					</li>
				</ul>
				<ul class="shoppingBookUl" style="margin-top: 10px;margin-bottom: 10px;">
				<li>
					收件人姓名：<s:property value="#request.address.receiverName"/> 
				</li>
				<li>
					收件人电话：<s:property value="#request.address.receiverPhone"/> 
				</li>
				<li>
					收件人地址：<s:property value="#request.address.province"/>
							 <s:property value="#request.address.city"/>
							 <s:property value="#request.address.detailedAddress"/>
				</li>
				</ul>
				
				<ul class="shoppingBookUl">
					<li class="shoppingBookHead" style="color: white;">
						<s:property value="#request.orders.ordersNumber"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						总计金额：<s:property value="#request.orders.totalMoney"/> 元
						&nbsp;&nbsp;&nbsp;&nbsp;
						状态：
						<s:if test='#request.orders.orderStatus ==0'>未处理</s:if>
						<s:else>已处理</s:else>
						&nbsp;&nbsp;&nbsp;&nbsp;
						日期：<s:date name="#request.orders.orderTime" format="yyyy-MM-dd HH:mm:ss"/>
					</li>
				</ul>
				<ul class="shoppingBookUl" style="background-color:#FFFFCC;">
					<!-- <li class="sequence">序列</li> -->
					<li class="bookName">图书名称</li>
					<li class="bookPrice">图书价格</li>
					<li class="bookAmount2">购买数量</li>
					<li class="bookPress">出版社</li> 
				</ul>
				<s:iterator value="#request.bookList" status="st">
					<ul class="shoppingBookUl">
						<%-- <li class="sequence">
							<s:property value="#st.getIndex()+1"/>
						</li> --%>
						<li class="bookName"><a class="bookName" href="goods2.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName"/></a></li>
						<li class="bookPrice"><s:property value="bookPrice"/> 元</li>
						<li class="bookAmount2">
							<s:property value="bookAmount"/>
						</li>
						<li class="bookPress">
							<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a>
						</li>
					</ul>
				</s:iterator>
			</div>
		<jsp:include page="bottom.html"></jsp:include>
	
</body>
</html>
