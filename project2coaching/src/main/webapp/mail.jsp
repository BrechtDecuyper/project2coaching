<jsp:include page="header.jsp">
	<jsp:param value="Mail" name="title" />
	<jsp:param value="current" name="mail"/>
</jsp:include>

<main>
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-8 col-lg-6">
		<h1>Have a nice day</h1>
		<form method="POST" action="Controller?action=sendMail">
			<legend>We send YOU a mail!</legend>
			<div class="form-group">
				<label for="receiver">Email: </label>
				<input type="text" class="form-control" id="receiver" name="receiver">
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Send Mail">
			</div>
		</form>
	</div>
</div>
</main>

<jsp:include page="footer.jsp"/> 