<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>通讯录管理系统</title>   
  </head>
  
  <body style="text-align: center; margin-top: 150px">
  	<span><h1>通讯录管理系统</h1></span><br/>
  	<form action="login" method="post">
  		用户名<input type="text" name="name" />
  		密码<input type="password" name="password" />
  		<input type="submit" value="登录" /><br/>
  		${msg}
  	</form>
  </body>
</html>
