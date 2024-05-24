<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tất cả sản phẩm</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>
<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> /
    <span class="current-page">Tất cả sản phẩm</span> /
</div>
<div class="container__second">
    <div class="container__second--content">
        <div class="container__second--best-seller container__box--price">
            <h3 class="container__price--title">MỨC GIÁ</h3>
            <ul class="container_price--list">
                <li class="container_price--items">
                    <input type="checkbox" class="checkbox-input" id="price-1">
                    <span class="checkbox--price">0đ - 100.000đ</span>
                </li>
                <li class="container_price--items">
                    <input type="checkbox" class="checkbox-input" id="price-2">
                    <span class="checkbox--price">100.000đ - 200.000đ</span>
                </li>
                <li class="container_price--items">
                    <input type="checkbox" class="checkbox-input" id="price-3">
                    <span class="checkbox--price">200.000đ - 300.000đ</span>
                </li>
                <li class="container_price--items">
                    <input type="checkbox" class="checkbox-input" id="price-4">
                    <span class="checkbox--price">300.000đ - 500.000đ</span>
                </li>
                <li class="container_price--items">
                    <input type="checkbox" class="checkbox-input" id="price-5">
                    <span class="checkbox--price">500.000đ - 1.000.000đ</span>
                </li>
                <li class="container_price--items">
                    <input type="checkbox" class="checkbox-input" id="price-6">
                    <span class="checkbox--price">Giá trên 1.000.000đ</span>
                </li>
            </ul>
        </div>
        <div class="container__second--product-box boder-price">
            <div class="container__price--box2">
                <div class="container__price--box2--title">
                    <h2 class="container__price--title--item">Tất cả sản phẩm</h2>
                </div>
                <div class="sort-by">
                    <label for="" class="sort-by--left">
                        <span>Sắp xếp: </span>
                    </label>
                    <ul class="sort-by--list">
                        <li class="sort-by--items">
                            <a href="#" class="sort-by--items--link" onclick="sortProductByNameA2Z()">Tên A → Z</a>
                        </li>
                        <li class="sort-by--items">
                            <a href="#" class="sort-by--items--link" onclick="sortProductByNameZ2A()">Tên Z → A</a>
                        </li>
                        <li class="sort-by--items">
                            <a href="#" class="sort-by--items--link" onclick="sortProductByPriceA2Z()">Giá tăng dần</a>
                        </li>
                        <li class="sort-by--items">
                            <a href="#" class="sort-by--items--link" onclick="sortProductByPriceZ2A()">Giá Giảm dần</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="container__second--list-product">
                <c:forEach items="${listPage}" var="o">
                    <div class="container__content--primary--items contianer__content-primary--items-second">
                        <div class="container--items--img">
                            <a href="detail?pid=${o.id}">
                                <img src="${o.img_primary}" alt=""
                                     class="container__product-img img-primary">
                            </a>
                        </div>
                        <div class="container--items--img">
                            <a href="detail?pid=${o.id}">
                                <img src="${o.img_second}" alt=""
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
                                <button class="add--cart" title="Thêm giở hàng">
                                    <a href="detail?pid=${o.id}" class="add--cart--link">
                                        <ion-icon name="add-outline" class="icon-add-cart"></ion-icon>
                                    </a>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="paging">
                <c:forEach begin="1" end="${num}" var="i">
                    <a href="all?index=${i}" class="${indexPage == i?"active":""}">${i}</a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

