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
<h1>Web-INF/views/member/updateForm.jsp</h1>
<h1>회원수정</h1>
<form action='<c:url value="/member/update"/>' method="post">
아이디:<input type="text" name="id" value="${mb.id }" readonly><br>
비밀번호:<input type="password" name="pass"><br>
이름:<input type="text" name="name" value="${mb.name }"><br>
<input type="submit" value="회원수정">
</form>
</body>
</html>