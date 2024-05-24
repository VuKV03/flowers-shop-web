<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flowers shop</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <style><%@include file="./assets/css/main.css"%></style>
    <style><%@include file="./assets/css/base.css"%></style>

    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="container__content">
        <div class="container__header">
            <div class="container__header--boxtime">
                <div class="container__header--boxtime--title">
                    <a href="home" class="container__boxtime--title-link">ƯU ĐÃI HOT, ĐỪNG BỎ LỠ!!</a>
                    <p class="container__boxtime--title--paragraph">Sản phẩm sẽ trở về giá gốc khi hết giờ</p>
                </div>
                <div class="container__header__boxtime-time">
                    <div class="container__header__boxtime-hour">
                        <span class="container-hour">09</span>
                        <span class="container-time--unit">Giờ</span>
                    </div>
                    <div class="container__header__boxtime-hour">
                        <span class="container-minute">53</span>
                        <span class="container-time--unit">Phút</span>
                    </div>
                    <div class="container__header__boxtime-hour">
                        <span class="container-second">00</span>
                        <span class="container-time--unit">Giây</span>
                    </div>
                </div>
            </div>
            <div class="container__box--promotion">
                <h2 class="container__promotion">BẢN TIN KHUYẾN MÃI</h2>
            </div>
        </div>

        <div class="container__content--primary">
            <c:forEach items="${listP}" var="o">
                <div class="container__content--primary--items">
                    <div class="container--items--img">
                        <a href="detail?pid=${o.id}">
                            <img src="${o.img_primary}" alt="" class="container__product-img img-primary">
                        </a>
                    </div>                    
                    <div class="container--items--img">
                        <a href="detail?pid=${o.id}">
                            <img src="${o.img_second}" alt="" class="container__product-img img-secondary">
                        </a>
                    </div> 
                    <div class="product--action">
                        <div class="group__prodcut--action">
                            <a href="detail?pid=${o.id}" class="product--action--links btn">
                                <i class="fa-solid fa-magnifying-glass product__action--icon"></i>
                            </a>
                        </div>
                    </div>
                    <div class="container--items-content">
                        <span class="product-vendor">${o.name}</span>
                        <h3 class="product-name">
                            <a href="detail?pid=${o.id}" class="product-name-link">
                                    ${o.description}
                            </a>
                        </h3>
                        <div class="product-price-box">
                            <div class="product-price">
                                <span class="price"><b>${o.salePrice}₫</b></span>
                                <span class="compare-price">${o.costPrice}₫</span>
                                <div class="compare-price--pseudo"></div>
                            </div>
                            <button class="add--cart" title="Thêm giỏ hàng">
                                <a href="detail?pid=${o.id}" class="add--cart--link">
                                    <ion-icon name="add-outline" class="icon-add-cart"></ion-icon>
                                </a>
                            </button>
                        </div>
                        <div class="flashsale__bottom">
                            <div class="flashsale__label">
                                <b class="flashsale__sold-qty">${o.quantity}</b> sản phẩm đã bán
                            </div>
                            <div class="flashsale__progressbar">
                                <div class="flashsale___percent" style="width: 53%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="btn-view-box">
            <a href="all" class="btn-view">Xem tất cả
                <ion-icon name="chevron-forward-outline" class="btn--right"></ion-icon>
            </a>
        </div>
    </div>
</div>
<div class="container__second">
    <div class="container__content">
        <div class="container__header--boxtime--title">
            <a href="home" class="container__boxtime--title-link">HÀNG MỚI VỀ</a>
        </div>
    </div>
    <div class="container__second--content">
        <div class="container__second--best-seller">
            <div class="container__box--best-seller">
                <a href="home" class="container__second-link">
                    <img src="./assets/img/best_seller.jpg" alt="" class="container__second-img">
                </a>
            </div>
            <div class="container__second--best-product">
                <div class="btn-view-box btn-best-product">
                    <a href="home" class="btn-view btn-small">Hoa sinh nhật
                    </a>
                </div>
                <div class="btn-view-box btn-best-product">
                    <a href="home" class="btn-view btn-small">Hoa valentine
                    </a>
                </div>
                <div class="btn-view-box btn-best-product">
                    <a href="home" class="btn-view btn-small">Hoa ngày của mẹ
                    </a>
                </div>
                <div class="btn-view-box btn-best-product">
                    <a href="home" class="btn-view btn-small">Hoa 8-3
                    </a>
                </div>
            </div>
        </div>
        <div class="container__second--product-box">
            <div class="container__second--list-product">
                <c:forEach items="${listPL}" var="o">
                    <div class="container__content--primary--items contianer__content-primary--items-second">
                        <div class="container--items--img">
                            <a href="detail?pid=${o.id}">
                                <img 
                                	src="${o.img_primary}" alt=""
                                     class="container__product-img img-primary">
                            </a>
                        </div>
                        <div class="container--items--img">
                            <a href="detail?pid=${o.id}">
                                <img 
                                	src="${o.img_second}" alt=""
                                     class="container__product-img img-secondary">
                            </a>
                        </div>
                        <div class="product--action">
                            <div class="group__prodcut--action">
                                <a href="detail?pid=${o.id}" class="product--action--links btn">
                                    <i class="fa-solid fa-magnifying-glass product__action--icon"></i>
                                </a>
                            </div>
                        </div>
                       <div class="container--items-content">
                            <span class="product-vendor">${o.name}</span> 
                            <h3 class="product-name">
                                 <a href="detail?pid=${o.id}" class="product-name-link">
                                        ${o.description}
                                </a> 
                            </h3> 
                            <div class="product-price-box">
                                <div class="product-price">
                                    <span class="price"><b>${o.salePrice}₫</b></span>
                                    <span class="compare-price">${o.costPrice}₫</span>
                                    <div class="compare-price--pseudo"></div>
                                </div>
                                <button class="add--cart" title="Thêm giỏ hàng">
                                    <a href="detail?pid=${o.id}" class="add--cart--link">
                                        <ion-icon name="add-outline" class="icon-add-cart"></ion-icon>
                                    </a>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="btn-view-box">
                <a href="all" class="btn-view">Xem tất cả
                    <ion-icon name="chevron-forward-outline" class="btn--right"></ion-icon>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="box_blog">
    <div class="blog">
        <div class="blog__title--box">
            <a href="" alt="" class="blog__title">BLOGS</a>
        </div>
        <div class="blog__content">
            <c:forEach items="${listBL}" var="o">
                <div class="blog__content--item">
                    <div class="blog__content--img">
                        <a href="#">
                            <img
                                    class="blog--images"
                                    src="${o.image}"
                                    alt=""
                            />
                        </a>
                    </div>
                    <div class="blog__content--title-box">
                        <a href="#" alt="" class="blog__content--title">
                                ${o.title}
                        </a>
                    </div>
                    <div class="blog__content--desc-box">
                        <a class="blog__content--desc--title">
                                ${o.description}
                        </a>
                    </div>
                    <div class="blog__link--box">
                        <a href="#" class="blog__link--item">Đọc tiếp</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="btn-view-box">
            <a href="#" class="btn-view">Xem tất cả
                <ion-icon name="chevron-forward-outline" class="btn--right"></ion-icon>
            </a>
        </div>
    </div>
</div> 

<jsp:include page="footer.jsp"/>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>