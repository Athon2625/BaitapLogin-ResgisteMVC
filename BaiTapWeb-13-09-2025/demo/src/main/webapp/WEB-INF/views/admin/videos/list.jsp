<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Video List</title>
</head>
<body>
<h2>Video List</h2>

<a href="${pageContext.request.contextPath}/admin/videos/add">Add New Video</a>
<br/><br/>

<form action="${pageContext.request.contextPath}/admin/videos/search" method="get">
    <input type="text" name="name" placeholder="Search by title"/>
    <button type="submit">Search</button>
</form>

<br/>

<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>URL</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="video" items="${videos}">
        <tr>
            <td>${video.id}</td>
            <td>${video.title}</td>
            <td>${video.description}</td>
            <td><a href="${video.url}" target="_blank">Watch</a></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/videos/edit/${video.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/videos/delete/${video.id}"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
</body>
</html>
