<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 블로그 메인</title>
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
      <tr>	<td height="60">&nbsp;</td></tr>
    </table>
    <table background="${pageContext.request.contextPath}/assets/images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
      <tr><td height="10">&nbsp;</td></tr>
      <input type="text" value="${vo.id }">
      <tr>
      	<td width="20">&nbsp;</td>
      	<td width="530" valign="top">
      	
      	<!--  UserId에 맞는 Post를 등록해줘야 한다. -->
	      	<!-- 포스트 시작 -->
	      	<c:forEach items="${map.post}" var= "postVo">
	      		
	      		<table height="10" border="0" cellpadding="0" cellspacing="0">
	      		<tr><td class="posttitle">${postVo.no }</td></tr>
	      		<tr><td class="posttitle"><a href="${pageContext.request.contextPath}/blog/blogadmin_detail/${postVo.no}">${postVo.title}</a></td></tr>
	      		<tr><td class="postdate">${postVo.date}</td></tr>
	      		<tr><td class="postcontent">${ postVo.content}</td></tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		
	      		<!--  포스트에 해당하는 각각의 댓글 수 연산 -->
	  			<c:forEach items="${map.comments }" var="commentsVo" >
					<c:if test="${postVo.no == commentsVo.postNo }"	>
						<c:set var="commentsCount" value="${commentsCount+1}" />
					</c:if>  			
	  			</c:forEach>
	  			
	  			<c:if test="${not empty authUser }">
		      		<tr><td class="postwriter">posted by<h3> ${vo.id}</h3> in J2EE <a href="${pageContext.request.contextPath}/blog/blogadmin_detail/${postVo.no}">덧글 ${commentsCount}</a> </td></tr>
	  			</c:if>
	  		
	  			<c:set var="commentsCount" value="0"/>
	      		<br/>
	      	</table>
	      	
	      	</c:forEach>
	      	<!--  
	      	<table height="10" border="0" cellpadding="0" cellspacing="0">
	      		<tr><td class="posttitle"><a href="${pageContext.request.contextPath}/blog/blogadmin_detail">JavaOne 컨퍼런스가 열립니다.</a></td></tr>
	      		<tr><td class="postdate">2006/06/06</td></tr>
	      		<tr><td class="postcontent"> 6월 27일부터 30일까지 샌프란시스코 모스콘센터에서 2005 JavaOneSM 컨퍼런스가 열립니다. 
	      		심도깊은 강의와 실생활에서의 혁신, 공상적인 관점에 이르기까지 Java의 강력함을 발견할 수 있습니다. 
	      		컨퍼런스에 참가하셔서 Java 탄생 10주년을 축하해주세요. 또한, 전세계의 전문가들, 혁신자들과 의견을 
	      		교환할 수 있는 좋은 기회가 될 것입니다.</td></tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr><td class="postwriter">posted by 관리자 in J2EE <a href="${pageContext.request.contextPath}/blog/blogadmin_detail">덧글1</a> </td></tr>
	      	</table>
	      	-->
	      	<!-- 포스트 끝-->      	
      	</td>
      	<td width="20">&nbsp;</td>
      	<td width="190" valign="top">
      	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 시작 -->
      	<table cellpadding="0" cellspacing="0">

	      	<c:if test="${not empty authUser and authUser.id eq vo.id }">
   		   		<tr><td>
      				<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/blogadmin_basic">블로그 관리</a></td></tr>
      		</c:if>
      		<c:if test="${empty authUser }">
      		<tr><td>
      			<form action="${pageContext.request.contextPath }/blog/loginform" method="post">
      				<input type="hidden" name="hid" value="${vo.id}">
      				<input type="submit" value="로그인">
      			</form>
      			<!-- 
      				<a href="${pageContext.request.contextPath}/blog/loginform">로그인</a>&nbsp;&nbsp;
      				<input type="text" name="hid" value="${vo.id}">
      				 --> 
      		</c:if>
      		
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td><img height="80" src="${pageContext.request.contextPath}/assets/images/j2eelogo.jpg" border="0"></td></tr>
      		
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td class="categorytitle">카테고리</td></tr>
      		<!--  각 회원이 가지고 있는 카테고리들을 뿌려준다. -->
      		<c:forEach items="${map.category }" var="categoryVo">
      			<c:if test="${vo.id == categoryVo.blogId}">
      			<tr><td class="categoryitem"><a class="title" href="#">${categoryVo.name}</a></td></tr>
      			</c:if>
      		</c:forEach>
      		<!--  
      		<tr><td class="categoryitem"><a class="title" href="#">자바</a></td></tr>
      		<tr><td class="categoryitem"><a class="title" href="#">J2EE</a></td></tr>
      		<tr><td class="categoryitem"><a class="title" href="#">소프트웨어 엔지니어링</a></td></tr>
      		<tr><td class="categoryitem"><a class="title" href="#">미분류</a></td></tr>
      		-->
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td align="center"><img width="80" src="${pageContext.request.contextPath}/assets/images/logo.jpg" border="0"></td></tr>
      	</table>
      	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 끝 -->
      	</td>
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