<jsp:directive.include file="/WEB-INF/includes/includes.jsp"/>
<%@ taglib prefix="sample" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mobile" tagdir="/WEB-INF/tags/mobile" %>

<form:form action="search" method="post" >

		<fieldset data-role="controlgroup" data-type="horizontal">
			<mobile:edit-input attrName="postcode" popupHelp="Where? (Short UK postcode e.g. SE1)"  />
		</fieldset>

		<fieldset data-role="fieldcontain" data-type="horizontal">
<%-- 			<mobile:edit-input attrName="price" popupHelp="Target price..." /> --%>
			<label for="price">Price</label>
   			<input type="range" name="price" id="price" value="9000" min="100" max="90000"  />
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

