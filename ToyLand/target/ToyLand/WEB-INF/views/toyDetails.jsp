<%@ include file="header.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Toy Details</title>
</head>
<body>
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">
	<img style="width: 500px; height: 400px"
		src="<c:url value="/resources/images/${product.productId}.jpg" />" />
</div>
<div class="col-sm-3"></div> 
</div>
	<br>
	<br>
	<div class=well>
		<h3>Product details</h3>
		<%-- 		<form:form action="${product.productId}" commandName="product" method="GET"> --%>
		<table class="table table-condensed">
			<tr>
				<td><b>Product Id</b></td>
				<td>:</td>
				<td>${product.productId}</td>
			</tr>
			<tr>
				<td><b>Category Name</b></td>
				<td>:</td>
				<td>${product.productName}</td>
			</tr>
			<tr>
				<td><b>Description</b></td>
				<td>:</td>
				<td>${product.productDescription}</td>
			</tr>
			<tr>
				<td><b>Product Price</b></td>
				<td>:</td>
				<td>${product.productPrice}</td>
			</tr>
		</table>

		<form:form method="POST"
			action="${pageContext.request.contextPath}/user/addtocart?productId=${product.productId}"
			modelAttribute="cart">
			<input type="hidden" value="${product.productId}" />
			<span class="h5">Quantity :<form:input path="quantity" type="number" style="width:15%" /></span>
			<br>
			<br>
			<button type="submit" value="Add" class="btn btn-info">Add to Cart</button>
			<button type="button" class="btn btn-info">Continue Shopping</button>
		</form:form>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>