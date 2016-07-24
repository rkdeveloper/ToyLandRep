<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<link href="<spring:url value="/resources/css/bootstrap.css" />" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="<spring:url value="/resources/css/mystyler.css" />" />
<script src="<spring:url value="/resources/js/html5shiv.min.js" />"></script>
<script src="<spring:url value="/resources/js/respond.min.js" />"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<spring:url value="/resources/jquery/jquery-2.2.4.min.js" />"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<spring:url value="/resources/js/bootstrap.js"/>"></script>
<!-- AngularJS files have been included here -->
<script src="<spring:url value="/resources/angular/angular.min.js" />"></script>
<script src="<spring:url value="/resources/angular/angular.js" />"></script>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	height: 30%;
	margin: auto;
}

.descript {
	font-family: Comic Sans Ms;
	font-size: 16px;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<p></p>
		<div class="row">
			<div class="col-sm-2">
				<img class="img-responsive" width="120" height="215"
					src="${pageContext.request.contextPath}/resources/images/toys2osdois.gif" />
			</div>
			<div class="col-sm-10">
				<h1>
					<b>WELCOME TO TOYLAND</b>
				</h1>
			</div>
			<div align="center">
				<img align="middle" class="img-responsive" width="400" height="50"
					src="${pageContext.request.contextPath}/resources/images/group01.gif" />
			</div>
		</div>
		<p></p>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar"></button>
					<a class="navbar-brand" href="#">Toy Land</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-home"></span> Home</a></li>
						<li><a href="${pageContext.request.contextPath}/allToys">All Toys</a></li>
						
<!-- 						<li class="dropdown"><a class="dropdown-toggle" -->
<!-- 							data-toggle="dropdown" href="allToys"> All Categories <span -->
<!-- 								class="caret"></span></a> -->
<!-- 							<ul class="dropdown-menu"> -->
<%-- 								<c:forEach items="${categories}" var="category"> --%>
<%-- 									<li><a href="#">${category.categoryName}</a></li> --%>
<%-- 								</c:forEach> --%>
<!-- 								<li><a href="allToys">All Toys</a></li> -->
<!-- 							</ul></li> -->

						<li><a href="${pageContext.request.contextPath}/getAboutUs">About Us</a></li>
						<li><a href="${pageContext.request.contextPath}/getContactUs">Contact Us</a></li>

						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> Toyland Management <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="addCategory">Add Category</a></li>
									<li><a href="getCategory">View Categories</a></li>
									<li><a href="addSupplier">Add Supplier</a></li>
									<li><a href="getSupplier">View Suppliers</a></li>
									<li><a href="addProduct">Add Toys</a></li>
									<li><a href="getProduct">View Toys</a>
								</ul></li>

							<li><a>Welcome "${pageContext.request.userPrincipal.name}"</a></li>
							<li><span class="glyphicon glyphicon-king"></span> Admin</li>
							<li><a href="<c:url value="/perform_logout" />"><span
									class="glyphicon glyphicon-log-out"></span>Logout</a>
						</sec:authorize>
					</ul>

					<sec:authorize access="hasRole('ROLE_USER')">
					<div align="right">
						<ul class="nav navbar-nav">
							<li><a><b><i>Welcome "${pageContext.request.userPrincipal.name}"</i></b></a></li>
							<li><a
								href="<c:url value="/user/viewcart?userName=${pageContext.request.userPrincipal.name}" />">
								<span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
							<li><a href="${pageContext.request.contextPath}/perform_logout">
								<span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul>	
						</div>
					</sec:authorize>
					
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${pageContext.request.contextPath}/getSignUp">
							<span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
							<li><a href="${pageContext.request.contextPath}/getLogin">
							<span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</ul>
					</c:if>
				</div>
			</div>
		</nav>
	</header>
</body>
</html>