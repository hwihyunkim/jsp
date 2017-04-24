<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl1";
	String uid="hwi";
	String upw="hwi";
	String query="select * from movie";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center><h1>리스트</h1></center>
<a href="moviewrite.jsp">정보등록</a>

<table border='1'>
<tr>
	<td>제목</td>
	<td>감독</td>
	<td>배우</td>
	<td>가격</td>
	<td>수정</td>
	<td>삭제</td>
</tr>

<%
	try{
		Class.forName(driver);
		con=DriverManager.getConnection(url, uid, upw);
		pstmt=con.prepareStatement(query);
		res=pstmt.executeQuery();
		
		while(res.next()){
			String title = res.getString("title");
			String price = res.getString("price");
			String director = res.getString("director");
			String actor = res.getString("actor");
			
			out.println("<tr><td>"+title+"</td><td>"+director+"</td><td>"+actor+"</td><td>"+price+"</td><td>"
					+"<a href = 'movieupdate.jsp'>정보수정</a>"+"</td><td>"+"<a href = 'moviedelete.jsp'>정보 삭제</a>"+"</td></tr>");
		}
	}catch(Exception e){
		out.println(e.getMessage());
	}finally{
		try{
			if(res!=null)res.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(Exception e1){
			
		}
	}
%>

</table>
</body>
</html>