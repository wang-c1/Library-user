<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<title>查询图书</title>
  </head>
  
  <body>
    
    	<jsp:include page="top.jsp"></jsp:include>
	
			<div id="oneType" style="width: 100%;background-color: white;margin-top: 20px;margin-left:300px;">
			
			<s:action name="oneTypeAction" executeResult="false"></s:action>
	    		<ul class="allBookUl" style="width: 700px;float: left;">

	    			<%-- <li class="allBookHead" style="width: 100%;background-color: yellow;color: black;">
	    				<s:property value="#request.typeDescribe"/>
	    			</li> --%>
					<s:iterator value="#request.bookList" status="st">
						<li class="allBookPicture">
							<a href="goods2.jsp?bookId=<s:property value="bookId" />"><img src='upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="allBookInfor" style="width: 200px;">
							<a class="bookName" href="goods2.jsp?bookId=<s:property value="bookId" />">
							
							<s:property value="bookName" />
							</a><br />
						<br />作者：<a class="aboutBook" 
							href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property 
									value="bookAuthor" /></a><br />
						<br />出版社：<a class="aboutBook" 
							href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property 
									value="bookPress" /></a><br />
						<br />类别：<a class="aboutBook" 
							href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="type.typeId"/>"><s:property 
									value="type.typeName" /></a><br />
									<br/>
						</li>
					</s:iterator>
	    		</ul>
	    	</div>
																						
		<jsp:include page="bottom.html"></jsp:include>
    
  </body>
