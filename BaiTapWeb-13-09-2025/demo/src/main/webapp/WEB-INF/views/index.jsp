<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Welcome to Admin Dashboard</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/admin/categories">Manage Categories</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/users">Manage Users</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/videos">Manage Videos</a></li>
    </ul>
</body>
</html>
