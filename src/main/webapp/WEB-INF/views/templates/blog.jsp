<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>
<div class="col-sm-2 sidebar">
	<span class="list-group"> 
		<a {{action	developer}} class="list-group-item">Developer Blog</a> 
		<a {{action	news}} class="list-group-item">News</a>
		<security:authorize access="isAuthenticated()">
			<a {{action write}} class="list-group-item">Write</a>
		</security:authorize>
	</span>
</div>
<div class="col-sm-10">{{outlet}}</div>
