<%@ taglib prefix="f" uri="/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="mobile" tagdir="/WEB-INF/tags/mobile" %>


<tiles:importAttribute name="result" />

<%-- ${f:toString(result.item.colour)} --%>
<%-- <br/><b>${result.item.postcode}</b> --%>

<div style="float:left; margin-right:4px; width:46%; overflow: hidden; " >
	<div style="width:100px; font-weight: bold;">${result.item.carMake}</div>
	<div style="width:100px; font-weight: normal;"> ${result.item}</div>
	<span style="float:left; margin-right:10px">${f:toString(result.item.year)}</span>

	<c:set var="score" value="${f:forwardsScore(result,'Good Price Match')}"/>
</div>

<div style="float:left; margin: 0 2px; width:21%" >
		<mobile:distance result="${result}" />
		<div class="round" style="width:75px; background-color: ${f:floatToCssRGBColorSat(score,0.26)}">&pound;${f:toString(result.item.price)}</div>
		<c:set var="score" value="${f:forwardsScore(result,'Power')}"/>
		<div style="width:75px; background-color: ${f:floatToCssRGBColorSat(score,0.26)};" 
			class="round">${f:toString(result.item.horsePower)} hp</div>
</div>


<span class="overall-score-circle" style="background-color: ${f:toCssRGBColor(result.score)}"><span class="score-val">
${f:toPercent(result.score)}</span></span>
<span></span>

