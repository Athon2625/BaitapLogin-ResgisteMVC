<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h2>Edit User</h2>

<form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/admin/users/saveOrUpdate">

    <form:hidden path="id"/>

    <label>Username:</label>
    <form:input path="username"/><br/><br/>

    <label>Email:</label>
    <form:input path="email"/><br/><br/>

    <label>Password:</label>
    <form:password path="password"/><br/><br/>

    <label>Role:</label>
    <form:input path="role"/><br/><br/>

    <button type="submit">Update</button>
</form:form>

<a href="${pageContext.request.contextPath}/admin/users">Back to list</a>
</body>
</html>
