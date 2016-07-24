<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Toys Page</title>
</head>
<body>
	<h3 align="center">Our exciting products</h3>
	<hr>
	<div class="row">
		<div class="col-sm-3">
			<div class="well well-lg">
				<c:forEach items="${categories}" var="category">
					<li><a href="#">${category.categoryName}</a></li>
				</c:forEach>
				<li><a href="allToys">All Toys</a></li>
			</div>
		</div>
		<div class="col-sm-6">

			<!-- 			<table> -->
			<%-- 				<c:forEach items="${products}" var="product"> --%>
			<!-- 					<tr> -->
			<%-- 						<td><a href="${product.productId}"><img --%>
			<!-- 								style="width: 100px; height: 100px" -->
			<%-- 								src="<c:url value="/resources/images/${product.productId}.jpg" />" /></a> --%>
			<%-- 						<td><a href="${product.productId}"><c:out --%>
			<%-- 									value="${product.productName}" /></a></td> --%>
			<!-- 					</tr> -->
			<%-- 				</c:forEach> --%>
			<!-- 			</table> -->

			<c:forEach items="${products}" var="product">
				<div class=well>
					<div class="row">
						<div class="col-sm-3">
							<a href="productdetails/${product.productId}">
							<img style="width: 100px; height: 100px"
								 src="<c:url value="/resources/images/${product.productId}.jpg" />" /></a>
						</div>
						<div class="col-sm-8">
							<span><b>${product.productName}</b></span><br><br>
							<span>${product.productDescription}</span><br>
							Rs. <span>${product.productPrice}</span>/-
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>