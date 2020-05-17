<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <title>一列宽度</title>
        <meta charset="utf-8" />
        <style type="text/css">
            .active{background-color:#ed0505;}
        </style>
    </head>
    <body>
        <div class="nav">
        <ul>
            <li class="active"><a href="#">aaa</a></li>
            <li><a href="#">bbb</a></li>
            <li><a href="#">ccc</a></li>
        </ul>
        
    </div>
        <script type="text/javascript" src="js/jquery.js"></script>
		<SCRIPT type="text/javascript">
		$(".nav li a").each(function (i) {
	        var $me = $(this);

	        var lochref = $.trim(window.location.href);
	        var mehref = $.trim($me.get(0).href);



	        if (lochref.indexOf(mehref) != -1) {
	            $me.parent().addClass("active");
	        } else {
	            $me.parent().removeClass("active");
	        }

	    });
		</SCRIPT>
    </body>
</html>