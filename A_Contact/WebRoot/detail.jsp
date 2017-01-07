<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'detail.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
  </head>
  
  <body>
  	<table border="1" align="center" cellspacing="0" cellpadding="5">
  		<tr>
  			<td>姓名：${contact.name}<br/></td>
  		</tr>
  		<tr>
  			<td>照片：<img src="photo?id=${contact.id}"/></td>
  		</tr>
  	</table>
  </body>
</html>
