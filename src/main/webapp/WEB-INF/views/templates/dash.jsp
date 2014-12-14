
<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>
<div>

<img src="<%=request.getContextPath()%>/resources/images/Banner<%=(int)(Math.floor(Math.random() * 2) + 1)%>.jpg" 
class="fit-to-div top-border"/>

</div>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><img  src="<%=request.getContextPath()%>/resources/images/third_age.png"/></a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="navbar-psuedo-button title-font" >{{#link-to 'game'}} Game Information {{/link-to}}</li>
				<li class="navbar-psuedo-button title-font">{{#link-to 'blog'}} Developer Blog {{/link-to}}</li>
				<li class="navbar-psuedo-button title-font"><a href="http://www.kickstarter.com">Purchase</a></li>
			</ul>
			<%--
			<div class="pull-right">
				<security:authorize access="isAuthenticated()">
					<%-- <li class="btn-group">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							<security:authentication
								property="principal.username" /> <span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>{{#link-to 'profile'}} Profile {{/link-to}}</li>
							<li>{{#link-to 'decks'}} Decks {{/link-to}}</li>
							<li>{{#link-to 'settings'}} Settings {{/link-to}}</li>
						</ul>
					</li> 
					<a><security:authentication
								property="principal.username" /></a>
					<a href="<c:url value="j_spring_security_logout" />">
					<button type="button" class="btn btn-default navbar-btn">Logout</button>
					</a>
				</security:authorize>
				<security:authorize access="isAnonymous()">
					<a data-toggle="modal"
						data-target="#login-modal">
					<button type="button" class="btn btn-default navbar-btn">Sign in</button>
					</a>
					
					<a data-toggle="modal"
						data-target="#new-user-modal">
						<button type="button" class="btn btn-default navbar-btn">Create Account</button>
						</a>
				</security:authorize>
			</div>
			 --%>

		</div>
	</div>
</nav>
{{outlet}}




<div id="login-modal" class="modal fade bs-example-modal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<jsp:include page="/WEB-INF/views/login-form.jsp"></jsp:include>
		</div>
	</div>
</div>

<div id="new-user-modal" class="modal fade bs-example-modal"
	tabindex="-2">
	<div class="modal-dialog">
		<div class="modal-content">
			<jsp:include page="/WEB-INF/views/new-user.jsp"></jsp:include>
		</div>
	</div>
</div>


