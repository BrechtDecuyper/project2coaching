<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
	<jsp:param value="Image Overview" name="title" />
	<jsp:param value="current" name="imageOverview"/>
</jsp:include>

<main>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" align="center">
			<h1>My Images</h1>
			<c:forEach var="image" items="${images}">
				<a href="Controller?action=imageDownload&fileName=${image}">
					<img class="col-xs-10 col-sm-6 col-md-4 col-lg-3" alt="${image}" src="Controller?action=imageGet&fileName=${image}">
				</a>
			</c:forEach>
		</div>
	</div>
</div>
</main>

<jsp:include page="footer.jsp"/> 