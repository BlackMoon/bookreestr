<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/login.css" />">		
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/jquery-ui.css" />">
	<title>Аккаунт</title>
	<script type="text/javascript" language="javascript" src="<c:url value="jquery-1.8.3.min.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="jquery-ui.min.js" />"></script>
	<script type="text/javascript" language="javascript">
		$(function () {
			$("#loginbtn").button({	
				icons: { primary: "ui-icon-locked" }
			});	
		});
	</script>
</head>

<body>
	<div class="wrapper">		
		<div class="main content clearfix">
			<div class="sign-in">
				<div class="ui-corner-all signin-box">
					<h2>Войти</h2>
					<form id="loginfrm" action="<c:url value="j_spring_security_check" />" method="post">
						<div class="user-div">
  							<label for="username">
  								<strong>Имя пользователя</strong>
  							</label>
  							<input class="text" type="text" name="username" data-val="true">
						</div>
						<div class="passwd-div">
							<label for="passwd">
								<strong>Пароль</strong>
							</label>
							<input class="text" type="password" name="passwd" data-val="true">
						</div>
						<button id="loginbtn" type="submit">Войти</button>
						<label class="remember">
  							<input type="checkbox" checked="checked" value="1" name="rememberme">
  							<strong class="remember-label">Оставаться в системе</strong>
  						</label>
					</form>
				</div>
			</div>
			<div class="info">
				<div class="info-header">
					<h1>Авторизация</h1>
					<p>Для входа в систему введите логин и пароль.</p>
				</div>
				<h2 class="msg"><c:if test="${!empty param.err}">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</c:if></h2>
			</div>
		</div>
	</div>
</body>
</html>