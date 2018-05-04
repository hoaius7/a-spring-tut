<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Security Demo Home Page</title>	
</head>

<body>
	<h2>Security Demo Home Page</h2>
	<hr>
	
	<p>
	Welcome to Security Demo Home Page
	</p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>