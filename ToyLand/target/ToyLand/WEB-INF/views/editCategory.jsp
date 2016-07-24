<%@ include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category edition page</title>
</head>
<body>
<h3 align="center">Edit existing toy category</h3>
	<hr>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="well">
				<form:form commandName="category" action="${category.categoryId}" method="post">
					<div class="form-group">
						<div class="form-group">
							<label>Name</label>
							<form:input class="form-control" path="categoryName" />
						</div>
						<div class="form-group">
							<label>Description</label>
							<form:input class="form-control" path="categoryDescription" />
						</div>
						<input type="submit" class="btn btn-info" value="Modify Category" />
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>