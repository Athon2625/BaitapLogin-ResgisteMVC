<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Video</title>
</head>
<body>
<h2>Edit Video</h2>

<form:form method="post" modelAttribute="video" action="${pageContext.request.contextPath}/admin/videos/saveOrUpdate">

    <form:hidden path="id"/>

    <label>Title:</label>
    <form:input path="title"/><br/><br/>

    <label>Description:</label>
    <form:textarea path="description"/><br/><br/>

    <label>URL:</label>
    <form:input path="url"/><br/><br/>

    <%-- 
    <label>Category:</label>
    <select name="category.id">
        <c:forEach var="cat" items="${categories}">
            <option value="${cat.id}" <c:if test="${cat.id == video.category.id}">selected</c:if>>${cat.categoryName}</option>
        </c:forEach>
    </select><br/><br/>
    --%>

    <button type="submit">Update</button>
</form:form>

<a href="${pageContext.request.contextPath}/admin/videos">Back to list</a>
</body>
</html>
