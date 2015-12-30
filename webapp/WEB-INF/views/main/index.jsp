<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/theme.css">
</head>
<body>

	<form action="#">
		<table width="100%" height=320 border="0" cellpadding="0" cellspacing="0" text-align="center">
			<tr>
				<td height=40 colspan="10">&nbsp;</td>
			</tr>
			<tr>
				<td width="100%" height="120" colspan="10" align="center">
				<img src="${pageContext.request.contextPath}/assets/images/logo.jpg"
					border="0"></td>
			</tr>
					<p>[[접속상태: ${authUser }]]</p> <br/>
			<tr>
				<td width="30%" height="30">&nbsp;</td>
				<td width="70%" colspan="2">
					
					<c:choose>
						<c:when test="${authUser.role == 'ADMIN' }">
							<a href="${pageContext.request.contextPath}/user/logout"><b>로그아웃</b></a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/user/userRegisterForm"><b>사용자(블로그)등록</b></a>&nbsp;&nbsp;
      					</c:when>

						<c:when test="${authUser.role == 'USER' }">
							<a href="${pageContext.request.contextPath }/user/logout"><b>로그아웃</b></a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath }/blog/main"><b>내 블로그로 가기</b></a>&nbsp;&nbsp;
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/user/login"><b>로그인</b></a>&nbsp;&nbsp;
      					</c:otherwise>
					</c:choose>

				</td>
			</tr>
			<tr>
				<td width="30%" height="20">&nbsp;</td>
				<td width="40%"><input type="text" name="searchKeyword" size="50"></td>
				<td width="30%">&nbsp;<input type="submit" value="검색"></td>
			</tr>
			<tr>
				<td height="20" colspan="10" align="center" class="tdcontent">
					<input type="radio" name="searchCondition" checked>블로그 제목&nbsp;&nbsp;
					<input type="radio" name="searchCondition">태그&nbsp;&nbsp;
					<input type="radio" name="searchCondition">블로거
				</td>
			</tr>
			<tr>
				<td colspan="10">&nbsp;</td>
			</tr>
		</table>
	</form>

</body>
</html>