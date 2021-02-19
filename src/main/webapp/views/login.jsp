<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>

</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<div class="alert alert-${alter}">
			    	<strong>${message}</strong> 
			 	</div>
			 </div>
			
			
			<!-- Login Form -->
			<form action="<c:url value='/dang-nhap'/>" id="formLogin" method="POST">
					<input type="text" id="login" class="fadeIn second" name="userName" placeholder="login"> 
					<input type="password" id="password" class="fadeIn third" name="password" placeholder="password"> 
					<input type="hidden" value="login" id="action" name="action" />
					<input type="submit" class="fadeIn fourth" value="Log In">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>
</body>
</html>