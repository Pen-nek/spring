<%@page import="model.UserDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>

	<h1>회원가입 완료</h1>
	


	<c:forEach items="${user}" var="UserDataBean">
		<hr>
		First name : ${UserDataBean.firstname}<br>
		Last name : ${UserDataBean.lastname}<br>
		Email name : ${UserDataBean.email}<br>
		<hr>
	</c:forEach>

</body>
</html>