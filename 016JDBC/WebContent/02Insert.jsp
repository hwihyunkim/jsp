<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	Connection connection;
Statement statement;
String driver="oracel.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:orcl1";
String uid="scott";
String upw="scott";
String query="insert into member values('newID1','newPW1','newName1','newPhone1')";
%>

<%
	try{
		Class.forName(driver);
		connection=DriverManager.getConnection(url, uid, upw);
		statement=connection.createStatement();
		int result=statement.executeUpdate(query);
		if(result!=0){
			out.println("등록되었습니다.");
			
		}else{
			out.println("등록에 실패하였습니다.");
		}
	}catch(Exception e){
		out.println("등록 실패");
		e.printStackTrace();
	}
%>
</body>
</html>