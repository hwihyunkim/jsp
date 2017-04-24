<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>인클루드 Test 시작</h2>
<jsp:include page="05includeTest.jsp">
<jsp:param name="name" value="park"/>
</jsp:include>
<h2>인클루드 test 종료</h2>


</body>
</html>