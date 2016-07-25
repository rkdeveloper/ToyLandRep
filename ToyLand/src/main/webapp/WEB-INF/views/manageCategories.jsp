<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Management</title>

</head>
<body>
<h2 align="center">Toy Categories</h2>
	<div class=well>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="vertical-align: top">Sr.</th>
						<th style="vertical-align: top">Id</th>
						<th style="vertical-align: top">Name</th>
						<th style="vertical-align: top">Description</th>
						<th style="text-align : center"><span class="glyphicon glyphicon-edit"></span></th>
						<th style="text-align : center"><span class="glyphicon glyphicon-trash"></span></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categories}" var="category" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>CAT00${category.categoryId}</td>
							<td>${category.categoryName}</td>
							<td>${category.categoryDescription}</td>
							<td><a href="category/edit/${category.categoryId}" class="btn btn-default">Edit</a></td>
							<td><a href="category/delete/${category.categoryId}" class="btn btn-default">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<a href="addCategory" class="btn btn-primary">Add Category</a>

</body>
</html>
<%@ include file="footer.jsp"%>