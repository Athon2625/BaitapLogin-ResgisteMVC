<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Add New Category</h2>

    <form action="${pageContext.request.contextPath}/admin/category/add"
          method="post" class="card p-4 shadow-sm">

        <div class="mb-3">
            <label for="cate_name" class="form-label">Category Name</label>
            <input type="text" id="cate_name" name="cate_name"
                   class="form-control" required/>
        </div>

        <div class="mb-3">
            <label for="icons" class="form-label">Icon</label>
            <input type="text" id="icons" name="icons"
                   class="form-control"/>
            <div class="form-text">Enter an icon URL or CSS class (e.g., FontAwesome).</div>
        </div>

        <div class="d-flex justify-content-between">
            <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">
                Cancel
            </a>
            <button type="submit" class="btn btn-success">Add Category</button>
        </div>
    </form>
</div>
</body>
</html>
