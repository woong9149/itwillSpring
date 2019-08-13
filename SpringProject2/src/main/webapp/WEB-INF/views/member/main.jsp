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
<h1>Web-INF/views/member/main.jsp</h1>
${sessionScope.id }님이 로그인하셨습니다.
<input type="button" value="로그아웃" 
   onclick="location.href='<c:url value="/member/logout"/>'">
<br>
<a href='<c:url value="/member/info"/>'>회원정보조회</a><br>
<a href='<c:url value="/member/update"/>'>회원정보수정</a><br>
<a href='<c:url value="/member/delete"/>'>회원정보삭제</a><br>
<%
// id가 있으면
// id가 "admin"이면
// if(id!=null){
// 	if(id.equals("admin")){
%><a href='<c:url value="/member/list"/>'>회원목록</a><br><%
// 	}
// }
%>
</body>
</html>





