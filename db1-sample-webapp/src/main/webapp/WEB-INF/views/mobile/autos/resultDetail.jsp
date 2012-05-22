<%@ taglib prefix="f" uri="/functions" %>
<%@ taglib prefix="sample" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:importAttribute name="result" />


	<div data-role="collapsible-set" data-theme="c">
		<!-- Forward scores -->
		<sample:what-matches result="${result}"/>

		<div data-role="collapsible" style="padding: 11px 2px">
			<h3>
	   			Options
   			</h3>
		   	<div  style="font-size: 100%; padding-left: 0px"><br/>${f:toString(result.item.options)}</div>
		</div>
		<div data-role="collapsible" style="padding: 11px 2px">
			<h3>Details</h3>
   			<a  data-ajax="false" href="?ref=${result.item.ref}&amp;style=${style}">
	    	<div class="attribute">Location: <b>${result.item.postcode}</b></div>
	    	<div class="attribute">Colour: <b>${f:toString(result.item.colour)}</b></div>
	    	<div class="attribute">Combined (mpg): <b>${f:toString(result.item.mpgCombined)}</b></div>
	    	<div class="attribute">Emissions (gCO2/km): <b>${f:toString(result.item.co2emissions)}</b></div>
	    	
<%-- 	    	<div class="attribute">Power (bhp): <b>${f:toString(result.item.horsePower)}</b></div> --%>
<%-- 	    	<div class="attribute">Distance:  ${f:toString(f:forwardsScore(result,'Distance'))} miles</div> --%>
	    	</a>
	   	</div>
   	</div>

