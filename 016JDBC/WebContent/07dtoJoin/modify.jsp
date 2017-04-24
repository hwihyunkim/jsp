<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ushrd.dto.*" %>    
<% request.setCharacterEncoding("utf-8"); %>
<%
	String id=(String)session.getAttribute("id");
	MemberDao dao=MemberDao.getInstance();
	MemberDto dto=dao.getMember(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="members.js"></script>
</head>
<body>
	<form action="modifyOk.jsp" method="post" name="reg_form">
		아이디 : <%= dto.getId() %><br>
		비밀번호 : <input type="password" name="pw" size="20"><br>
		비밀번호확인 : <input type="password" name="pw_check" size="20"><br>
		이름 : <%= dto.getName() %><br>
		이메일 : <input type="text" name="mail" size="20" value="<%=dto.getMail() %>"/><br>
		주소 : <input type="text" name="address" size="20" value="<%=dto.getAddress() %>"/><br>
		
		<input type="button" value="회원수정" onclick="updateInfoConfirm()">&nbsp;&nbsp;
		<input type="button" value="취소" onclick="javascript:window.location='main.jsp'"/>		
	
	</form>
	안녕

</body>
</html>