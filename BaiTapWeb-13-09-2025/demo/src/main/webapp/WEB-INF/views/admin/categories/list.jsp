<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<h2>Category List</h2>

<form action="${pageContext.request.contextPath}/admin/categories/search" method="get">
    <input type="text" name="name" placeholder="Search by category name"/>
    <button type="submit">Search</button>
</form>

<a href="${pageContext.request.contextPath}/admin/categories/add">Add New Category</a>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Category Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="cat" items="${categories}">
        <tr>
            <td>${cat.id}</td>
            <td>${cat.categoryName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/categories/edit/${cat.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/categories/delete/${cat.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
