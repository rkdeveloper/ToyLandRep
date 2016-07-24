<%@ include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product edition page</title>
</head>
<body>
<h3 align="center">Add new toy product</h3>
	<hr>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="well">
				<form:form commandName="product" action="${product.productId}" method="post">
					<div class="form-group">
						<label>Name</label>
						<form:input path="productName" class="form-control" required="true" />
					</div>
					<div class="form-group">
						<label>Price</label>
						<form:input path="productPrice" class="form-control" required="true" />
					</div>
					<div class="form-group">
						<label>Manufacturer</label>
						<form:input class="form-control" path="manufacturer" />
					</div>
					<div class="form-group">
						<label>Stock</label>
						<form:input class="form-control" path="stock" />
					</div>
					<div class="form-group">
						<label>Description</label>
						<form:input class="form-control" path="productDescription" />
					</div>
					<br />
					<input type="submit" class="btn btn-info" value="Modify Product" />
				</form:form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>