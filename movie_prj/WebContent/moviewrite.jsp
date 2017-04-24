<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
moviewrite page
<form action="../MovieInsert" method="post">
<table border='1'>
	<tr>
		<td>제 목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>가 격</td>
		<td><input type="text" name="price"></td>
	</tr>
	<tr>
		<td>감 독</td>
		<td><input type="text" name="director"></td>
	</tr>
	<tr>
		<td>배 우</td>
		<td><input type="text" name="actor"></td>
	</tr>
	<tr>
		<td>설 명</td>
		<td><input type="text" name="synopsis"></td>
	</tr>
	<tr>
		<td>사 진</td>
		<td><input type="file" name="poster"></td>
	</tr>
</table>
<input type="submit" value="확인">
<input type="reset" value="취소" onclick="javascript:window.location='movielist.jsp'"/>
<input type="reset" value="목록" onclick="javascript:window.location='movielist.jsp'"/>


</form>
</body>
</html>