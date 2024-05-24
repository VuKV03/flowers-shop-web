<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lý người dùng</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="./assets/css/manager.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>

<body>
<div class="container">
    <div class="container_header">
        <p>Manage User</p>
    </div>
    <div class="list_table">
        <table border="1px solid #000" width="100%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listAccount}" var="o">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.name}</td>
                    <td>${o.email}</td>
                    <td>${o.phone}</td>
                    <td>${ (o.isSell == 0) ? "Người mua" : (o.isSell == 1) ? "Người bán" : "" }</td>
                    <td>
                        <a href="loadAccount?pid=${o.id}" title="Edit"><i class="fa-solid fa-pen icon-edit"></i></a>
                        <a href="deleteAccount?pid=${o.id}" title="Delete"><i class="fa-solid fa-trash icon-delete"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="container_footer">
        <a href="home">
            <button type="button" class="btn-backhome">Back to home</button>
        </a>
    </div>
</div>
</body>
<script src="./assets/js/manage.js"></script>
</html>
