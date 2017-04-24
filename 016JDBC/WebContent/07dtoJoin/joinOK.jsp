<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp" %>
<%@page import="com.ushrd.dto.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.ushrd.dto.MemberDto"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%

dto.setrDate(new Timestamp(System.currentTimeMillis()));
MemberDao dao=MemberDao.getInstance();
//같은 아이디가 있는지 확인
	if(dao.confirmId(dto.getId())==MemberDao.MEMBER_EXISTENT){
%>
		<script>
		alert("아이디가 이미 존재합니다.");
		history.back();
		</script>
<%
	}else{
		int ri=dao.insertMember(dto);
		if(ri==MemberDao.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id",dto.getId());
%>			<script>
				alert("회원가입을 축하합니다.")
				document.location.href="login.jsp";
			</script>

<%		

		}else{
%>			
			<script>
				alert("회원가입에 실패했습니다.");
				document.location.href="login.jsp";			
			</script>


<%
		}
		
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>