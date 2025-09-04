<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Category</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">List Category</h2>

    <!-- Nút Add Category -->
    <div class="mb-3">
        <a href="${pageContext.request.contextPath}/admin/category/add"
           class="btn btn-success">
            + Add Category
        </a>
    </div>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Name</th>
            <th>Icon</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cate" items="${listCategory}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${cate.id}</td>
                <td>${cate.cateName}</td>
                <td>
                    <img src="images/${cate.icons}" alt="${cate.cateName}" width="40">
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.id}"
                       class="btn btn-sm btn-primary">Edit</a>
                    <a href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.id}"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Bạn có chắc muốn xóa category này?');">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
