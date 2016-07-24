<%@ include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Add new toy supplier</h3>
	<hr>
	<div class="row">
		<div class="well">
			<form:form commandName="supplier" action="${supplier.supplierId}" method="post">
				<h4>Contact Information :</h4>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Name :</label>
						<form:input path="supplierName" class="form-control" />
						<form:errors path="supplierName" cssClass="error" />
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Contact Person :</label>
						<form:input path="contactPerson" class="form-control" />
						<form:errors path="contactPerson" cssClass="error" />
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Contact No.:</label>
						<form:input path="contactNumber" class="form-control" />
						<form:errors path="contactNumber" cssClass="error" />
					</div>
				</div>
				<h4>Supplier Address :</h4>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Floor :</label>
						<form:input path="floor" class="form-control" />
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Building :</label>
						<form:input path="buildingName" class="form-control" />
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Name of the Area :</label>
						<form:input path="areaName" class="form-control" />
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Name of the city :</label>
						<form:input path="city" class="form-control" />
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>Pincode :</label>
						<form:input path="pincode" class="form-control" />
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>State :</label>
						<form:input path="state" class="form-control" />
					</div>
				</div>
				<br />
				<input type="submit" class="btn btn-info" value="Modify Supplier" />
			</form:form>
		</div>
	</div>
	<br />
</body>
</html>
<%@ include file="footer.jsp"%>