<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Toys Page</title>

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
<body ng-app="toysApp" ng-controller="getToys" >
	
	<div class="row">
		<div class="col-sm-4"></div>
			<div class="col-sm-3">
				<h3>Our exciting products</h3>
			</div>
		<div class="col-sm-2"></div>
		<div class="col-sm-3">
			<label>search for your favorite toy :</label>

			<input type="text" class="form-control" name="search" ng-model="search" />
		</div>
	</div>
	
	<hr>

	<div class="row" ng-repeat="product in products | filter : search">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
				
					<div class="row">
						<div class="col-sm-3">
							<img style="width: 155px; height: 155px" src="${pageContext.request.contextPath}/resources/images/{{product.productId}}.jpg" />
						</div>
						<div class="col-sm-8">
							<div class="panel panel-info">
								<div class="panel-heading">
									<a href="productdetails/{{product.productId}}">
									<h4><c:out value="{{product.productName}}" /></h4></a>
								</div>
								<div class="panel-body">
									<c:out value="{{product.productDescription}}" />
									<br><br>
									<label>Price :</label> Rs. <c:out value="{{product.productPrice}}" />/-
								</div>
							</div>
						</div>
					</div>
		</div>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>