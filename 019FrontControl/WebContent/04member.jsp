
<%@page import="com.ushrd.MemberDTO"%>
<%@page import="com.ushrd.MemberDAO2"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDAO2 memberDAO2 = new MemberDAO2();
	ArrayList<MemberDTO> dtos=memberDAO2.memberSelect();
	
	for(int i =0 ; i<dtos.size();i++){
		MemberDTO dto=dtos.get(i);
		String name=dto.getName();
		String id=dto.getId();
		String pw=dto.getPw();
 		String rDate=dto.getrDate(); 
		String address=dto.getAddress();
		
		out.println("이름 : "+name+"아이디 :"+id+"비밀번호 :"+pw+ "날짜 :"+rDate+ "주소 :"+address+"<br>");
		
	}
%>
</body>
</html>