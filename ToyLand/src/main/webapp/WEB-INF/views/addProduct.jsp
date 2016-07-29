<%@ include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Addition Page</title>
</head>
<body>
	<h3 align="center">Add new toy product</h3>
	<hr>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="well">
				<%-- <form:form commandName="product" action="${product.productId}" method="post"> --%>
				<form:form commandName="product" role="form" action="${pageContext.request.contextPath}/addProduct" method="POST" enctype="multipart/form-data">
					<div class="form-group">
						<label>Name</label>
						<form:input path="productName" class="form-control" required="true" />
					</div>
					<div class="form-group">
					<div class="dropdown">
					<label>Category</label><br>
					<form:select path="category" class="form-control">
						<form:options items="${categories}" itemLabel="categoryName" itemValue="categoryId" />
					</form:select>
					</div>
					</div>
					<div class="form-group">
					<label>Supplier</label><br>
					<form:select path="supplier" class="form-control">
						<form:options items="${suppliers}" itemLabel="supplierName" itemValue="supplierId" />
					</form:select>
					</div>
					<div class="form-group">
						<label>Price</label>
						<form:input min="100" max="50000" path="productPrice" class="form-control"/>
<%-- 						<form:errors path="productPrice" cssClass="error" /> --%>
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
					<div class="form-group">
						<label>Select image :</label>
						<input type="file" name="img" path="img" />
					</div>
					<input type="submit" class="btn btn-info" value="Add Product" />
					<button type="reset" class="btn btn-info" value="reset">Reset</button>
				</form:form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>