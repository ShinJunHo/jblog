<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 카테고리 관리</title>
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
      	<b>카테고리</b>&nbsp;&nbsp;
      	<a class="title" href="blogadmin_write.jsp"><b>글작성</b></a>&nbsp;&nbsp;
      	<!-- 메뉴 끝 -->           	 
      	</td>
      </tr>
      <tr><td height="5">&nbsp;</td></tr>
      <tr>
      	<td height="10">&nbsp;</td>
      	<td>
      	<!-- 작업 화면  시작 -->           	
      	<table width="720"  border="1" cellpadding="0" cellspacing="0">
      		<tr>
      			<td width="50" class="tablelabel">번호</td>
      			<td width="150" class="tablelabel">카테고리명</td>
      			<td width="80" class="tablelabel">보이기 유형</td>
      			<td width="70" class="tablelabel">포스트 수</td>
      			<td width="280" class="tablelabel">설명</td>
      			<td width="70" class="tablelabel">삭제</td>      			
      		</tr>
			<tr>
				<td class="tablecontent" align="center">1</td>
				<td class="tablecontent">미분류</td>
				<td class="tablecontent" align="center">타이틀</td>
				<td class="tablecontent" align="center">10</td>
				<td class="tablecontent">카테고리를 지정하지 않은경우</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="/images/delete.jpg" border="0"></td>
			</tr>  
			<tr>
				<td class="tablecontent" align="center">2</td>
				<td class="tablecontent">자바</td>
				<td class="tablecontent" align="center">텍스트</td>
				<td class="tablecontent" align="center">10</td>
				<td class="tablecontent">자바에 대한 포스트</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="/images/delete.jpg" border="0"></td>
			</tr>  
			<tr>
				<td class="tablecontent" align="center">3</td>
				<td class="tablecontent">J2EE</td>
				<td class="tablecontent" align="center">타이틀</td>
				<td class="tablecontent" align="center">10</td>
				<td class="tablecontent">J2EE에 대한 포스트</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="/images/delete.jpg" border="0"></td>
			</tr>  						    		
			<tr>
				<td class="tablecontent" align="center">4</td>
				<td class="tablecontent">소프트웨어 엔지니어링</td>
				<td class="tablecontent" align="center">타이틀</td>
				<td class="tablecontent" align="center">10</td>
				<td class="tablecontent">소프트웨어 엔지니어링에 대한 포스트</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="/images/delete.jpg" border="0"></td>
			</tr>  						    					
      	</table>
      	<table width="720"  border="0" cellpadding="0" cellspacing="0">
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td class="tdcontent" height="5"><b>새로운 카테고리 추가</b></td></tr>
      		<tr><td height="5">&nbsp;</td></tr>      		
      		<tr>
      			<td width="150" class="inputlabel">카테고리명 :</td>
      			<td><input class="inputtext" type="text" size="40" name="categoryName" value=""></td>
      		</tr>
      		<tr>
      			<td width="150" class="inputlabel">보이기 유형 :</td>
      			<td class="tdcontent">
      				<input type="radio" name="displayType" checked>타이틀&nbsp;&nbsp;
      				<input type="radio" name="displayType">텍스트&nbsp;&nbsp;</td>      			
      		</tr>
      		<tr>
      			<td width="150" class="inputlabel">설명 :</td>
      			<td><input class="inputtext" type="text" size="50" name="description" value=""></td>
      		</tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr>
      			<td colspan="10" align="center">&nbsp;<input type="submit" value="추가하기"></td>
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