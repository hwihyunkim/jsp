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
insert 페이지입니다.
<form action="insertCommend.do">
	이 름 :<input type="text" name="name"><br>
	아 이 디 :<input type="text" name="id"><br>
	패 스 워 드 :<input type="text" name="pw"><br>
	전 화 번 호 :<input type="text" name="phone"><br>
	<input type="submit" value="입력">
</form>
</body>
</html>