<jsp:directive.include file="/WEB-INF/includes/includes.jsp"/>
<%@ taglib prefix="sample" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mobile" tagdir="/WEB-INF/tags/mobile" %>


<form:form action="search" method="post" >

		<fieldset data-role="controlgroup" data-type="horizontal">
			<mobile:edit-input attrName="postcode" popupHelp="Any clue where? (Try the first part of a UK postcode e.g. SE1)" />
		</fieldset>

		<fieldset data-role="controlgroup" data-type="horizontal">
			<mobile:edit-input attrName="age" popupHelp="Enter their rough age..." />
		</fieldset>
		
		<fieldset data-role="">
			<form:select id="newspapers" path="newspapers" >
				<option>Newspapers</option>
				<form:options items="${newspapers}"/>
			</form:select>
		</fieldset>
		
	<input class="fuzzit-btn" type="submit" value="fuzzit"/>
</form:form>