<script>
    const checkboxes = document.querySelectorAll('.checkbox-input');
    const productItems = document.querySelectorAll('.container__content--primary--items');

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('click', () => {
            const checkedPrices = document.querySelectorAll('.checkbox-input:checked + .checkbox--price');

            productItems.forEach(item => {
                const priceElement = item.querySelector('.price');
                const price = parseInt(priceElement.textContent.replace(/\./g, '').replace(/,/g, '').replace('đ', ''));

                if (checkedPrices.length) {
                    let shouldShowItem = false;
                    checkedPrices.forEach(priceEl => {
                        const priceRange = priceEl.textContent.replace(/\./g, '').replace(/,/g, '').replace('đ', '').split('-');
                        const minPrice = parseInt(priceRange[0]);
                        const maxPrice = parseInt(priceRange[1] || Infinity);
                        if (price >= minPrice && price <= maxPrice) {
                            shouldShowItem = true;
                        }

                        if (price >= 1000000 && document.getElementById('price-6').checked) {
                            shouldShowItem = true;
                        }
                    });
                    item.style.display = shouldShowItem ? 'block' : 'none';
                } else {
                    item.style.display = 'block';
                }
            });
        });
    });


    function sortProductByNameA2Z() {
        const productList = document.querySelectorAll('.container__second--list-product .container__content--primary--items');
        const sortedList = Array.from(productList).sort((a, b) => {
            const nameA = a.querySelector('.product-name-link').textContent;
            const nameB = b.querySelector('.product-name-link').textContent;
            return nameA.localeCompare(nameB);
        });
        const parent = productList[0].parentNode;
        parent.innerHTML = '';
        sortedList.forEach(item => {
            parent.appendChild(item);
        });
    }

    function sortProductByNameZ2A() {
        const productList = document.querySelectorAll('.container__second--list-product .container__content--primary--items');
        const sortedList = Array.from(productList).sort((b, a) => {
            const nameA = a.querySelector('.product-name-link').textContent;
            const nameB = b.querySelector('.product-name-link').textContent;
            return nameA.localeCompare(nameB);
        });
        const parent = productList[0].parentNode;
        parent.innerHTML = '';
        sortedList.forEach(item => {
            parent.appendChild(item);
        });
    }


    function sortProductByPriceA2Z() {
        /* 	const price = '1,260,000đ';
        console.log(price..replace(/\./g, '').replace(/,/g, '.').replace('đ', '')); */
        // Lấy ra các sản phẩm ở định dạng NodeList
        const productList = document.querySelectorAll('.container__second--list-product .container__content--primary--items');
        // Chuyển sang một mảng để có thể sử dụng phương thức sort()
        const sortedList = Array.from(productList).sort((a, b) => {
            // Lấy ra giá của sản phẩm
            const priceA = parseInt(a.querySelector('.price').textContent.replace(/\./g, '').replace(/,/g, '').replace('đ', ''));
            const priceB = parseInt(b.querySelector('.price').textContent.replace(/\./g, '').replace(/,/g, '').replace('đ', ''));
            // So sánh và trả về kết quả để sort() sắp xếp
            //console.log(priceA);
            //console.log(priceB);
            return priceA - priceB;
        });

        // Xóa toàn bộ sản phẩm hiện có trong container
        const parent = productList[0].parentNode;
        parent.innerHTML = '';
        // Thêm các sản phẩm đã sắp xếp vào container
        sortedList.forEach(item => {
            parent.appendChild(item);
        });
    }


    function sortProductByPriceZ2A() {
        // Lấy ra các sản phẩm ở định dạng NodeList
        const productList = document.querySelectorAll('.container__second--list-product .container__content--primary--items');
        // Chuyển sang một mảng để có thể sử dụng phương thức sort()
        const sortedList = Array.from(productList).sort((b, a) => {
            // Lấy ra giá của sản phẩm
            const priceA = parseInt(a.querySelector('.price').textContent.replace(/\./g, '').replace(/,/g, '').replace('đ', ''));
            const priceB = parseInt(b.querySelector('.price').textContent.replace(/\./g, '').replace(/,/g, '').replace('đ', ''));
            // So sánh và trả về kết quả để sort() sắp xếp
            //console.log(priceA);
            //console.log(priceB);
            return priceA - priceB;
        });

        // Xóa toàn bộ sản phẩm hiện có trong container
        const parent = productList[0].parentNode;
        parent.innerHTML = '';
        // Thêm các sản phẩm đã sắp xếp vào container
        sortedList.forEach(item => {
            parent.appendChild(item);
        });
    } 
</script>
</body>
</html>
