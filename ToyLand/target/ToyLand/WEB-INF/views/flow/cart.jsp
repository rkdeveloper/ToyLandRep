<%@ include file="/WEB-INF/views/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<script>
 var toysApp = angular.module('toysApp',[]);
 toysApp.controller('getToys', function($scope,$http,$location)
		 {
	 		$scope.products = ${products};
	 		$scope.name = "ToyLand";
	 		$scope.search = location.search.substring(6);
 });
</script>
</head>

<body ng-app="toysApp" ng-controller="getToys">
	<h3 align="center">My Cart</h3> 
	<div class="well">
		<table class="table table-hover">
			<thead>
				<tr>
					<th style="vertical-align: top">Sr.</th>
					<th style="vertical-align: top">Product Name</th>
<!-- 					<th style="vertical-align: top">Name</th> -->
					<th style="vertical-align: top">Price</th>
					<th style="vertical-align: top">Quantity</th>
<!-- 					<th style="text-align : left"><span class="glyphicon glyphicon-edit"></span></th> -->
					<th style="text-align : left"><span class="glyphicon glyphicon-trash"></span></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartList}" var="cart" varStatus="status">
					<tr>
					
						<td>${status.count}</td>
<!-- 						<td> -->
<%-- 						<a href="productdetails/${product.productId}">  --%>
<%-- 						<img style="width: 100px; height: 100px" src="${pageContext.request.contextPath}/resources/images/{{product.productId}}.jpg" /></a> --%>
<!-- 						</td> -->
						<td>${cart.productName}</td>
<%-- 						<td>${cart.productDescription}</td> --%>
						<td>${cart.price}</td>
						<td>${cart.quantity}</td>
<%-- 						<td><a href="<spring:url value='cart/edit/${cart.cartId}'/>" --%>
<!-- 							class="btn btn-default">Edit</a></td> -->
						<td><a
							href="<spring:url value='cart/delete/${cart.cartId}'/>"
							class="btn btn-default">Delete item</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form:form action="collectbillinginfo?cartId=164">
		<div class="row">
			<div class="col-sm-6">
				<div align="left">
					<a href="${pageContext.request.contextPath}/allToys" class="btn btn-primary"><span class="glyphicon glyphicon-arrow-left"></span> Continue Shopping</a>
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