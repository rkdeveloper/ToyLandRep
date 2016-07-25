<%@ include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	color: red;
}
</style>

<script type="text/javascript">
	function Validate() {
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementyId("confirmpassword").value;
		if (password != confirmpassword) {
			alert("Password do not match.");
			return false;
		}
		return true;
	}
</script>
<title>Toyland Sign Up</title>
</head>

<body>
	<h2>New user registration</h2>
	<br>
	<form:form role="form" method="post" commandName="user" action="addUser">
		<div class="row">
			<div class="col-sm-6">
				<label>User Details</label>
				<table>
					<tr>
						<td style="padding-right: 10px">
							<div class="form-group">
								First Name
								<form:input class="form-control" path="firstname" required="true" />
							</div>
						</td>
						<td style="padding-right: 10px">
							<div class="form-group">
								Last Name
								<form:input class="form-control" path="lastname" />
							</div>
						</td>
					</tr>
				</table>
				<div class="form-group">
					Username
					<form:input class="form-control" path="username" required="true" />
				</div>
				<div class="form-group">
					Email ID
					<form:input class="form-control" path="email" />
<%-- 					<form:errors path="email" cssClass="error" /> --%>
				</div>
				<div class="form-group">
					Password
					<form:password class="form-control" id="password" path="password" />
					<form:errors path="password" cssClass="error" />
				</div>
				<div class="form-group">
					Confirm Password <input class="form-control" type="password" id="confirmpassword" /> <br />
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Native address</label><br>
					<table>
						<tr>
							<td style="padding-right: 10px">Floor <form:input
									class="form-control" path="floor" />
							</td>
							<td>Building Name <form:input class="form-control"
									path="buildingName" />
							</td>
						</tr>
						<tr>
							<td style="padding-right: 10px">Land Mark <form:input
									class="form-control" path="landmark" />
							</td>
							<td>Area Name <form:input class="form-control"
									path="areaName" />
							</td>
						</tr>
						<tr>
							<td style="padding-right: 10px">City 
							<form:input class="form-control" path="city" />
							</td>
							<td>State <form:input class="form-control" path="state" />
							</td>
						<tr>
					</table>
					Pincode:
					<form:input class="form-control" path="pincode" />
				</div>
				<div class="form-group">
					<label>Contact number</label>
					<form:input class="form-control" path="contactNumber" />
					<form:errors path="contactNumber" cssClass="error" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-info" value="Register" onclick="return Validate()">Register</button>
					<button type="reset" class="btn btn-info" value="reset">Reset</button>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>
<%@include file="footer.jsp"%>