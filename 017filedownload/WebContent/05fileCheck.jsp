<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String subject=request.getParameter("subject");
	String filename1=request.getParameter("filename1");
	String filename2=request.getParameter("filename2");
	String origFilename1=request.getParameter("origFilename1");
	String origFilename2=request.getParameter("origFilename2");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
�ø� ��� : <%=name %><br>
���� : <%=subject %><br>
�ٸ� ������ ���� <br>
���ϸ� 1 : <a href="06file_down.jsp?file_name=<%=filename1 %>"><%=origFilename1 %></a>
���ϸ� 2 : <a href="06file_down.jsp?file_name=<%=filename2 %>"><%=origFilename2 %></a>
������� ó��<br>
���ϸ� 1 : <a href="fileFolder/<%=filename1 %>"><%=origFilename1 %></a>
���ϸ� 1 : <a href="fileFolder/<%=filename2 %>"><%=origFilename2 %></a>



</body>
</html>