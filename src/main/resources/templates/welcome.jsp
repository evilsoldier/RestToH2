<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<title>Hello World</title>
</head>
<body>
	Hello World!
	<br />
	<%
		out.println("Your IP address is " + request.getRemoteAddr());
	%>
</body>
</html>