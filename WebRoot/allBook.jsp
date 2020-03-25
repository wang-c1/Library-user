<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>销量排行</title>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<s:action name="popularBookAction" executeResult="false"></s:action>
	<div id="allBook">
		<ul class="allBookUl">
			<s:iterator value="#request.bestSellingBook">
				<li class="allBookPicture"><a
					href="goods2.jsp?bookId=<s:property value="bookId" />"><img
						src='upload/<s:property value="bookPicture" />' /></a></li>
				<li class="allBookInfor">
					<a class="bookName" href="goods2.jsp?bookId=<s:property value="bookId" />">
					<!-- 这里改过，解决了主界面点击书名没有跳转到书的问题 -->
					<s:property value="bookName" />
					</a><br />
				<br /> 作者：<a class="aboutBook"
					href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property
							value="bookAuthor" /></a><br />
				<br /> 出版社：<a class="aboutBook"
					href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property
							value="bookPress" /></a><br />
				<%-- <br /> 类别：<a class="aboutBook"
					href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="type.typeId"/>"><s:property
							value="type.typeName" /></a><br /> --%>
				<br /> 销售量：<s:property value="bookSales" /></li>
			</s:iterator>
		</ul>
	</div>
	<jsp:include page="bottom.html"></jsp:include>
</body>
</html>