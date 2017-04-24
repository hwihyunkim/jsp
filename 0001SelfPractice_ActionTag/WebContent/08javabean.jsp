<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="com.ushrd.Student" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty property="name" name="student" value="홍길동"/>
<jsp:setProperty property="age" name="student" value="13"/>
<jsp:setProperty property="grade" name="student" value="6"/>
<jsp:setProperty property="studentNum" name="student" value="7"/>

이름:<jsp:getProperty name="student" property="name"/><br/> 
나이:<jsp:getProperty name="student" property="age"/><br/>
학년:<jsp:getProperty name="student" property="grade"/><br/>
번호:<jsp:getProperty name="student" property="studentNum"/><br/>

</body>
</html>