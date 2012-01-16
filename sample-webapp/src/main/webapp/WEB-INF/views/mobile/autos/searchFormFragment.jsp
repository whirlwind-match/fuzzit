<jsp:directive.include file="/WEB-INF/includes/includes.jsp"/>
<%@ taglib prefix="sample" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mobile" tagdir="/WEB-INF/tags/mobile" %>


<form:form action="search" method="post" >

		<fieldset data-role="controlgroup" data-type="horizontal">
			<mobile:edit-input attrName="postcode" popupHelp="Where? (Try the first part of a UK postcode e.g. SE1)" />
		</fieldset>

		<fieldset data-role="controlgroup" data-type="horizontal">
			<mobile:edit-input attrName="price" popupHelp="Target price..." />
		</fieldset>


		<fieldset data-role="">
			<form:select id="options" path="options" >
				<option>Options</option>
				<form:options items="${options}"/>
			</form:select>
		</fieldset>

		<fieldset data-role="">
			<form:select id="colour" path="colour" >
				<form:option value="">Colour</form:option>
				<form:options items="${colours}"/>
			</form:select>
		</fieldset>

<!-- 		<legend>Make:</legend> -->
<%-- 		<td><form:select path="carMake"> --%>
<%-- 			<form:option value="" /> --%>
<%-- 			<form:options items="${carMakes}"/>  --%>
<%-- 		</form:select><form:errors path="carMake"/> --%>
	<input class="fuzzit-btn" type="submit" value="fuzzit"/>
</form:form>

