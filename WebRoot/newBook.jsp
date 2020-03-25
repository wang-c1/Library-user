<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>最新上架</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css"></link>
	
</head>
<body>
 <jsp:include page="top.jsp"></jsp:include>

    	<s:action name="latestBookAction" executeResult="false"></s:action>
    	<div id="allBook">
    		<ul class="allBookUl">
    			<!-- <li class="allBookHead">
    				最新上架<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=latest">更多..</a>
    			</li> -->
				<s:iterator value="#request.latestBook" status="st">
					<li class="allBookPicture">
						<a href="goods2.jsp?bookId=<s:property value="bookId" />"><img src='upload/<s:property value="bookPicture" />' width="90px" height="104px"/></a>
					</li>
					<li class="allBookInfor">
						<a class="bookName" href="goods2.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName" /></a><br/><br/>
						作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
						出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
						类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="type.typeId"/>"><s:property value="type.typeName"/></a><br/><br/>
					</li>
				</s:iterator>
    		</ul>
    		
    	</div>
 
	<jsp:include page="bottom.html"></jsp:include> 
</body>
</html>
