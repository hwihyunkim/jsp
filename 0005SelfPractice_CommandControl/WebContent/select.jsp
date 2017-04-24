<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.ushrd.dto.MemberDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
메뉴<br>
<a href="insert.do">insert</a><br>
<a href="select.do">select</a><br>
<a href="update.do">update</a><br>
<a href="delete.do">delete</a><br>
<hr>
select 페이지입니다.
<table border="1" >
<tr><td> 이 름 </td><td>아 이 디</td><td>패스워드</td><td>전화번호</td></tr>
<%
	ArrayList<MemberDTO> list=
		(ArrayList<MemberDTO>)request.getAttribute("list");
	for(int i=0;i<list.size();i++){
		
%>
		<tr>
		<td><%=list.get(i).getName() %></td>
		<td><%=list.get(i).getId() %></td>
		<td><%=list.get(i).getPw() %></td>
		<td><%=list.get(i).getPhone() %></td>
		</tr>
<%
	}
%>
</table>
<form action="selectCommend.do">
	<input type="submit" value="목록보기(select)">
</form>
</body>
</html>