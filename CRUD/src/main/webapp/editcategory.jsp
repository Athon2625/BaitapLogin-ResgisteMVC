<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Category</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5" style="max-width: 600px;">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">✏️ Edit Category</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/admin/category/edit" method="post">
                <!-- Hidden ID field -->
                <input type="hidden" name="id" value="${category.id}"/>

                <!-- Category Name -->
                <div class="mb-3">
                    <label for="cateName" class="form-label">Category Name</label>
                    <input type="text" id="cateName" name="cateName"
                           class="form-control" required
                           value="${category.cateName}"/>
                </div>

                <!-- Icon -->
                <div class="mb-3">
                    <label for="icons" class="form-label">Icon</label>
                    <input type="text" id="icons" name="icons"
                           class="form-control"
                           value="${category.icons}"/>
                    <div class="form-text">Nhập tên file ảnh (ví dụ: <code>land.png</code>) hoặc link icon.</div>
                </div>

                <!-- Preview Icon -->
                <c:if test="${not empty category.icons}">
                    <div class="mb-3">
                        <label class="form-label">Preview</label><br>
                        <img src="${pageContext.request.contextPath}/images/${category.icons}"
                             alt="icon" class="border rounded" width="60" height="60">
                    </div>
                </c:if>

                <!-- Buttons -->
                <div class="d-flex justify-content-between">
                    <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">
                        ⬅ Back to List
                    </a>
                    <button type="submit" class="btn btn-success">💾 Save Changes</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
