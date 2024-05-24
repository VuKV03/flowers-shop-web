<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Header</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/fonts/fontawesome-free-6.3.0-web/fontawesome-free-6.3.0-web/css/all.min.css">
    <style><%@include file="./assets/css/header.css"%></style>
</head>

<script src="./assets/js/main.js"></script>

<body>
<header>
    <div class="banner">
        <a href="home">
            <img class="banner_img" src="./assets/image/banner-top.jpg" alt="image_banner">
        </a>
    </div>

    <div class="header_center">
        <div class="logo_shop">
            <a href="home">
                <img 
    				src="./assets/image/logo.png" alt="logo_web">
            </a>
        </div>

        <div class="search">
            <form action="search" method="post" class="input_search">
                <input value="${txtS}" type="text" name="query"
                       placeholder="Tìm loại hoa mà bạn mong muốn..">
                <button type="submit" class="icon_search">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>

            <div class="search_dropdow">
                <ul class="search_list">
                    <li class="search_item">
                        <a href="home" id="filter-search-vu">Vũ</a>
                    </li>
                    <li class="search_item">
                        <a href="home" id="filter-search-son-manh">Manh</a>
                    </li>
                    <li class="search_item">
                        <a href="home" id="filter-search-duong">Dương</a>
                    </li>
                    <li class="search_item">
                        <a href="home" id="filter-search-ngan">Ngân</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="header-right">
            <ul class="header-right-list">
                <li class="hotline">
                    <img src="./assets/image/image-icons/phone_icon.png" alt="phone_icon">
                    <div class="hotline-flex">
                        <span>Hỗ trợ khách hàng</span>
                        <a href="home">1900 1010</a>
                    </div>
                </li>

                <li class="account">
                    <img src="./assets/image/image-icons/account_icon.png" alt="account_icon">
                    <div class="account-flex">
                        <c:if test="${sessionScope.acc == null}">
                            <a href="login" class="user-account">Tài khoản</a>
                            <a href="login" class="login">Đăng nhập</a>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <a href="home" class="user-account">${sessionScope.acc.name}</a>
                            <a href="logout" class="login">Đăng xuất</a>
                        </c:if>
                    </div>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.acc.isAdmin == 0 && sessionScope.acc.isSell == 0}">
                        <div class="border-cart-group">
                            <li class="cart-group">
                                <a href="cart" class="img-cart" title="Giỏ hàng">
                                    <img src="./assets/image/cart_icon.webp" alt="cart_icon">
                                    <div class="span-tag">
                                        <span class="cartshop">Giỏ hàng</span>
                                    </div>
                                </a>
                            </li>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="border-cart-group">
                            <li class="cart-group">
                                <a href="home" class="img-cart" title="Giỏ hàng">
                                    <img src="./assets/image/cart_icon.webp" alt="cart_icon">
                                    <div class="span-tag">
                                        <span class="cartshop">Giỏ hàng</span>
                                    </div>
                                </a>
                            </li>
                        </div>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

    <div class="sub-header">
        <div class="sub-header-container">
            <ul class="sub-header-flex">
                <li class="category">
                    <div class="category_title">
                        <i class="fa-solid fa-bars"></i>
                        <a href="all">Danh mục sản phẩm</a>
                    </div>
                    <ul class="subnav">
                        <c:forEach items="${listC}" var="c">
                            <li>
                                <div class="list-category">
                                    <div class="list-detail">
                                        <img src="${c.image}" alt="${c.cname}">
                                        <a href="category?cid=${c.cid}" class="list-detail-op">${c.cname}</a>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </li>

                <li class="policy_header">
                    <img src="./assets/image/policy_header_image_1.png" alt="chính sách đổi trả icon">
                    <a href="home">Chính sách đổi trả</a>
                </li>

                <li class="system_store">
                    <img src="./assets/image/policy_header_image_2.png" alt="hệ thống cửa hàng icon">
                    <a href="system_store">Hệ thống cửa hàng</a>
                </li>

                <c:if test="${sessionScope.acc.isAdmin == 0 && sessionScope.acc.isSell == 0}">
                    <li class="check_order">
                        <img src="./assets/image/policy_header_image_3.png" alt="kiểm tra đơn hàng icon">
                        <a href="bill">Kiểm tra đơn hàng</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li class="user_manage">
                        <img src="./assets/image/user.png" alt="quản lý người dùng">
                        <a href="manageUser">Quản lý người dùng</a>
                    </li>
                    <li class="blog_manage">
                        <img src="./assets/image/blog.png" alt="quản lý người dùng">
                        <a href="manageBlog">Quản lý bài viết</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc.isSell == 1}">
                    <li class="product_manage">
                        <img src="./assets/image/box.png" alt="quản lý sản phẩm">
                        <a href="manage">Quản lý sản phẩm</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</header>

<div class="header-slider">
    <i class="fa fa-angle-left slider-prev"></i>
    <ul class="slider-dots">
        <li class="slider-dot-item active" data-index="0"></li>
        <li class="slider-dot-item" data-index="1"></li>
        <li class="slider-dot-item" data-index="2"></li>
    </ul>
    <div class="slider-wrapper">
        <div class="slider-main">
            <div class="slider-item">
                <img src="./assets/image/slider/Slider_1.jpg" alt="slide1"/>
            </div>
            <div class="slider-item">
                <img src="./assets/image/slider/Slider_2.jpg" alt="slide2"/>
            </div>
            <div class="slider-item">
                <img src="./assets/image/slider/Slider_3.jpg" alt="slide3"/>
            </div>
        </div>
    </div>
    <i class="fa fa-angle-right slider-next"></i>
</div>

<div class="category-highlight">
    <a href="all" class="category-highlight-text">DANH MỤC NỔI BẬT</a>
    <ul class="list-item">
        <c:forEach items="${listC}" var="c">
            <li>
                <a href="category?cid=${c.cid}">
                    <img src="${c.image}" alt="">
                    <span>${c.cname}</span>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
</body> 
</html>
