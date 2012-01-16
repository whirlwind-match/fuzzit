<jsp:directive.include file="/WEB-INF/includes/includes.jsp"/>
<%@ taglib prefix="sample" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mobile" tagdir="/WEB-INF/tags/mobile" %>


<form:form action="search" method="post" >

		<fieldset data-role="controlgroup" data-type="horizontal">
			<mobile:edit-input attrName="postcode" popupHelp="Any clue where? (Try the first part of a UK postcode e.g. SE1)" />
		</fieldset>

		<fieldset data-role="controlgroup" data-type="vertical">
			<form:radiobuttons path="establishmentType" items="${establishmentTypes}" />
		</fieldset>

		<fieldset data-role="controlgroup" data-type="horizontal">
			<legend>Meal Types</legend>
			<form:checkboxes id="mealTypes" path="mealTypes" items="${mealTypes}"/> <form:errors path="mealTypes"/>
		</fieldset>

	<input class="fuzzit-btn" type="submit" value="fuzzit"/>
</form:form>

