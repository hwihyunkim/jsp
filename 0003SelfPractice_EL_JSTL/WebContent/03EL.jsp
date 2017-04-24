<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
아이디 : ${param.id }  : ${param["id"] }<br>
<%-- 선택한 갯수: ${paramValues.animal.length}<br> 안돼나요--%> 
선택한 동물 : ${paramValues.animal[0]}<br>
선택한 동물 : ${paramValues.animal[1]}<br>
선택한 동물 : ${paramValues.animal[2]}<br>

선택한 동물 : ${paramValues['animal'][0]}<br>
선택한 동물 : ${paramValues['animal'][1]}<br>
선택한 동물 : ${paramValues['animal'][2]}<br>

해더 : <br>
${header['User-Agent'] }<br>
${header['host'] }<br>
<br>
</body>
</html>