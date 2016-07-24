<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Management</title>
</head>
<body>
<h2 align="center">Toy Products</h2>
<div class=well>
		<div class="table-responsive">
			<table class="table table-bordered">
	<thead>
		<tr>
			<th style="vertical-align: top">Sr.</th>
			<th style="vertical-align: top">Id</th>
			<th style="vertical-align: top">Name</th>
<!-- 			<th>Category</th> -->
			<th style="vertical-align: top">Description</th>
			<th style="vertical-align: top">Price</th>
			<th style="vertical-align: top">Manufacturer</th>
			<th style="vertical-align: top">Stock</th>
<!-- 			<th>Supplier</th> -->
			<th style="text-align : center"><span class="glyphicon glyphicon-edit"></span></th>
			<th style="text-align : center"><span class="glyphicon glyphicon-trash"></span></th>
		</tr>
</thead>
		<c:forEach items="${products}" var="product" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>P00${product.productId}</td>
				<td>${product.productName}</td>
<%-- 				<td>${product.category}</td> --%>
				<td>${product.productDescription}</td>
				<td>${product.productPrice}</td>
				<td>${product.manufacturer}</td>
				<td>${product.stock}</td>
<%-- 				<td>${product.supplier}</td> --%>
				<td><a href="product/edit/${product.productId}" class="btn btn-default">Edit</a></td>
				<td><a href="product/delete/${product.productId}" class="btn btn-default">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
	<a href="addProduct" class="btn btn-primary">Add Toy</a>
</body>
</html>
<%@ include file="footer.jsp"%>