<%@page import="com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserDataBean" %>	<%-- src에 있는 자바파일 임포트하는 방법 --%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.ServletRequest" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<h1>회원가입 결과</h1>
	<%
		// Attribute로 넘겨받은 값 유저데이터빈 자료형으로 바꿔줌
		ArrayList<UserDataBean> users = (ArrayList<UserDataBean>)request.getAttribute("users");	
		
		for (int i=0; i<users.size(); i++) {
	%>
			<hr>
			<p>Firstname : <%=users.get(i).getFirstname() %> <br>
			<p>Lastname : <%=users.get(i).getLastname() %> <br>
			<p>Email : <%=users.get(i).getEmail() %> <br>
	<%
		}
	%>
	<%-- jstl 사용하면 이렇게 간단하다 
	<c:forEach items="${users}" var="UserDataBean">
		<hr>
		First name : ${UserDataBean.firstname}<br>
		Last name : ${UserDataBean.lastname}<br>
		Email name : ${UserDataBean.email}<br>
		<hr>
	</c:forEach> --%>
</body>
</html>