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
<h1>Web-INF/views/member/info.jsp</h1>
<h1>회원정보조회</h1>
아이디:${mb.id }<br>
비밀번호:${mb.pass }<br>
이름:${mb.name }<br>
가입날짜:${mb.reg_date }<br>
<a href='<c:url value="/member/main"/>'>main.jsp 이동</a>
</body>
</html>



