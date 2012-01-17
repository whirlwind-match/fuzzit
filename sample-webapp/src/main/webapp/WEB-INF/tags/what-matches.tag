<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/functions" %>

<%@ tag body-content="empty" %> 
<%@ attribute name="result" type="java.lang.Object" required="true" %>
<%-- <%@ attribute name="popupHelp" required="true" %> --%>


	    	<div style="padding: 10px 0px">
<!-- 	    	<h3>What matches?</h3> -->
			    <c:forEach items="${result.score.scorerAttrNames}" var="match">
			    	<c:set var="fwd" value="${f:forwardsScore(result,match)}"/>
			    	<c:choose>
				    	<c:when test="${match eq 'Distance'}">
<!-- 			    	<div style="padding-left: 10px"> -->
<%-- 	    				<span style="float:right; width: 50px; text-align:center">${f:round(fwd)}</span> --%>
<%--     					${match} (miles):  --%>
<!--     				</div> -->
				    	</c:when>
				    	<c:otherwise>
			    	<div style="padding-left: 0px; padding-top: 1px;">
			    		<span class="score" style="background-color: ${f:floatToCssRGBColorSat(fwd,0.86)}">${f:round(fwd * 100.1)}%</span>
			    		${match}: 
			    	</div>
				    	</c:otherwise>
			    	</c:choose>
			    </c:forEach> 
		    </div>

