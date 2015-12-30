<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user register form</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme.css">
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/user/register">
	 <table width="100%" height="320" border="0" cellpadding="0" cellspacing="0">
	      <tr>
	      	<td height="40" colspan="10">&nbsp;</td>
	      </tr>
	      <tr>
	        <td width="100%" height="120"colspan="10" align="center">
	        <img src="${pageContext.request.contextPath}/assets/images/logo.jpg" border="0"></td>
	      </tr>
	      <tr>
	      	<td>
	      		<div style="width:200px; margin:0 auto">
				id : <input type=text name=id size=10><br><br>
				password : <input type=password name=password size=10><br><br>
				name : <input type=text name=name size=10><br><br>
				<input type=submit value=확인><br><br>
				<a href="${pageContext.request.contextPath}/user/userlist">회원 목록</a>
				</div>	      	
	      	</td>
	      </tr>
	 </table>

	</form>
</body>
</html>