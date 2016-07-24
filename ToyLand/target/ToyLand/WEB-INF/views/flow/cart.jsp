<%@ include file="/WEB-INF/views/header.jsp"%>

<body>
	<h3 align="center">My Cart</h3>
	<div class="well">
		<table class="table table-hover">
			<thead>
				<tr>
					<th style="vertical-align: top">Sr.</th>
					<th style="vertical-align: top">Product</th>
					<th style="vertical-align: top">Name</th>
					<th style="vertical-align: top">Price</th>
					<th style="vertical-align: top">Quantity</th>
					<th style="text-align : left"><span class="glyphicon glyphicon-edit"></span></th>
					<th style="text-align : left"><span class="glyphicon glyphicon-trash"></span></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartList}" var="cart" varStatus="status">
					<tr>
					
						<td>${status.count}</td>
						<td><a href="productdetails/${cart.productId}"> <img
								style="width: 100px; height: 100px"
								src="<c:url value="/resources/images/${cart.productId}.jpg" />" /></a>
						</td>
						<td>${cart.productName}</td>
						<td>${cart.price}</td>
						<td>${cart.quantity}</td>
						<td><a href="<spring:url value='/cart/edit/${cart.cartId}'/>"
							class="btn btn-default">Edit</a></td>
						<td><a
							href="<spring:url value='cart/delete/${cart.cartId}'/>"
							class="btn btn-default">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form:form action="collectbillinginfo?cartId=15">
		<div class="row">
			<div class="col-sm-6">
				<div align="left">
					<a href="allToys" class="btn btn-primary">Continue Shopping</a>
				</div>
			</div>
			<div class="col-sm-6">
				<div align="right">
					<input type="submit" class="btn btn-primary" value="Check Out" />
				</div>
			</div>
		</div>
	</form:form>
</body>
<%@ include file="/WEB-INF/views/footer.jsp"%>