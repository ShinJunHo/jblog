<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>JBlog 카테고리 관리</title>
	<Link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/theme.css">
	
	<script type="text/javascript">
		function update(no){
			var name = document.getElementById("categoryTdName"+no).innerText;
			var desc = document.getElementById("categoryTdDescription"+no).innerText;
			console.log(name);
			console.log(desc);
			var categoryN = document.getElementById("categoryName");
			var categoryD = document.getElementById("categoryDescription");
			categoryN.value=name;
			categoryD.value=desc;
			
			document.getElementById("submit").value='수정하기';
			document.getElementById("tag").value='update';
			document.getElementById("no").value=no;
	//		var submit = document.getElementById("submit").value;
	//		console.log(submit);
		}
		function Reset(){
			var categoryN = document.getElementById("categoryName");
			var categoryD = document.getElementById("categoryDescription");
			categoryN.value="";
			categoryD.value="";
			document.getElementById("tag").value='insert';
			document.getElementById("submit").value='추가하기';
			//var reset = document.getElementById("reset").value;
			//console.log(reset);
		}
		function deleteCategory(no){
			console.log(no);
			var url="${pageContext.request.contextPath}/blog/delete/"+no;
			window.location=url;
			//이렇게 할 수 있고 no를 숨겨서 pretty url로 할 수 있겠다.
			//action tag와 같이.
		}
		
	
	</script>
