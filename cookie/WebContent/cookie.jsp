<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!String id, pw; %>

<%
	id=request.getParameter("id");
	pw=request.getParameter("pw");
	
	Cookie cookie=new Cookie("id",id);
	cookie.setMaxAge(60*30);
	response.addCookie(cookie);
%>
쿠키가 설정되었습니다.
<a href="cookieTest.jsp">확인</a>


</body>
</html>