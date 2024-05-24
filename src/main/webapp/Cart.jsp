<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <title>Shop Cart</title>
    <link rel="stylesheet" href="./assets/css/cart.css">
</head>
<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> /
    <span class="current-page">Giỏ hàng</span> /
</div>
<h1 class="myCart">Giỏ hàng</h1>
<table class="list_order">
    <tr>
        <th>ID</th>
        <th>Sản phẩm</th>
        <th>Price</th>
        <th>Số lượng</th>
        <th>Thành tiền</th>
        <%--        <th>Action</th>--%>
    </tr>
    <c:forEach items="${list}" var="o">
        <tr>
            <td>${o.product.id}</td>
            <td class="product_detail">
                <img src="${o.product.img_primary}"/>
                <div class="product_detail_des">${o.product.description}</div>
            </td>
            <td id="price">${o.product.salePrice} <span>VNĐ</span></td>
            <td>
                <button class="button__number" type="submit">
                    <a href="subNumber?pid=${o.product.id}"><i class="fa-solid fa-minus"></i></a>
                </button>
                <input id="number--product" type="text" readonly value="${o.quantity}"/>
                <button class="button__number" type="submit">
                    <a href="addNumber?pid=${o.product.id}"><i class="fa-duotone fa-plus"></i></a>
                </button>
            </td>
            <fmt:formatNumber value="${o.totalPrice}" pattern="##,###" var="formattedPrice"/>
            <td>${formattedPrice} <span>VNĐ</span></td>
            <td class="order_delete">
                <a href="deleteProduct?pid=${o.idProduct}" class="delete_product">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<div class="pay_cart">
    <div class="totalPrice">
        <h1>Tổng tiền: </h1>
        <p>${totalPrice} <span>VNĐ</span></p>
    </div>
    <button class="btn_checkout">
        <a href="cart-check-out">
            Thanh toán
            <i class="fa-solid fa-angle-right"></i>
        </a>
    </button>
</div>

<jsp:include page="footer.jsp"/>
</body>
<script src="./assets/js/product-detail.js"></script>
</html>