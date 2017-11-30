<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<script src='https://www.google.com/recaptcha/api.js'></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="UTF-8" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>${param.title}</title>

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/font-awesome.css">

		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<header>
			<nav class="navbar navbar-default" role="navigation">
	            <ul class="nav navbar-nav">
	            	<li id="${param.home}"><a href="Controller?action=home">Home</a></li>
	            	<li id="${param.mail}"><a href="Controller?action=gotoMail">Mail</a></li>
	            </ul>
			</nav>
		</header>