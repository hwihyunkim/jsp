<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object obj1=session.getAttribute("mySession");
	String mySession=(String)obj1;
	out.println(mySession+"<br>");
	
	Object obj2=session.getAttribute("myNum");
	Integer myNum=(Integer)obj2;
	out.println(myNum+"<br>");
	out.println("#################"+"<br>");
	
	String sName;
	String sValue;
	Enumeration enumeration=session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		sName=enumeration.nextElement().toString();
		sValue=session.getAttribute(sName).toString();
		out.println(sName+":"+sValue+"<br>");
	}
	
	out.println("#############################"+"<br>");
	String sessionID=session.getId();
	out.println("sessionID: "+sessionID+"<br>");
	int sessionInter=session.getMaxInactiveInterval();
	out.println("sessionInter: " +sessionInter+"<br>");
	out.println("##############################"+"<br>");
	
	session.removeAttribute("mySessionName");
	enumeration=session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		sName=enumeration.nextElement().toString();
		sValue=session.getAttribute(sName).toString();
		out.println(sName+":"+sValue+"<br>");
		
	}
	out.println("##################"+"<br>");
	
	session.invalidate();
	if(request.isRequestedSessionIdValid()){
		out.println("session valid");
	}else{
		out.println("session invalid");
	}
	
	
%>

<a href="10sessiontest.jsp">sessionTest</a>
		


</body>
</html>