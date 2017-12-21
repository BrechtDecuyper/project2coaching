<jsp:include page="header.jsp">
	<jsp:param value="ImageMap Resizeable" name="title" />
	<jsp:param value="current" name="home" />
</jsp:include>

<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/jquery.maphilight.js"></script>
<script type="text/javascript" src="js/imageMapResizer.js"></script>


<main>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<img id="wolfImage" src="images/wolf.jpg" width="519" height="525"
				usemap="#wolfMap" class="wolfImage" />
			<map name="wolfMap" id="wolfMap">
				<area shape="poly" class="darkbrown"
					coords="66,174,57,308,88,291,94,239,127,199,219,271,232,439,283,439,294,273,388,199,426,240,431,287,459,304,451,172,291,79,233,79" />
				<area shape="poly" class="orange"
					coords="412,339,378,322,298,370,293,443,302,460,261,487,278,488,286,489,292,491,296,493,332,466,339,382" />
				<area shape="poly" class="orange"
					coords="105,339,133,321,217,369,223,443,213,460,255,487,240,488,234,489,230,490,220,494,187,470,180,383" />
				<area shape="poly" class="dark"
					coords="345,425,349,387,462,320,487,343" />
				<area shape="poly" class="dark"
					coords="32,347,54,320,171,389,174,428" />
				<area shape="poly" class="brown"
					coords="67,163,100,144,102,54,107,54,109,51,188,94,220,76,98,16,77,28" />
				<area shape="poly" class="brown"
					coords="305,76,337,95,411,52,413,55,416,55,421,143,451,161,444,34,423,17" />
			</map>
		</div>
	</div>
</div>
</main>

<script type="text/javascript">
	$(function() {
		var data = {};
		$('.wolfImage').maphilight();
		data.alwaysOn = true;
		data.fillColor = '8c3d20';
		data.fillOpacity = '0.6';
		$('.brown').data('maphilight', data).trigger('alwaysOn.maphilight');
	});

	$(function() {
		var data = {};
		$('.wolfImage').maphilight();
		data.alwaysOn = true;
		data.fillColor = '30170e';
		data.fillOpacity = '0.6';
		$('.darkbrown').data('maphilight', data).trigger('alwaysOn.maphilight');
	});

	$(function() {
		var data = {};
		$('.wolfImage').maphilight();
		data.alwaysOn = true;
		data.fillColor = 'ff7b00';
		data.fillOpacity = '0.6';
		$('.orange').data('maphilight', data).trigger('alwaysOn.maphilight');
	});

	$(function() {
		var data = {};
		$('.wolfImage').maphilight();
		data.alwaysOn = false;
		data.fillColor = '000000';
		data.fillOpacity = '1';
		$('.dark').data('maphilight', data).trigger('alwaysOn.maphilight');
	});
</script>


<jsp:include page="footer.jsp" />
