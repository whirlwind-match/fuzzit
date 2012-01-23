<jsp:directive.include file="/WEB-INF/includes/includes.jsp"/>

	
	<h3>You'll need to login to visit that page</h3>

    <%-- this form-login-page form is also used as the
         form-error-page to ask for a login again.
         --%>
	<c:if test="${param.error eq 'bad_credentials'}">
 		<div class="error">
 			Bad user id or password<br>
 			Please try again or <a href="<c:url value="/signup" />">sign up</a>.
<!-- 	        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>. -->
		</div>
 	</c:if>
	<c:if test="${param.error eq 'multiple_users'}">
 		<div class="error">
 			Multiple local accounts are connected to the provider account.
 			Try again with a different provider or with your username and password.
 		</div>
 	</c:if>
    <c:if test="${not empty param.login_error}">
      <font color="red">Your login attempt was not successful, try again.<br/>
        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
	<form name='f' action='../login/authenticate'
		method='POST'>
    	<div>
            <label for="j_username">Email:</label>
            <input id="j_username" type='text' name='j_username' style='width:150px' 
            	<c:if test="${not empty signinErrorMessage}">value="${SPRING_SECURITY_LAST_USERNAME}"</c:if> />
        </div>
        <br/>
        <div>
            <label for="j_password">Password:</label>
            <input id="j_password" type='password' name='j_password' style="width:150px" />
        </div>
        <br/>
        <div class="submit">
            <input id="proceed" type="submit" value="Submit"/>
        </div>
	</form>
