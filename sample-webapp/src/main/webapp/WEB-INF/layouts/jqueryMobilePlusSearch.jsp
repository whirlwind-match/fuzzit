<!DOCTYPE html> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>

<!-- <script src="http://1.2.3.4/bmi-int-js/bmi.js" language="javascript"></script>  -->
<script src="/static/jqm/bmi.js" language="javascript"></script>
	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<title>fuzzit</title> 
<!-- 	<link rel="stylesheet"  href="//code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css" />   -->
<!-- 	<script src="//code.jquery.com/jquery-1.6.4.js"></script> -->
<!-- 	<script src="//code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"></script> -->
	<link rel="stylesheet"  href="<c:url value="/static/jqm/jquery.mobile-1.0.min.css"/>" />  
	<link rel="stylesheet" href="<c:url value="/static/css/themes/fuzzydb.css"/>">
	<link rel="stylesheet" href="<c:url value="/static/css/site.css"/>" />
	<script src="<c:url value="/static/jqm/jquery-1.6.4.js"/>"></script>
	<script type="text/javascript">
		function success(position) {
		  var s = document.querySelector('#postcode');
		  s.value = "{" + position.coords.latitude +"," + position.coords.longitude + "}"
// 			alert( "you're at: " + position.coords.latitude +"," + position.coords.longitude );
		};

		function error(msg) {
// 	 			alert( 'geolocation not supported: ' + msg );
		};

		function getLocation() {
			if (navigator.geolocation) {
			  navigator.geolocation.getCurrentPosition(success, error);
			} else {
			  error('not supported');
			}
		};

		$(document).bind('mobileinit',function(){
		   $.mobile.selectmenu.prototype.options.nativeMenu = false;
		   $.mobile.ajaxEnabled = false;
			$( '#search-page' ).live( 'pagecreate',function(event){
				getLocation();
			});
		});
	</script>
	<script src="<c:url value="/static/jqm/jquery.mobile-1.0.min.js"/>"></script>
</head> 
<body> 

	<div id="main-page" data-role="page" class="type-interior">

		<div data-role="header" data-position="fixed" data-theme="a">
			<h1><img src="<c:url value="/static/fuzzit/fuzzit-word.png"/>" height=40px alt="fuzzit" />
			</h1>
			<a href="<c:url value="/mobile/home"/>" data-icon="home" data-iconpos="notext" data-direction="reverse" class="ui-btn-left jqm-home">Home</a>
			<a href="#search-page" data-role="button" data-rel="page">Search</a> 
	
		</div><!-- /header -->
	
		<div data-role="content">
			<tiles:insertAttribute name="content" />
		</div><!-- /content -->
	
		<div data-role="footer" class="footer-docs" data-theme="c">
<!-- 				<p>&copy; 2011-2012 Whirlwind Match Ltd</p> -->
		</div>
	</div><!-- /page -->

	<div id="search-page" data-role="page" class="type-interior">
<!-- 		<div data-role="header" data-position="fixed" data-theme="c"> -->
			<h3 style="text-align: center;">Search</h3>
			<div data-role="content">
				<tiles:insertAttribute name="searchContent" defaultValue=""/>
			</div>
<!-- 		</div> -->
	</div>

	</body>
	</html>
<script language="javascript"><!--
bmi_SafeAddOnload(bmi_load,"bmi_orig_img",0);//-->
</script>