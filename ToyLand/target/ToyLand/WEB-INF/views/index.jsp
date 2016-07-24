<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<title>Toyland Home</title>
<body>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="<spring:url value="resources/images/happykids.jpg" />" />
			</div>

			<div class="item">
				<img src="<spring:url value="resources/images/electoys.jpg" />" />
			</div>

			<div class="item">
				<img src="<spring:url value="resources/images/watches.jpg" />" />
			</div>

			<div class="item">
				<img src="<spring:url value="resources/images/edutoys.jpg" />" />
			</div>

			<div class="item">
				<img src="<spring:url value="resources/images/barbie.jpg" />" />
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span class="glyphicon glyphicon-chevron-right" 
			aria-hidden="true"></span><span class="sr-only">Next</span>
		</a>
	</div>
	<br>
	<hr>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<img src="<spring:url value="resources/images/happykids.jpg" />" class="img-circle"
					class="img-responsive" width="284" height="216" /> <br> <br>
				<p class="descript">
					<b style="font-family: Arial">Smile on every face :</b><br>Toys
					for all age groups with wide veriety.
				</p>
			</div>
			<div class="col-xs-1"></div>
			<div class="col-sm-3">
				<img src="<spring:url value="resources/images/watches.jpg" />" class="img-circle"
					class="img-responsive" width="284" height="216" /> <br> <br>
				<p class="descript">
					<b style="font-family: Arial">Free Accessories :</b><br>Free
					kids accessories worth purchase of Rs. 2000/-
				</p>
			</div>
			<div class="col-xs-1"></div>
			<div class="col-sm-3">
				<img src="<spring:url value="resources/images/edutoys.jpg" />" class="img-circle"
					class="img-responsive" width="284" height="216"> <br> <br>
				<p class="descript">
					<b style="font-family: Arial">Educational Toys :</b><br>For
					pre-schoolers as well as greater age groups.
				</p>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="row">
		<div class="col-sm-5">
			<p style="font-family: Comic Sans Ms; font-style: italic; font-size: 16px">
				Choosing toys that are both fun and educational for kids aged 5-7
				can be a hassle. Here are some tips on the best educational toys for
				kids 5-7. Educational toys that help children the best help them
				harness their creative side such as the first construction lego set.
				For last few years, since education system is enhancing; we are
				introducing large collection of these modern toys. They contain
				various types including electronic toy gadgets, roll playing,
				construction blocks, board games and even outdoor gadgets.
			</p>
		</div>
		<div class="col-xs-1"></div>
		<div class="col-sm-5">
			<video style="width: 100%; height: auto" controls autoplay loop >
				<source src="resources/videos/EducationalToys.webm" type="video/webm">
			</video>
		</div>
	</div>
</body>
</html>
<%@include file="footer.jsp"%>