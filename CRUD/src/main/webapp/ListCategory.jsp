<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category List</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Category List</h2>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>#</th>
            <th>Category ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cate" items="${cateList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${cate.id}</td>
                <td>${cate.name}</td>
                <td>${cate.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.id}"
                       class="btn btn-sm btn-primary">Edit</a>
                    <a href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.id}"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Are you sure you want to delete this category?');">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-success">Add New Category</a>
</div>
</body>
</html>
