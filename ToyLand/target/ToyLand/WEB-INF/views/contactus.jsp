<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
  <body>
	<div class="row">
  		<div class="col-sm-6">
    		<div class="mycontent-left">
    		<h2>Regional Offices</h2>
    		<h3>Mumbai</h3>
    		<p>
    		C-702, Sindhudurga C.H.S. Ltd.<br>
    		Shree Sadguru Nagar,<br>
    		Devipada, Borivali (East),<br>
    		Mumbai - 400 066.<br>
    		Contact No. : 022-28856881
    		</p>
    		<p>
    		<h3>Pune</h3>
    		A-203, Martin Manor,<br>
    		Shashtri Nagar,<br>
    		Near Saras Baag,<br>
    		Swarget, Pune - 401 220.<br>
    		Contact No. : 020-24553982
    		</p>
    		</div>
  		</div>
  		<div class="col-sm-6">
    		<div class="mycontent-right">
    			<h2>Suggestions and feedback</h2>
    				<form role="form">
    						<div class="form-group">
      							<label for="firstName">Full Name :</label>
      							<input type="text" class="form-control" name="fullName" placeholder="Type your full name">
    						</div>
    						<div class="form-group">
      							<label for="email">Email:</label>
      							<input type="email" class="form-control" name="email" placeholder="Enter your email">
    						</div>
    						<div class="form-group">
      							<label for="comment">Comment :</label>
      							<textarea class="form-control" rows="5" id="comment"></textarea>
    						</div>
    					<button type="submit" class="btn btn-default">Submit</button>
    					<button type="reset" class="btn btn-default">clear all</button>
  					</form>
    		</div>
  		</div>
	</div>
	<br>
	<%@ include file="footer.jsp" %>
  </body>
</html>