<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="id" class="javaBeans.test.BeansTest"/>
<%-- <%

	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String age=request.getParameter("age");
	
	
%>

<jsp:setProperty property="name" name="id" value="<%=name %>"/>
<jsp:setProperty property="phone" name="id" value="<%=phone %>"/>
<jsp:setProperty property="age" name="id" value="<%=age %>"/> --%>

<jsp:setProperty property="*" name="id"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
���� : <jsp:getProperty name="id" property="name"/><br/>
��ȭ : <jsp:getProperty name="id" property="phone"/><br/>
���� : <jsp:getProperty name="id" property="age"/><br/>
</body>
</html>