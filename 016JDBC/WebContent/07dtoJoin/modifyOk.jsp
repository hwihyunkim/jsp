<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ushrd.dto.*" %>    
<% request.setCharacterEncoding("utf-8"); %>   

<jsp:useBean id="dto" class="com.ushrd.dto.MemberDto" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
<%
	String id=(String)session.getAttribute("id");
	dto.setId(id);
	
	MemberDao dao = MemberDao.getInstance();
	int ri=dao.updateMember(dto);
	if(ri==1){
%>
	<script>
		alert("정보가 수정되었습니다.");
		document.location.href='main.jsp';
	</script>
<%
	}else{
%>  
	<script>
		alert("정보 수정 실패 입니다.");
		history.go(-1);
	</script>  
<%
	}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
왔음?
</body>
</html>