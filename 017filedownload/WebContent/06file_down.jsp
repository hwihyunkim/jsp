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
	//octet-stream�� 8��Ʈ�� �� �Ϸ��� �����͸� ���մϴ�.
	//�������� ���� ���� ������ �ǹ��մϴ�.
	response.setContentType(sMimeType);
	
	//�ѱ۸� ���ϸ��� ������ ���� �������ش�.
	String sEncoding=new String(fileName.getBytes("UTF-8"),"8859_1");
	
	//�� �κ��� ��� ���� ��ũ�� Ŭ�������� �ٿ�ε� ȭ���� ����ǰ� ó���ϴ� �κ��Դϴ�.
	//String sEncoding=fileName;
	response.setHeader("Content-Disposition", "attachment; filename="+sEncoding);
	
	/*
	JSP �� Servlet ���� ���ϴ� ������ ����� OutputStream �����ε�,
	������ ���� JSP ��ü�� OutputStream �� ������ �ʿ䰡 �ִ�. �ݵ�� getOutputStream() �տ� ��ġ��Ų��.
	*/

	
	out.clear();
	out=pageContext.pushBody();
	
	ServletOutputStream out2=response.getOutputStream();
	int numRead;
	
	//����Ʈ �迭�� b�� 0�� ���� numRead�� ���� �������� ���
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