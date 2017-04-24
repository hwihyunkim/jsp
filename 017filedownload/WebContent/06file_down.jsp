<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String fileName=request.getParameter("file_name");
	String savePath="/fileFolder";
	ServletContext context=getServletContext();
	String sDownloadPath=context.getRealPath(savePath);
	String sFilePath=sDownloadPath+"\\"+fileName;
	
	byte b[]=new byte[4096];
	//File oFile=new File(sFilePath);
	
	FileInputStream in = new FileInputStream(sFilePath);
	
	String sMimeType=getServletContext().getMimeType(sFilePath);
	System.out.println("sMimeType>>>>"+sMimeType);
	if(sMimeType==null)sMimeType="application/octet-stream";
	//octet-stream은 8비트로 된 일련의 데이터를 뜻합니다.
	//지정되지 않은 파일 형식을 의미합니다.
	response.setContentType(sMimeType);
	
	//한글명 파일명이 깨지는 것을 방지해준다.
	String sEncoding=new String(fileName.getBytes("UTF-8"),"8859_1");
	
	//이 부분이 모든 파일 링크를 클릭했을때 다운로드 화면이 출려되게 처리하는 부분입니다.
	//String sEncoding=fileName;
	response.setHeader("Content-Disposition", "attachment; filename="+sEncoding);
	
	/*
	JSP 를 Servlet 으로 변하는 과정에 생기는 OutputStream 때문인데,
	다음을 통해 JSP 자체의 OutputStream 을 제거할 필요가 있다. 반드시 getOutputStream() 앞에 위치시킨다.
	*/

	
	out.clear();
	out=pageContext.pushBody();
	
	ServletOutputStream out2=response.getOutputStream();
	int numRead;
	
	//바이트 배열의 b의 0번 부터 numRead번 까지 브라우저로 출력
	while((numRead=in.read(b,0,b.length))!=-1){
		out2.write(b,0,numRead);
	}
	out2.flush();
	out2.close();
	in.cloase();
	
	
	
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