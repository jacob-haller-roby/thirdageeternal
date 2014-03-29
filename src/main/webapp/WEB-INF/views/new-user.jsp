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
<form method="post" action="new-user" role="form">
<div class="form-group">
<label for="exampleInputEmail1">Username</label>
<input type="text" class="form-control" placeholder="Enter Username" name="login" id="login" maxlength="30" />
</div>
<div class="form-group">
  <label for="exampleInputPassword1">Password</label>
  <input type="password" class="form-control" id="password" placeholder="Password" name="password">
</div>



<button type="submit" class="btn btn-default">Submit</button>
</form>	

</body>
</html>
