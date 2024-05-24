<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết sản phẩm</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/find-product.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>
<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> / <a href="all">Tất cả sản phẩm</a> / <span
        class="current-page">${detail.description}</span> /
</div>
<div class="product_container">
    <form action="addToCart" method="post">
        <div class="product_container--start">
            <div class="product_container--img">
                <img src="${detail.img_primary}" alt="" class="img--product">
            </div>
            <input type="hidden" id="product-image" name="product-image"
                   value="${detail.img_primary}">
            <input type="hidden"  name="idProduct"
                   value="${idProduct}">
            <div class="product_container--info">
                <h3 class="product_container--name">${detail.name}</h3>
                <h2 class="product_container--title">${detail.description}</h2>
                <input type="hidden" id="product-description" name="product-description"
                       value="${detail.description}">
                <p class="product_status">
                    Tình trạng: <span class="product_status--info">Còn hàng</span>
                </p>
                <div class="product_container--price">
                    <div class="product_container--sale-price">${detail.salePrice}₫
                    </div>
                    <input type="hidden" id="product-sale-price"
                           name="product-saleprice" value="${detail.salePrice}">
                    <div class="product_container--cost-price">${detail.costPrice}₫
                    </div>
                    <%-- <input type="hidden" id="product-cost-price"
                        name="product-costprice" value="${detail.costPrice}"> --%>
                </div>
                <div class="flashsale__bottom flashsale__color">
                    <div class="flashsale_bottom--title">
                        <h2>ƯU ĐÃI HOT, ĐỪNG BỎ LỠ!!</h2>
                        <p>Sản phẩm sẽ trở về giá gốc khi hết giờ</p>
                    </div>
                    <div class="flashsale__label">
                        <b class="flashsale__sold-qty">${detail.quantity}</b> sản phẩm đã
                        bán
                    </div>
                    <div class="flashsale__progressbar">
                        <div class="flashsale___percent" style="width: 53%;"></div>
                    </div>
                </div>
                <div class="product__number">
                    <label>Số lượng:</label>
                    <div class="product__number--input--number">
                        <button class="button__number" id="sub--product" type="submit"
                        <%--onclick="subProduct()"--%>>
                            <i class="fa-solid fa-minus"></i>
                        </button>
                        <input name="product-quantity" id="number--product" type="text"
                               value="1"/>
                        <button class="button__number" id="add--product" type="submit"
                        <%--onclick="addProduct()"--%>>
                            <i class="fa-duotone fa-plus"></i>
                        </button>
                    </div>
                </div>
                <div class="product__btn">
                    <button class="product__btn--add--cart product-btn-buy btn-buy" type="submit">Mua Ngay</button>
                    <button class="product__btn--add--cart product--btn-add btn--add-cart" type="submit">Thêm vào giỏ</button>
                </div>
            </div>
        </div>
    </form>
    <div class="product-des">
    	Đoạn này là mô tả sản phẩm
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>

<script src="./assets/js/product-detail.js"></script>
</html>
