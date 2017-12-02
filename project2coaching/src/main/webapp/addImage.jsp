<jsp:include page="header.jsp">
	<jsp:param value="Add Image" name="title" />
	<jsp:param value="current" name="imageAdd" />
</jsp:include>

<main>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-6">
			<h1>Add your image here!</h1>
			<form method="POST" action="Controller?action=imageUpload"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="file">File: </label> <input type="file"
						class="form-control" id="file" name="file"
						accept=".jpg,.png,.jpeg">
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Add Image">
				</div>
			</form>
		</div>
	</div>
</div>
</main>

<jsp:include page="footer.jsp" />
