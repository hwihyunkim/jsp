<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>인클루드 Test 시작</h2>
<jsp:include page="05includeTest.jsp">
	<jsp:param name="name" value="park"/>
</jsp:include>
<!-- jsp:include page="05includeTest.jsp?name=sumin"/>
 -->
<h2>인클루드 Test 종료</h2>
</body>
</html>