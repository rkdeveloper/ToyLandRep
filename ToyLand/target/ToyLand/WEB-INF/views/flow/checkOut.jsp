<%@ include file="/WEB-INF/views/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form  method="post">
<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<div class="panel-heading">
		<div class="panel-title text-center">
	    	<div  class="title h2 col-sm-6 col-md-6 col-lg-9">Your Billing Details are Collected....Confirm Order ?</div>
	    	<div class="col-xs-10 col-sm-6 col-md-6 col-lg-3 "> 
						<div class="form-group ">
							
							<p>
							
							</p>

 						</div>
					</div>
					
        </div>
    </div> 
    <p>
    <div class="row" align="center">
    <div class="col-lg-9">
	       <div class="h3"> <input type="submit" name="_eventId_submit" value="Confirm" /></div>
	        </div>
	        </div> 
    </p>
    </form:form>
</body>
</html>
<%@ include file="/WEB-INF/views/footer.jsp"%>