<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="04fileUpload.jsp" method="post" enctype="multipart/form-data">
<table border=1>
	<tr>
		<td colspan="2"><h3>���Ͼ��ε���</h3></td>
	</tr>
	<tr>
		<td>�ø����:</td><td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>����:</td><td><input type="text" name="subject"/></td>
	</tr>
	<tr>
		<td>���ϸ�1:</td><td><input type="text" name="fileName1"/></td>
	</tr>
	<tr>
		<td>���ϸ�2:</td><td><input type="text" name="fileName2"/></td>
	</tr>
	<tr>
		<td colspan=2><input type="submit" value="����"/></td>
	</tr>

</table>


</form>

</body>
</html>