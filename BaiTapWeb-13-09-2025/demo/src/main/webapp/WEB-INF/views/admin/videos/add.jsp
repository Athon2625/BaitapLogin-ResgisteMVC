<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add Video</title>
</head>
<body>
<h2>Add Video</h2>

<form:form method="post" modelAttribute="video" action="${pageContext.request.contextPath}/admin/videos/saveOrUpdate">

    <label>Title:</label>
    <form:input path="title"/><br/><br/>

    <label>Description:</label>
    <form:textarea path="description"/><br/><br/>

    <label>URL:</label>
    <form:input path="url"/><br/><br/>

    <%-- 
    <label>Category:</label>
    <form:select path="category.id">
        <form:options items="${categories}" itemValue="id" itemLabel="categoryName"/>
    </form:select><br/><br/>
    --%>

    <button type="submit">Save</button>
</form:form>

<a href="${pageContext.request.contextPath}/admin/videos">Back to list</a>
</body>
</html>
