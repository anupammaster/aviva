<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration detail</title>
</head>
<body>

	<div>
		<h2>registration details</h2>
		<h3>Registration id : ${id}</h3>
		<h3>First Name : ${first_name}</h3>
		<h3>Last Name : ${last_name}</h3>
		<h3>Email : ${email}</h3>
	</div>
</body>
</html>