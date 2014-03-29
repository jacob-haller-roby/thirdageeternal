<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>
<security:authorize access="isAuthenticated()">
<security:authentication property="principal.username" /> &nbsp;
<a href="<c:url value="j_spring_security_logout" />" >Logout</a><br/>
</security:authorize>
<security:authorize access="isAnonymous()">
<a href="${pageContext.request.contextPath}/user-login">Login or Create an Account</a><br/>
</security:authorize>