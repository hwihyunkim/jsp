<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String uploadPath=request.getRealPath("/fileFolder");
	System.out.println(uploadPath);
	
	int size=1024*1024*10;
	String name="";
	String subject="";
	String filename1="";
	String filename2="";
	String origFilename1="";
	String origFilename2="";
	
	try{
		MultipartRequest multi=new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		name=multi.getParameter("name");
		subject=multi.getParameter("subject");
		
		Enumeration files=multi.getFileNames();
		
		String file1=(String)files.nextElement();
		filename1=multi.getFilesystemName(file1);
		origFilename1=multi.getOriginalFileName(file1);
		
		String file2=(String)files.nextElement();
		filename2=multi.getFilesystemName(file2);
		origFilename2=multi.getOriginalFileName(file2);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="filecheck" action="05fileCheck.jsp" method="post">
	<input type="hidden" name="name" value="<%=name %>">
	<input type="hidden" name="subject" value="<%=subject %>">
	<input type="hidden" name="filename1" value="<%=filename1 %>">
	<input type="hidden" name="filename2" value="<%=filename2 %>">
	<input type="hidden" name="origFilename1" value="<%=origFilename1 %>">
	<input type="hidden" name="origFilename2" value="<%=origFilename2 %>">
</form>
<a href="#" onclick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>

</body>
</html>