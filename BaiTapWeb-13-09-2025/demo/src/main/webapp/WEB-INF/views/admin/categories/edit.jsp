<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<h2>Edit Category</h2>

<form:form method="post" modelAttribute="category" action="${pageContext.request.contextPath}/admin/categories/saveOrUpdate">

    <form:hidden path="id"/>

    <label>Category Name:</label>
    <form:input path="categoryName" /><br/><br/>

    <button type="submit">Update</button>
</form:form>

<a href="${pageContext.request.contextPath}/admin/categories">Back to list</a>
</body>
</html>
