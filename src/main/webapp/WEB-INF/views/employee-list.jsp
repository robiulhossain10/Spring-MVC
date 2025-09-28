<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Cards</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .card-title {
        font-weight: bold;
    }
    .card {
        transition: box-shadow 0.2s;
    }
    .card:hover {
        box-shadow: 0 4px 20px rgba(0,0,0,0.15);
    }
    </style>
</head>
<body class="bg-light">
<div class="container py-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-primary">Employee Cards</h2>
        <a href="${pageContext.request.contextPath}/api/employees/new" class="btn btn-success">Add Employee</a>
    </div>
    <div class="row g-4">
        <c:forEach var="emp" items="${employees}">
            <div class="col-md-4 col-sm-6">
                <div class="card h-100 shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">${emp.name}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">ID: ${emp.id}</h6>
                        <p class="card-text">
                            <strong>Email:</strong> ${emp.email}<br>
                            <strong>DOB:</strong> ${emp.dob}<br>
                            <strong>Dept:</strong> ${emp.department}
                        </p>
                        <div class="mt-3">
                            <a href="${pageContext.request.contextPath}/api/employees/edit/${emp.id}" class="btn btn-warning btn-sm me-2">Edit</a>
                            <a href="${pageContext.request.contextPath}/api/employees/delete/${emp.id}" class="btn btn-danger btn-sm"
                               onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:if test="${empty employees}">
        <div class="alert alert-info text-center mt-4">No employees found.</div>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>