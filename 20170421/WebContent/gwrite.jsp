<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����� �ۼ�</title>

</head>
<link href="mystyle.css" rel="stylesheet" type="text/css">
<body>

<%-- 	<div id="header">
		<%@ include file="header.jsp"%>
	</div> --%>
	<div id="menu">
		<%@ include file="menu.jsp"%>
	</div>
	<div id="main">
		<form method='post' action='gwrite_db.jsp'>
			<table>
				<tr>
					<td>a�̸�</td>
					<td><input type='text' name='name'></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type='text' name='email'></td>
				</tr>
				<tr>
					<td>Ȩ������</td>
					<td><input type='text' name='home'></td>
				</tr>
				<tr>
					<td>����</td>
					<td><textarea cols='50' rows='15' name='contents'></textarea></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value=����><input
						type=reset value=���></td>
				</tr>

			</table>
		</form>
	</div>


</body>
</html>