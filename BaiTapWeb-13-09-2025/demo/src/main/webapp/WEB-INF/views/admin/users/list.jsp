<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>User List</h2>

<!-- Nút thêm mới -->
<a href="${pageContext.request.contextPath}/admin/users/add">Add New User</a>
<br/><br/>

<!-- Form tìm kiếm -->
<form action="${pageContext.request.contextPath}/admin/users/search" method="get">
    <input type="text" name="name" placeholder="Search by username or email" value="${param.name}"/>
    <input type="submit" value="Search"/>
</form>
<br/>

<!-- Bảng danh sách user -->
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/users/edit/${user.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/users/delete/${user.id}"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
