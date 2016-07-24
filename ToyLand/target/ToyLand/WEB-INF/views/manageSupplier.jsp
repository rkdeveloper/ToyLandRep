<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Management</title>
</head>
<body>
<h2 align="center">Toy Suppliers</h2>
	<div class=well>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="vertical-align: top">Sr.</th>
						<th style="vertical-align: top">Supplier Id</th>
						<th style="vertical-align: top">Name</th>
						<th style="vertical-align: top">Contact Person</th>
						<th style="vertical-align: top">Contact No.</th>
						<th style="vertical-align: top">Floor</th>
						<th style="vertical-align: top">Building Name</th>
						<th style="vertical-align: top">Area Name</th>
						<th style="vertical-align: top">City</th>
						<th style="vertical-align: top">Pin code</th>
						<th style="vertical-align: top">State</th>
						<th style="text-align : center"><span class="glyphicon glyphicon-edit"></span></th>
						<th style="text-align : center"><span class="glyphicon glyphicon-trash"></span></th>
					</tr>
				</thead>
				<c:forEach items="${suppliers}" var="supplier" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>S00${supplier.supplierId}</td>
						<td>${supplier.supplierName}</td>
						<td>${supplier.contactPerson}</td>
						<td>${supplier.contactNumber}</td>
						<td>${supplier.floor}</td>
						<td>${supplier.buildingName}</td>
						<td>${supplier.areaName}</td>
						<td>${supplier.city}</td>
						<td>${supplier.pincode}</td>
						<td>${supplier.state}</td>
						<td><a href="supplier/edit/${supplier.supplierId}" class="btn btn-default">Edit</a></td>
						<td><a href="supplier/delete/${supplier.supplierId}" class="btn btn-default">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<a href="addSupplier" class="btn btn-primary">add supplier</a>
</body>
</html>
<%@ include file="footer.jsp"%>