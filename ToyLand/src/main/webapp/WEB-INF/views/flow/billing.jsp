<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-6">
			<div class="well">
				<form:form role="form" method="post" commandName="cart">
					 
					<div class="form-group">
						<label>Shipping Address</label><br> 
						<table>
						<tr><td style="padding-right : 10px">
						Floor
						<form:input class="form-control" path="floor" required="true"/>
						</td><td>
						Building Name
						<form:input class="form-control" path="buildingName" required="true"/>
						</td></tr>
						<tr><td style="padding-right : 10px">
						Land Mark
						<form:input class="form-control" path="landmark" required="true"/>
						</td><td>
						Area Name
						<form:input class="form-control" path="areaName" required="true"/>
						</td></tr>
						<tr><td style="padding-right : 10px">
						City
						<form:input class="form-control" path="city" required="true"/>
						</td><td>
						State
						<form:input class="form-control" path="state" required="true"/>
						</td><tr>
						</table>
						Pincode:
						<form:input class="form-control" path="pincode" />
					</div>
 

					<div class="form-group">
						<label>Contact number</label>
						<form:input class="form-control" path="contactNumber" />
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-info" value="Proceed" name="_eventId_submit" />
							<a href="<c:url value="/user/viewcart?userName=${pageContext.request.userPrincipal.name}" />" class="btn btn-info"> Back to Cart</a>
<!-- 						<button type="reset" class="btn btn-info" value="reset">Reset</button> -->
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="verticalLine">
		<div class="col-sm-6"></div>
	</div>
</body>
</html>
<%@ include file="/WEB-INF/views/footer.jsp"%>