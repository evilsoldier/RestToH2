<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    <br>Hello From Person jsp!
    <br>PersonId: ${person.id}
    <br>FirstName: ${person.firstName}
    <br>LastName: ${person.lastName}
</body>
</html>