<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String path=request.getRealPath("fileFolder");
	System.out.println(path);
	
	int size=1024*1024*10;   //10M
	String file="";
	String oriFile="";
	
	try{
		MultipartRequest multi=new MultipartRequest(
				request, path, size, "utf-8", new DefaultFileRenamePolicy());
		Enumeration files=multi.getFileNames();
		String str=(String)files.nextElement();
		
		file=multi.getFilesystemName(str);
		oriFile=multi.getOriginalFileName(str);
		
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

</body>
</html>