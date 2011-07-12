<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/functions" %>

<html>
<head>
	<title>${heading}</title>
</head>
<body>
<h1>
	${heading}
</h1>

	<ul>
		<li><a href="createMatt">create Matt</a></li>
		<li><a href="createMorePeople">create others</a></li>
		<li><a href="matches">Do a fuzzy query</a></li>
	</ul>


    <c:forEach items="${results}" var="result">
	    <div style="float:left;border: solid gray 1px; width:200px; margin: 2px; padding: 5px">
	    	<h3>${result.item}</h3>
	    	<a href="?name=${result.item}">search</a>
		    <div style="margin: 2px; padding: 2px">Score:
		    	<div style="width: 100px; text-align:center; background-color: ${f:toCssRGBColor(result.score)}">
		    	${f:toPercent(result.score)}%</div>
		    	</div>
		    	<div style="padding: 15px 2px">Scores:
				    <c:forEach items="${result.score.scorerAttrNames}" var="match">
				    	<c:set var="fwd" value="${f:forwardsScore(result,match)}"/>
				    	<div>${match}: ${f:round(fwd * 100.1)}%</div>
				    </c:forEach> 
		    	<div style="padding: 15px 2px">Attributes:
				    <c:forEach items="${result.item.attributes}" var="item">
				    	<div>${item.key}: ${f:toString(item.value)}</div>
				    </c:forEach> 
		    	</div>
		    </div>
	    </div>
    </c:forEach> 

</body>
</html>