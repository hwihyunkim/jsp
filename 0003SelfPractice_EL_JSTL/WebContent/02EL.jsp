<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
(고전적인방식)<br>
설명 : <%=request.getParameter("name") %><br>
숫자1 :<%=request.getParameter("num1") %> <br>
숫자2 : <%=request.getParameter("num2") %><br>
(EL방식)<br>
설명 : ${param.name }<br>
숫자1 :${param.num1} <br>
숫자2 :${param.num2 } <br>

(고전방식)<br>
<%=request.getParameter("name").equals("park") %><br>
EL ==연산자 사용 결과 : ${param.name=="park" }<br>

null를 넣었을때<br>
request null : <%=request.getParameter("id") %><br>
EL null : ${param.id }<br>

넘어온값 연산<br>
고전<br>
<%
int num1=Integer.parseInt(request.getParameter("num1")); 
int num2=Integer.parseInt(request.getParameter("num2")); 
%>
<%=num1 %>+<%=num2 %>=<%=num1 + num2 %> <br>
el 사용한 방법<br>
${param.num1 }+${param.num2 }=${param.num1+parma.num2 }<br>


EL에서 scope별 접근방법
<%
pageContext.setAttribute("name","page Name");
request.setAttribute("name","page Name");
session.setAttribute("name","page Name");
application.setAttribute("name","page Name");
%>
name : ${name }<hr>
 page 속성: ${pageScope.name }<hr>
 request 속성 : ${requestScope.name }<hr>
 session 속성 : ${sessionScope.name }<hr>
 application 속성 : ${applicationScope.name }<hr>
 
 context  초기화 파라미터 <br>
 ${initParam.con_name }<br>
 ${initParam.con_pw }<br>
 
 
 <jsp:useBean id="member" class="com.ushrd.MemberInfo"></jsp:useBean>
 <jsp:setProperty name="member" property="name" value="홍길동"/>
 <jsp:setProperty name ="member" property="id" value="abc"/>
 <jsp:setProperty name = "member" property="pw" value="123"/>
 
 고전 <hr>
 이름:<jsp:getProperty name="member" property="name"/><br>
 아이디:<jsp:getProperty name="member" property="id"/><br>
 비밀번호:<jsp:getProperty name="member" property="pw"/><br>
 <hr>
 EL <hr>
 이름:${member.name }<br>
 아이디:${member.id }<br>
 비밀번호:${member.pw }<br>


<form action="03EL.jsp">
	아이디 : <input type="text" name="id"><br/>
	다음중 회원님이 키우고 있는 애완동물을 선택하십시오 <br/>
	개<input type="checkbox" name="animal" value="개">
	고양이<input type="checkbox" name="animal" value="고양이">
	 금붕어<input type="checkbox" name="animal" value="금붕어">
	 <input type="submit" value="전송">
</form>




</body>
</html>