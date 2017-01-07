<%@page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有联系人</title>
<style type="text/css">
	div{
		color:blue;
		text-align: right;
		margin: 10px 50px 10px 0;
	}
</style>
</head>
<script type="text/javascript">
	function fn() {
		return confirm("是否确认删除？");
	}
	function fn1() {
		return confirm("是否注销登陆？");
	}
</script>

<body>
<center><h2>所有联系人</h2></center>
<div>管理员:${username},您已登录&nbsp;<a href="logout" onclick="return fn1()" style="color:red">注销</a></div>
<hr />

<table border="1" align="center" width="600px">
	<tr>
    	<th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>籍贯</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${contacts}" var="contact" varStatus="row">
	    <tr>
	    	<td>${row.count}</td>
	        <td>${contact.name}</td>
	        <td>${contact.gender }</td>
	        <td>${contact.age }</td>
	        <td>${contact.jiguan }</td>
	        <td>${contact.qq }</td>
	        <td>${contact.email }</td>
	        <td><a href="query?id=${contact.id}">修改</a>&nbsp;<a href="delete?id=${contact.id}" onclick="return fn()">删除</a>&nbsp;<a href="detail?id=${contact.id}">照骗</a></td>
	    </tr>
    </c:forEach>
    <tr>
    	<td colspan="8" align="center"><a href="add.jsp">【添加联系人】</a></td> 
    </tr>
</table>

</body>
</html>
