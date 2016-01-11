<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 글 작성</title>
	<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme.css">
</head>
<body background="${pageContext.request.contextPath}/assets/images/kubrickbgcolor.jpg">
<center>
	<table background="${pageContext.request.contextPath}/assets/images/kubrickheader.jpg"
		 width="760" height="200" border="0" cellpadding="0" cellspacing="0">
      <tr>	<td height="60">&nbsp;</td></tr>
     
      <!-- 블로그 제목과 태그 시작 -->
      <tr>	<td height="60" class="blogtitle">${vo.title }</td></tr>
      <tr>	<td height="20" class="blogtag">${vo.status }</td></tr>
      
      <!-- 블로그 제목과 태그 끝 -->      
      <tr>	<td align="right" height="60">
      <a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/main/${vo.id}">내 블로그 메인</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </td></tr>
    </table>
    
    <table background="${pageContext.request.contextPath }/assets/images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
      <tr><td height="10" colspan="10">&nbsp;</td></tr>
      <tr>
      	<td height="10" width="20">&nbsp;</td>
      	<td width="530" valign="top" class="tdcontent">
      	<!-- 메뉴 시작 -->     
      	<a class="title" href="${pageContext.request.contextPath}/blog/blogadmin_basic"><b>기본설정</b></a>&nbsp;&nbsp; 
      	<a class="title" href="${pageContext.request.contextPath}/blog/blogadmin_category"><b>카테고리</b></a>&nbsp;&nbsp;
      	<b>글작성</b>&nbsp;&nbsp;
      	<!-- 메뉴 끝 -->           	
      	</td>
      </tr>
      <tr><td height="5">&nbsp;</td></tr>
      <tr>
      	<td height="10">&nbsp;</td>
      	<td>
      	<!-- 작업 화면  시작 -->
      	<form action="${pageContext.request.contextPath}/blog/insert" method="post">       	
      	<table width="720"  border="0" cellpadding="0" cellspacing="0">
      		<tr>
      			<td width="50" class="inputlabel">제목 :</td>
      			<td width="390"><input class="inputtext" type="text" size="60" name="title"></td>
      			<td width="300">
      			<!--  카테고리 영역. -->
      			<select name="categoryNo"class="inputtextarea">
      			<c:forEach items="${list}" var="category">
      				<option value="${category.no}">${category.name}</option>
      			</c:forEach>
      			</select></td>
      		</tr>
      		<tr>
      			<td width="50" class="inputlabel">내용 :</td>
      			<td colspan="10"><textarea name="content" class="inputtextarea" rows="10" cols="100"></textarea></td>
      		</tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr>
      			<td colspan="10" align="center">&nbsp;<input type="submit" value="확인"></td>
      		</tr>
      	</table>
      	</form>
      	<!-- 작업 화면  끝 -->           	      	
      	</td>
      </tr>
      <tr>
      	<td height="10" colspan="10">&nbsp;</td>
      </tr>
    </table>
    <table background="${pageContext.request.contextPath}/assets/images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
      <tr>
      	<td class="blogfooter">J2EE 이야기 is powered by JBlog</td>
      </tr>
	</table>
</center>
   	
</body>
</html>