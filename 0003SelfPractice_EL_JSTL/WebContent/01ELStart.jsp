<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 표현어 (Expression Language) 값을 쉽게 가져오기 위해서 -->
${"Hello"}<br>
<%="hello" %><br><!-- 표현식 -->
<%out.println("hello"); %><!-- 스크립트릿 -->
<br>
<!-- el로 표시할수 있는 자료형 -->
정수형 : ${10 }<br>
실수형 : ${20.3 }<br>
문자열형 : ${"park" }<br>
논리형 : ${true }<br>
null : ${null }<br>
<br>
<!-- EL 연산  -->
\${5+2 } : ${5+2 } <br>
\${5/2 } : ${5/2 } <br>
<%-- \${5 div 2} : ${5 div 2}<br> --%>
\${5 mod 2 } : ${m mod 2} %<br>
\${5>2 } : ${5>2}<br>
\${2 gt 10 } : ${2 gt 10}<br>
\${5>2?5:2 } : ${5>2?5:2}<br>
\${(5>2)||(2<10)} : ${(5>2)||(2<10)}<br>
<%
String input=null;
%>
\${empty input} : ${empty input}<br>
<br>

<!-- EL getParameter 처리방법 -->
<form method="get" action="02EL.jsp">
	설명 : <input type="text" name="name"><br>
	숫자1 : <input type="text" name="num1"><br>
	숫자2 : <input type="text" name="num2"><br>
	<input type="submit" value="로그인">
</form>












</body>
</html>