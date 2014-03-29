
<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Third Age: Eternal</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li>{{#link-to 'game'}} Game {{/link-to}}</li>
				<li>{{#link-to 'blog'}} Blog {{/link-to}}</li>
				<li class="disabled"><a href="http://www.kickstarter.com">Purchase</a></li>
			</ul>
			<ul class="nav navbar-nav pull-right">
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
					</li> --%>
					<li><a><security:authentication
								property="principal.username" /></a></li>
					<li><a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
				</security:authorize>
				<security:authorize access="isAnonymous()">
					<li class="pull-right"><a data-toggle="modal"
						data-target="#login-modal">Login or Create an Account</a></li>
					<li class="pull-right"><a data-toggle="modal"
						data-target="#new-user-modal">Login or Create an Account</a></li>
				</security:authorize>
			</ul>

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