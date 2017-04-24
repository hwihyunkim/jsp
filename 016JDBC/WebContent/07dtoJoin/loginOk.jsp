<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ushrd.dto.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	MemberDao dao=MemberDao.getInstance();
	int checkNum=dao.userCheck(id,pw);
	if(checkNum==MemberDao.MEMBER_LOGIN_IS_NOT){
%>
<script>
	alert("아이디가 존재하지 않습니다.");
	history.go(-1);
</script>
	
	
<%}else if(checkNum==MemberDao.MEMBER_LOGIN_PW_NO_GOOD){ %>
	<script>
		alert("비밀번호가 틀립니다.");
		history.back();
	</script>
<% 
	}else if (checkNum==MemberDao.MEMBER_JOIN_SUCCESS){
		MemberDto dto=dao.getMember(id);
		
		if(dto==null){
			%>
			<script>
				alert("존재하지 않는 회원입니다.");
				history.back();
			</script>
<%
		}else{
			String name=dto.getName();
			session.setAttribute("id",id);
			session.setAttribute("naem",name);
			session.setAttribute("ValidMem","yes");
			response.sendRedirect("main.jsp");
		}
		
	}
%>


</body>
</html>