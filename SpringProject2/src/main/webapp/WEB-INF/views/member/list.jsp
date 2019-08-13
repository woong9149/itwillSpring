<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Web-INF/views/member/list.jsp</h1>
<h1>회원목록</h1><a href='<c:url value="/member/main"/>'>main.jsp 이동</a>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
<c:forEach var="mb" items="${memberList }">
<tr><td>${mb.id }</td><td>${mb.pass }</td>
    <td>${mb.name }</td><td>${mb.reg_date }</td></tr>
</c:forEach>
</table>
</body>
</html>




