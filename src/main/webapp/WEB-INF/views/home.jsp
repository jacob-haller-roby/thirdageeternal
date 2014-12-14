<%-- <?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>This is Home page. It's available for all users.<br/>
<a href="${pageContext.request.contextPath}/sec/moderation.html">Moderation page</a><br/>
<a href="${pageContext.request.contextPath}/admin/first.html">First Admin page</a><br/>
<a href="${pageContext.request.contextPath}/admin/second.html">Second Admin page</a><br/>
<a href="${pageContext.request.contextPath}/ember.html">Ember</a><br/>
</p>
<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</body>
</html> --%>

<!DOCTYPE html>
<html>
<head>
<link rel="styleSheet" type="text/css" href="<%=request.getContextPath()%>/resources/includes/bootstrap.css">
<link rel="styleSheet" type="text/css" href="<%=request.getContextPath()%>/resources/includes/custom.css">
<meta charset="utf-8">
<title>The Third Age</title>
</head>
<body>


  <script type="text/x-handlebars">
<div id="background">
<div id="wrap">
<div class="col-lg-8 col-sm-12 col-md-10 col-centered">
	{{outlet}}
</div>
</div>
	<div id="push"></div>
<div  id="footer" >
  <div class="col-lg-8 col-sm-12 col-md-10 col-centered container">
  <div class="col-sm-offset-3 col-sm-6 col-centered">
  <div class="row col-centered">
    <p class="text-muted footer-text">Copyright 20142</p>
    <p class="text-muted footer-text">Contact Us</p>
    <img src="<%=request.getContextPath()%>/resources/images/real_job_logo.png"/>
    </div>
   </div>
  </div>
</div>	
</div>
  </script>

  
  <script type="text/x-handlebars" data-template-name="dash">
		<jsp:include page="/WEB-INF/views/templates/dash.jsp"></jsp:include></script>
		 <script type="text/x-handlebars" data-template-name="community">
		<jsp:include page="/WEB-INF/views/templates/community.jsp"></jsp:include></script>
		<script type="text/x-handlebars" data-template-name="blog">
		<jsp:include page="/WEB-INF/views/templates/blog.jsp"></jsp:include></script>
		<script type="text/x-handlebars" data-template-name="game">
		<jsp:include page="/WEB-INF/views/templates/game.jsp"></jsp:include></script>
		
		
		<script type="text/x-handlebars" data-template-name="feed">
		<jsp:include page="/WEB-INF/views/templates/blog/feed.jsp"></jsp:include></script>
		<script type="text/x-handlebars" data-template-name="article">
		<jsp:include page="/WEB-INF/views/templates/blog/article.jsp"></jsp:include></script>
		<script type="text/x-handlebars" data-template-name="write">
		<jsp:include page="/WEB-INF/views/templates/blog/write.jsp"></jsp:include></script>
		<script type="text/x-handlebars" data-template-name="blog_submit">
		<jsp:include page="/WEB-INF/views/templates/blog/writeSuccess.jsp"></jsp:include></script>
		
		
		<script type="text/x-handlebars" data-template-name="mad">
		<jsp:include page="/WEB-INF/views/static/metaphoreanddesign.jsp"></jsp:include></script>
		
		<script type="text/x-handlebars" data-template-name="rol">
		<jsp:include page="/WEB-INF/views/static/RolesOfLanguage.jsp"></jsp:include></script>
		
		
		<script type="text/x-handlebars" data-template-name="map">
		<jsp:include page="/WEB-INF/views/static/map.jsp"></jsp:include></script>
		<script type="text/x-handlebars" data-template-name="factions/aristocracy">
		<jsp:include page="/WEB-INF/views/static/aristocracy.jsp"></jsp:include></script>
		
	<script type="text/x-handlebars" data-template-name="_loginLink">
		<jsp:include page="/WEB-INF/views/partial/loginLink.jsp"></jsp:include></script>
		<script type="text/x-handlebars" data-template-name="_post">
		<jsp:include page="/WEB-INF/views/partial/post.jsp"></jsp:include></script>		
		
  <script src="<%=request.getContextPath()%>/resources/includes/jquery-1.10.2.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/resources/includes/handlebars-1.1.2.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/resources/includes/ember.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/resources/includes/bootstrap.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/resources/includes/custom.js" type="text/javascript"></script>
  
  	<script src="<%=request.getContextPath()%>/resources/ember/bootstrap/App.js" type="text/javascript"></script>
  	<script src="<%=request.getContextPath()%>/resources/ember/bootstrap/CustomEmber.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/ember/bootstrap/Map.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/ember/route/indexRoute.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/ember/route/blogRoute.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/ember/route/gameRoute.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/ember/objects/blog.js" type="text/javascript"></script>		
	<script src="<%=request.getContextPath()%>/resources/ember/controller/blogController.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/includes/helpers.js" type="text/javascript"></script>
	<script src="resources/includes/dynamicmap.js" type="text/javascript"></script>
	
	

</body>
</html>