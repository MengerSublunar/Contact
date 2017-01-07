<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改联系人</title>
</head>

<body>
<center><h3>修改联系人</h3></center>
<form action="update" method="post">
<table border="1" align="center" width="300px">
	<input type="hidden" name="id" value="${contact.id}"/>
	<tr>
    	<th>姓名</th>
        <td><input type="text" name="name" readonly="readonly" value="${contact.name}"/></td>
    </tr>
    <tr>
    	<th>性别</th>
        <td>
        <input type="radio" name="gender" value="男" ${contact.gender=="男"?'checked="checked"':''}/>男
        <input type="radio" name="gender" value="女" ${contact.gender=="女"?'checked="checked"':''}/>女
        </td>
    </tr>
    <tr>
    	<th>年龄</th>
        <td><input type="text" name="age" value="${contact.age}"/></td>
    </tr>
    <tr>
    	<th>籍贯</th>
        <td>
        	<select name="jiguan">
        		<c:forEach items="${jgs}" var="jg">
					<option value="${jg}" ${contact.jiguan==jg?'selected="selected"':''}>${jg}</option>
        		</c:forEach>
            </select>
        </td>
    </tr>
    <tr>
    	<th>QQ</th>
        <td><input type="text" name="qq" value="${contact.qq}"/></td>
    </tr>
    <tr>
    	<th>邮箱</th>
        <td><input type="text" name="email" value="${contact.email}"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
        <input type="submit" value="提交" />
        <input type="button" value="返回" onclick="history.back()"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>
