<%@ include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Toy category addition page</title>
</head>
<body>
	<h3 align="center">Add new toy category</h3>
	<hr>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="well">
				<form:form role="form" commandName="category" action="addCategory" method="post">
					<div class="form-group">
						<div class="form-group">
							<label>Name</label>
							<form:input class="form-control" path="categoryName"
								required="true" />
						</div>
						<div class="form-group">
							<label>Description</label>
							<form:input class="form-control" path="categoryDescription" />
						</div>
						<br>
						<input type="submit" class="btn btn-info" value="Add Category" />
						<button type="reset" class="btn btn-info" value="reset">Reset</button>
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</body>
</html>
<%@ include file="footer.jsp"%>