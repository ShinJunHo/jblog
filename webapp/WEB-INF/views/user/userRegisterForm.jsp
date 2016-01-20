<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user register form</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
	<script type="text/javascript">
	// 빈칸처리도 해줘야 한다. 회원가입시.
	
	$(function(){
		//jQuery의 Main이라고 생각하면 됨.
		console.log("JQuery!");
		$("#btn-checkId").click(function(){
			var id=$("#Jblog-id").val();
			if(id == ""){
				return ;
			}
			console.log("clicked!!");
			$.ajax({
				//이 url로 요청을 보낸다.
				url:"${pageContext.request.contextPath}/api/user/checkId",
				//get방식으로
				type:"get",
				dataType:"json",
				//contentType:"application/json"
				//서버쪽에 데이터를 보낼때 데이터 타입을 말하는 것이다.
				//checkId?id=id이렇게 넘어감.
				data:"id="+id,
				
				success:function(response){
					//성공하고 결과가 날라왔을땐 결과를 response에 넣어줘야한다.
					//controller에서 responseBody를 해줘야한다.
					console.log(response);
					if(response.result == "fail"){
						console.error(response.message);
						return;
					}
					if(response.data == false){
						alert("이미 사용중인 아이디 입니다.");
						var $id=$("#Jblog-id");
						$id.val("");
						$id.focus();
						return;
					}
				},
				error:function(jqXHR,status,error){
					console.error(status+":"+error);
				}
			});
		});
	});
	
	
	
	
	
	
	
	
	</script>


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
				id : <input type=text id="Jblog-id" name=id size=10>&nbsp;
				<input type=button id="btn-checkId" value="Id 중복확인"><br><br>
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