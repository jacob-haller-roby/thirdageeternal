<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login page</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<div class="col-sm-8 col-centered">
		<div class="row text-centered">
			<h1>Login page</h1>
		</div>

		<p>
			<c:if test="${error == true}">
				<b class="error">Invalid login or password.</b>
			</c:if>
		</p>

		<form method="post" action="<c:url value='j_spring_security_check'/>">
			<div class="row top-buffer">
				<div class="col-sm-4 text-centered">Login:</div>
				<div class="col-sm-8 text-centered">
					<input type="text" name="j_username" id="j_username" size="30"
						maxlength="40" />
				</div>
			</div>
			<div class="row top-buffer">
				<div class="col-sm-4 text-centered">Password:</div>
				<div class="col-sm-8 text-centered">
					<input type="password" name="j_password" id="j_password" size="30"
						maxlength="32" />
				</div>
			</div>
			<div class="row vertical-buffer">
				<div class="col-sm-6 text-centered">
					<a data-toggle="modal" href="#new-user-modal">Create
						an Account</a>
				</div>
				<div class="text-centered col-sm-6">
					<input type="submit" value="Login" />
				</div>
			</div>
		</form>

	</div>

</body>
</html>