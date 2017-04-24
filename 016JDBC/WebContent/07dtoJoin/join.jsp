<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="members.js"></script>
</head>
<body>

	<form action="joinOk.jsp" method="post" name="reg_form">
		아이디 : <input type="text" name="id" size="20"><br>
		비밀번호 : <input type="password" name="pw" size="20"><br>
		비밀번호확인 : <input type="password" name ="pw_check" size="20"><br>
		이름 : <input type="text" name="name" size="20"><br>
		이메일: <input type="text" name="mail" size="20"><br>
		주소 : <input type="text" name="address" size="20"><br>
		<input type="button" value="회원가입" onclick="infoConfirm()">&nbsp;&nbsp;
		<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>

</body>
</html>