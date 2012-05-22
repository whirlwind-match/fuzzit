<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
<!--
	div.ui-grid-a img { height: 100px; width: 100px; border: 1px green solid;
		padding: 18px;
		margin: 8px;
		border-radius: 10px; 
		box-shadow: 4px 4px 8px 0px #AAA;
	}
	
	div.ui-grid-a {
	padding-left: 25%;
	}
-->
</style>

<div class="ui-grid-a">
	<div class="ui-block-a"><a data-ajax="false" href="<c:url value="/mobile/autos/search"/>"><img alt="Autos" src="../static/clipart/auto.png"></a></div>
	<div class="ui-block-a"><a data-ajax="false" href="<c:url value="/mobile/people/search"/>"><img alt="People" src="../static/clipart/people.png"></a></div>
	<div class="ui-block-a"><a data-ajax="false" href="<c:url value="/mobile/cafes/search"/>"><img alt="Dining Out" src="../static/clipart/food.png"></a></div>
<%-- 	<div class="ui-block-b"><a data-ajax="false" href="<c:url value="/mobile/autos/search"/>"><img alt="Reuse" src="../static/clipart/reuse.png"></a></div> --%>
<%-- 	<div class="ui-block-a"><a data-ajax="false" href="<c:url value="/mobile/people/search"/>"><img alt="Flights" src="../static/clipart/flights.png"></a></div> --%>
</div><!-- /grid-a -->
