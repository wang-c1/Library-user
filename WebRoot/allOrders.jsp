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
	<style type="text/css">
		.button{
			background-color: transparent;
			border-style: none;
			color: #FF6600;
			cursor:pointer;
		}
	</style>
  </head>
  
<body>
	
		<jsp:include page="top.jsp"></jsp:include>
	<!-- 	<div id="orders"> -->
			
			<div id="ordersInfor"  style="padding-top: 20px;padding-left: 8px;">
				<ul class="singleOrders">
					<li style="width: 700px;padding-top: 10px;padding-left: 10px;text-align: left;background-color: #66cc33">
						<a class="aboutOrders" href="allOrders.jsp?searchType=all">所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="aboutOrders" 
						href="allOrders.jsp?searchType=isDeal">已处理订单</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="aboutOrders" href="allOrders.jsp?searchType=isNotDeal">未处理订单</a>
					</li>
				</ul>
				<ul class="singleOrders" style="background-color: #FFFFCC;">
					<!-- <li class="sequence">序列</li>	 -->		
					<li class="ordersNumber">订单编号</li>			
					<li class="ordersTime">订单日期</li>			
					<li class="isDeal">处理状态</li>			
					<!-- <li class="deleteOrders" style="padding-top: 5px;">删除订单</li> -->
				</ul>
				<s:action name="ordersAction" executeResult="false"></s:action>
				<s:iterator value="#request.allOrdersByUser" status="st">
					<ul class="singleOrders">
						<%--  <li class="sequence"><s:property value="#st.getIndex()+#request.sequence+1"/></li>	 --%>
						<li class="ordersNumber">
							<a class="aboutBook" href="singleOrders.jsp?ordersId=<s:property value="orderId"/>"><s:property value="orderNumber"/></a>
						</li>			
						<li class="ordersTime"><s:date name="orderTime" format="yyyy-MM-dd HH:mm:ss"/></li>			
						<li class="isDeal">
							<s:if test='%{orderStatus =="0"}'>
								<font style="color: blue;">未处理</font>
							</s:if>
							<s:elseif test='%{orderStatus=="-1"}'>
							<font style="color: red;">订单被取消，请与店家联系</font>
							</s:elseif>
							<s:else>
								<font style="color: green;">已处理</font>
							</s:else>
						</li>
						<%-- <li class="deleteOrders">
							<input type="button" value="删除" onclick="deleteOrders('<s:property value="orderId"/>')" class="button"/>
						</li>	 --%>
					</ul>
				</s:iterator>
			</div>
	<!-- 	</div> -->
		<jsp:include page="bottom.html"></jsp:include>
	 
</body>
<SCRIPT type="text/javascript">

	function deleteOrders(ordersId){
		if(confirm("确定要订单吗？")){
			window.location.href="com.javaeetest.action/orderAction?updateType=delete&ordersId="+ordersId;
		}
	}

</SCRIPT>
</html>
