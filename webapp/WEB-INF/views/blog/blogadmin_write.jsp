<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 글 작성</title>
	<Link rel="stylesheet" href="/css/theme.css">
</head>
<body background="/images/kubrickbgcolor.jpg">
<center>
	<table background="/images/kubrickheader.jpg"
		 width="760" height="200" border="0" cellpadding="0" cellspacing="0">
      <tr>	<td height="60">&nbsp;</td></tr>
      <!-- 블로그 제목과 태그 시작 -->
      <tr>	<td height="60" class="blogtitle">J2EE 이야기</td></tr>
      <tr>	<td height="20" class="blogtag">자바, J2EE, 소프트웨어 엔지니어링</td></tr>
      <!-- 블로그 제목과 태그 끝 -->      
      <tr>	<td align="right" height="60">
      <a href="#">로그아웃</a>&nbsp;&nbsp;<a href="#">내 블로그 메인</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </td></tr>
    </table>
    <table background="/images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
      <tr><td height="10" colspan="10">&nbsp;</td></tr>
      <tr>
      	<td height="10" width="20">&nbsp;</td>
      	<td width="530" valign="top" class="tdcontent">
      	<!-- 메뉴 시작 -->     
      	<a class="title" href="blogadmin_basic.jsp"><b>기본설정</b></a>&nbsp;&nbsp; 
      	<a class="title" href="blogadmin_write.jsp"><b>카테고리</b></a>&nbsp;&nbsp;
      	<b>글작성</b>&nbsp;&nbsp;
      	<!-- 메뉴 끝 -->           	
      	</td>
      </tr>
      <tr><td height="5">&nbsp;</td></tr>
      <tr>
      	<td height="10">&nbsp;</td>
      	<td>
      	<!-- 작업 화면  시작 -->           	
      	<table width="720"  border="0" cellpadding="0" cellspacing="0">
      		<tr>
      			<td width="50" class="inputlabel">제목 :</td>
      			<td width="390"><input class="inputtext" type="text" size="60" name="blogtitle"></td>
      			<td width="300">
      			<select class="inputtextarea">
      				<option>미분류</option>
      				<option>자바</option>
      				<option>J2EE</option>
      				<option>소프트웨어 엔지니어</option>
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
      	<!-- 작업 화면  끝 -->           	      	
      	</td>
      </tr>
      <tr>
      	<td height="10" colspan="10">&nbsp;</td>
      </tr>
    </table>
    <table background="/images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
      <tr>
      	<td class="blogfooter">J2EE 이야기 is powered by JBlog</td>
      </tr>
	</table>
</center>
   	
</body>
</html>