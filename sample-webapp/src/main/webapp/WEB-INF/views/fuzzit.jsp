<jsp:directive.include file="/WEB-INF/includes/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/includes/header.jsp"/>

<div style="margin-top:50px">
  <div style="margin:auto; width:90%; max-width: 600px; padding:0px"> 
  
	<a href="mobile/grid">
	<img style="display:block; width:100%;" alt="fuzzit fuzzy|mobile|search" 
		src="<spring:url value="/static/fuzzit/fuzzit-logo.png" htmlEscape="true" />"/>
	</a>
	<div>
	<div style="float:left; width:27%; padding-top:10px">
		<a class="big-link" style="float:right;" href="mobile/grid">App</a>
	</div>
	<div style="float:right; width:35%;  padding-top:10px">
		<a class="big-link" style="float:left;" href="public/about">About</a>
	</div>
	</div>
  </div>
</div>

<jsp:directive.include file="/WEB-INF/includes/footer.jsp"/>