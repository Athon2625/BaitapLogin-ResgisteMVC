<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Update Your Profile</h2>

<c:if test="${not empty success}">
    <div class="alert alert-success">${success}</div>
</c:if>

<form action="${pageContext.request.contextPath}/user/profile" method="post" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="fullname" class="form-label">Fullname</label>
        <input type="text" class="form-control" id="fullname" name="fullname"
               value="${user.fullname}" required>
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" class="form-control" id="phone" name="phone"
               value="${user.phone}" required>
    </div>
    <div class="mb-3">
        <label for="image" class="form-label">Profile Image</label>
        <input type="file" class="form-control" id="image" name="image">
        <c:if test="${not empty user.image}">
            <img src="${pageContext.request.contextPath}/uploads/${user.image}" 
                 alt="Profile" class="img-thumbnail mt-2" width="120">
        </c:if>
    </div>
    <button type="submit" class="btn btn-primary">Update Profile</button>
</form>
