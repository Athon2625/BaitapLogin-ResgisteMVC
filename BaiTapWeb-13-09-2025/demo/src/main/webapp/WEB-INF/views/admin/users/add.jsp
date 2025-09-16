<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h2>Add User</h2>

<form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/admin/users/saveOrUpdate">

    <label>Username:</label>
    <form:input path="username"/><br/><br/>

    <label>Email:</label>
    <form:input path="email"/><br/><br/>

    <label>Password:</label>
    <form:password path="password"/><br/><br/>

    <label>Role:</label>
    <form:input path="role"/><br/><br/>

    <button type="submit">Save</button>
</form:form>

<a href="${pageContext.request.contextPath}/admin/users">Back to list</a>
</body>
</html>
