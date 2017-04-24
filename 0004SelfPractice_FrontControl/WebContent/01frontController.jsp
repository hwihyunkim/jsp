<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8081/019FrontContol/01frontController.jsp -->

	<a href="insert.do">insert</a>
	<a href="http://localhost:8082<%=request.getContextPath()%>/update.do">update</a>
	<a href="http://localhost:8082/0004SelfPractice_FrontControl/select.do">select</a>
	<a href="<%=request.getContextPath()%>/delete.do">delete</a>
</body>
</html>