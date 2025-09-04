<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Category</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Edit Category</h2>

    <form action="${pageContext.request.contextPath}/admin/category/edit" method="post" class="card p-4 shadow-sm">
        <!-- Hidden ID field -->
        <input type="hidden" name="id" value="${category.id}"/>

        <div class="mb-3">
            <label for="cate_name" class="form-label">Category Name</label>
            <input type="text" id="cate_name" name="cate_name"
                   class="form-control" required
                   value="${category.name}"/>
        </div>

        <div class="mb-3">
            <label for="icons" class="form-label">Icon</label>
            <input type="text" id="icons" name="icons"
                   class="form-control"
                   value="${category.icon}"/>
            <div class="form-text">You can enter an icon URL or class name (e.g., FontAwesome).</div>
        </div>

        <div class="d-flex justify-content-between">
            <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">
                Cancel
            </a>
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>
</div>
</body>
</html>
