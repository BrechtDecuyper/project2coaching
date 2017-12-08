<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
	<jsp:param value="Data Overview" name="title" />
	<jsp:param value="current" name="dataOverview"/>
</jsp:include>

<main>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" align="center">
			<h1>My Music</h1>
			<c:forEach var="info" items="${data}">
				<p><a href="${info.url}" target="_blank">
					${info.artist} - ${info.title}
				</a></p>
			</c:forEach>
		</div>
	</div>
</div>
</main>

<jsp:include page="footer.jsp"/> 