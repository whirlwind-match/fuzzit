<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
<!--
	div.ui-grid-b img { height: 100px; width: 100px;}
-->
</style>

<div class="ui-grid-b">
	<div class="ui-block-a"><a data-ajax="false" href="<c:url value="/mobile/autos/search"/>"><img alt="Autos" src="../static/auto.png"></a></div>
	<div class="ui-block-b"><a data-ajax="false" href="<c:url value="/mobile/people/search"/>"><img alt="People" src="../static/people.png"></a></div>
	<div class="ui-block-c"><a data-ajax="false" href="<c:url value="/mobile/autos/search"/>"><img alt="Reuse" src="../static/reuse.png"></a></div>
	<div class="ui-block-a"><a data-ajax="false" href="<c:url value="/mobile/cafes/search"/>">Food joints</a></div>
	<div class="ui-block-b"><a data-ajax="false" href="<c:url value="/mobile/people/search"/>"><img alt="Flights" src="../static/flights.png"></a></div>
</div><!-- /grid-b -->
	


</ul>
