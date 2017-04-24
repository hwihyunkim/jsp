<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String name, id, pw, phone1, phone2, phone3, gender;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	id=(String)session.getAttribute("id");
	String query="select * from memberA where id='"
			+id+"'";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	connection=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","us","us");
	statement=connection.createStatement();
	resultSet=statement.executeQuery(query);
	
	while(resultSet.next()){
		name=resultSet.getString("name");
		pw=resultSet.getString("name");
		phone1=resultSet.getString("phone1");
		phone2=resultSet.getString("phone2");
		phone3=resultSet.getString("phone3");
		gender=resultSet.getString("gender");
	}
%>

<form action="../ModifyOk" method="post">
	이름 : <input type="text" name="name" vlaue=<%=name %>><br/>
	아이디 : <input type="text" name="id" value=<%=id %>><br/>
	비밀번호 : <input type="password" name="pw" value=<%=pw %>><br/>
	전화번호 : <select name="phone1" >
				<option value="010"  selected>010</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="019">019</option>
			</select>-
			<input type="text" name="phone2" value=<%=phone2 %> size="5">-
			<input type="text" name="phone3" value=<%=phone3 %> size="5"><br/>
    <%if(gender.equals("man")){
    %>
    성별구분 : <input type="radio" name="gender" value="man" checked>남 &nbsp;&nbsp;
    			<input type="radio" name="gender" value="woman">여 <br>
   
    <%}else{ %>
    성별구분 : <input type="radio" name="gender" value="man">남 &nbsp;&nbsp;
    			<input type="radio" name="gender" value="woman"  checked>여 <br>
   
    <%}%>
    
    			
    	<input type="submit" value="회원수정"><input type="reset" value="취소"/>		
			
			
</form>
	
</form>

</body>
</html>