</head>
<body background="${pageContext.request.contextPath }/assets/images/kubrickbgcolor.jpg">
<center>
	<table background="${pageContext.request.contextPath }/assets/images/kubrickheader.jpg"
		 width="760" height="200" border="0" cellpadding="0" cellspacing="0">
      <tr>	<td height="60">&nbsp;</td></tr>
      <!-- 블로그 제목과 태그 시작 -->
      <tr>	<td height="60" class="blogtitle">${vo.title}</td></tr>
      <tr>	<td height="20" class="blogtag">${vo.status }</td></tr>
      <!-- 블로그 제목과 태그 끝 -->      
      <tr>	<td align="right" height="60">
      <c:if test="${not empty authUser and authUser.id eq vo.id }">
      <a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/blog/main/${vo.id}">내 블로그 메인</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </c:if>
      </td></tr>
    </table>
    <table background="${pageContext.request.contextPath }/assets/images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
      <tr><td height="10" colspan="10">&nbsp;</td></tr>
      <tr>
      	<td height="10" width="20">&nbsp;</td>
      	<td width="530" valign="top" class="tdcontent">
      	<!-- 메뉴 시작 -->     
      	<a class="title" href="${pageContext.request.contextPath }/blog/blogadmin_basic"><b>기본설정</b></a>&nbsp;&nbsp;
      	<b>카테고리</b>&nbsp;&nbsp;
      	<a class="title" href="${pageContext.request.contextPath }/blog/blogadmin_write"><b>글작성</b></a>&nbsp;&nbsp;
      	<!-- 메뉴 끝 -->           	 
      	</td>
      </tr>
      <tr><td height="5">&nbsp;</td></tr>
      <tr>
      	<td height="10">&nbsp;</td>
      	<td>
      	<c:set var="count" value="${fn:length(list)}" />
      	<!-- 작업 화면  시작 -->
      	<table width="720"  border="1" cellpadding="0" cellspacing="0">
      		<tr>
      			<td width="50" class="tablelabel">번호</td>
      			<td width="150" class="tablelabel">카테고리명</td>
      		    <!--  <td width="80" class="tablelabel">보이기 유형</td>-->
      			<td width="70" class="tablelabel">포스트 수</td>
      			<td width="280" class="tablelabel">설명</td>
      			<td width="70" class="tablelabel">삭제</td>      			
      		</tr>
      		<c:forEach items="${list }" var="categoryVo" varStatus="status">
			<tr>
				<td class="tablecontent" align="center">${count-status.index}</td>
				<td id="categoryTdName${categoryVo.no}" class="tablecontent" align="center" onclick="update(${categoryVo.no})">${categoryVo.name }</td>
				<!-- <td class="tablecontent" align="center">${categoryVo.description}</td>-->
				<td class="tablecontent" align="center">10</td>
				<td id="categoryTdDescription${categoryVo.no}" class="tablecontent" align="center">${categoryVo.description }</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="${pageContext.request.contextPath }/assets/images/delete.jpg" border="0" onclick="deleteCategory(${categoryVo.no})"></td>
			</tr>  
			 </c:forEach>			    					
      	</table>
      	<!--             	
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
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="${pageContext.request.contextPath }/assets/images/delete.jpg" border="0"></td>
			</tr>  
			<tr>
				<td class="tablecontent" align="center">2</td>
				<td class="tablecontent">자바</td>
				<td class="tablecontent" align="center">텍스트</td>
				<td class="tablecontent" align="center">10</td>
				<td class="tablecontent">자바에 대한 포스트</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="${pageContext.request.contextPath }/assets/images/delete.jpg" border="0"></td>
			</tr>  
			<tr>
				<td class="tablecontent" align="center">3</td>
				<td class="tablecontent">J2EE</td>
				<td class="tablecontent" align="center">타이틀</td>
				<td class="tablecontent" align="center">10</td>
				<td class="tablecontent">J2EE에 대한 포스트</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="${pageContext.request.contextPath }/assets/images/delete.jpg" border="0"></td>
			</tr>  						    		
			<tr>
				<td class="tablecontent" align="center">4</td>
				<td class="tablecontent">소프트웨어 엔지니어링</td>
				<td class="tablecontent" align="center">타이틀</td>
				<td class="tablecontent" align="center">10</td>
				<td class="tablecontent">소프트웨어 엔지니어링에 대한 포스트</td>
				<td class="tablecontent" align="center">&nbsp;<img height="9" src="${pageContext.request.contextPath }/assets/images/delete.jpg" border="0"></td>
			</tr>  						    					
      	</table>
      	
      	-->
      	<form action="${pageContext.request.contextPath}/blog/categoryAdd" method="POST">
      		<input type="hidden" id="tag" name="tag" value="insert">
      		<input type="hidden" id="no" name="no" value="">
      		
      	<table width="720"  border="0" cellpadding="0" cellspacing="0">
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr><td class="tdcontent" height="5"><b>새로운 카테고리 추가</b></td></tr>
      		<tr><td height="5">&nbsp;</td></tr>      		
      		<tr>
      			<td width="150" class="inputlabel">카테고리명 :</td>
      			<td><input id="categoryName" class="inputtext" type="text" size="40" name="name" value=""></td>
      		</tr>
      		<!--  
      		<tr>
      			<td width="150" class="inputlabel">보이기 유형 :</td>
      			<td class="tdcontent">
      				<input type="radio" name="displayType" checked>타이틀&nbsp;&nbsp;
      				<input type="radio" name="displayType">텍스트&nbsp;&nbsp;</td>      			
      		</tr>
      		-->
      		<tr>
      			<td width="150" class="inputlabel">설명 :</td>
      			<td><input id="categoryDescription" class="inputtext" type="text" size="50" name="description" value=""></td>
      		</tr>
      		<tr><td height="5">&nbsp;</td></tr>
      		<tr>
      			<td colspan="10" align="center">&nbsp;<input id="submit" type="submit" name="add" value="추가하기">&nbsp;<input id="reset" type="button" value="취소하기" onclick="Reset()"></td>
      		</tr>
      		<tr>
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
    <table background="${pageContext.request.contextPath }/assets/images/kubrickfooter.jpg" width="760" height="63" border="0" cellpadding="0" cellspacing="0">
      <tr>
      	<td class="blogfooter">J2EE 이야기 is powered by JBlog</td>
      </tr>
	</table>
</center>
   	
</body>
</html>