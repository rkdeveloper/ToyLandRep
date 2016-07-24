<%@ include file="header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<title>Toyland Sign In</title>
<body>
<h2>Member's Login</h2>
	<br>
<div class="row">
<div class="col-sm-4"></div>
	<div class="col-sm-4">
	<div class="well">
		<form:form method="post" role="form" commandName="user" action="perform_login">
			<div class="form-group">
				<label>Username :</label>
				<form:input class="form-control" path="username" required="true" />
			</div>
			<div class="form-group">
				<label>Password :</label>
				<form:input class="form-control" type="password" path="password" required="true" />
			</div>
			<br>
			<input type="submit" class="btn btn-info" value="Login" />
			<button type="reset" class="btn btn-info" value="reset">Reset</button>
		</form:form>
		</div>
		<div class="col-sm-4"></div>
	</div>
	</div>
</body>
</html>
<%@include file="footer.jsp"%>