<!DOCTYPE html> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
<head>
	<title>fuzzit</title> 
	<tiles:insertAttribute name="headCommonContent" />
	<script type="text/javascript">
		$(document).bind('mobileinit',function(){
		   $.mobile.selectmenu.prototype.options.nativeMenu = false;
		   $.mobile.ajaxEnabled = false;
		});
	</script>
</head>

<body> 

	<div id="main-page" data-role="page" class="type-interior">

	
		<div data-role="content">
			<tiles:insertAttribute name="content" />
		</div><!-- /content -->
	</div>	
</body>
</html>
