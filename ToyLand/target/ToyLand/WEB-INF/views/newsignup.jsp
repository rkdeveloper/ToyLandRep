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
	<form:form role="form" method="post" commandName="user"
		action="addUser">
		<div class="row">
			<div class="col-sm-5">
				<h4>User Details</h4>
				<table>
					<tr>
						<td style="padding-right: 10px">
							<div class="form-group">
								<label>First Name :</label>
								<form:input class="form-control" path="firstname" required="true" />
							</div>
						</td>
						<td style="padding-right: 10px">
							<div class="form-group">
								<label>Last Name :</label>
								<form:input class="form-control" path="lastname" />
							</div>
						</td>
					</tr>
				</table>
				<div class="form-group">
					<label>Username :</label>
					<form:input class="form-control" path="username" required="true" />
					<form:errors path="username" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Email ID :</label>
					<form:input class="form-control" type="email" path="email" />
					<form:errors path="email" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Password :</label>
					<form:password class="form-control" id="password" path="password" />
					<form:errors path="password" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Confirm Password :</label>
					<input class="form-control" type="password" id="confirmpassword" /> 
					<br />
				</div>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-6">
				<div class="form-group">
					<h4>Native address</h4>
					<table>
						<tr>
							<td style="padding-right: 10px"><label>Floor :</label>
							<form:input class="form-control" path="floor" />
							</td>
							<td><label>Building Name :</label>
							<form:input class="form-control" path="buildingName" />
							</td>
						</tr>
						<tr>
							<td style="padding-right: 10px"><label>Land Mark :</label>
							<form:input class="form-control" path="landmark" />
							</td>
							<td><label>Area Name :</label><form:input class="form-control"
									path="areaName" />
							</td>
						</tr>
						<tr>
							<td style="padding-right: 10px"><label>City :</label><form:input
									class="form-control" path="city" />
							</td>
							<td><label>State :</label><form:input class="form-control" path="state" />
							</td>
						<tr>
						<tr>
							<td style="padding-right: 10px"><label>Pincode :</label>
							<form:input class="form-control" path="pincode" />
							<form:errors path="pincode" cssClass="error" />
							</td>
						</tr>
						<tr>
							<td style="padding-right: 10px"><label>Mobile :</label>
							<form:input class="form-control" path="contactNumber" />
							<form:errors path="contactNumber" cssClass="error" />
							</td>
							<td><label>Landline :</label>
							<form:input class="form-control" path="landlineNumber" />
							<form:errors path="landlineNumber" cssClass="error" />
							</td>
						</tr>
					</table>
					<br>
					<div class="form-group">
						<button type="submit" class="btn btn-info" value="Register" onclick="return Validate()">
						Register</button>
						<button type="reset" class="btn btn-info" value="reset">Reset</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>
<%@include file="footer.jsp"%>