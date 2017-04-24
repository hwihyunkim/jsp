<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
update 페이지입니다.
<form action="updateCommend.do">
	기존 아이디 :<input type="text" name="id2"/>
	변경 아이디 :<input type="text" name="id1"/>
	
	<input type="submit" value="삭제">
</form>
</body>
</html>