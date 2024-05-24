<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hệ thống cửa hàng</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="./assets/css/system_store.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> /
    <span class="current-page">Hệ thống cửa hàng</span> /
</div>
<div id="system-store">
    <h1 class="title">Hệ thống cửa hàng</h1>
    <div class="body">
        <div class="card">
            <div class="find-store">
                <h5>Tìm cửa hàng</h5>
                <div class="form-group">
                    <label>Chọn tỉnh thành</label>
                    <div class="custom-select">
                        <select id="city" class="form-control" onclick="validateSelectCity()">
                            <option value="Hà Nội">Hà Nội</option>
                            <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label>Chọn quận huyện</label>
                    <div class="custom-select">
                        <select id="district" class="form-control" onclick="validateSelectDistrict()">
                            <option value="Hà Đông">Hà Đông</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label>Chọn cửa hàng</label>
                    <div class="custom-select">
                        <select id="shop" class="form-control" onclick="validateSelectShop()"
                                onchange="mapChange()">
                            <option value="Chi nhánh Nguyễn Trãi">Chi nhánh Nguyễn Trãi</option>
                            <option value="Chi nhánh Nguyễn Đình Chiểu">Chi nhánh Nguyễn Đình Chiểu</option>
                        </select>
                    </div>
                </div>
                <div class="store__adress">
                    <div class="media">
                        <div class="media__left">
                            <i class="fa-solid fa-location-dot"></i>
                        </div>
                        <div class="media-body">
                            <h5>Địa chỉ</h5>
                            <div id="shop-infor">
                                <p id="adress">Đ. Nguyễn Trãi, Thanh Xuân Trung, Hà Nội, 10000, Việt Nam</p>
                                <p id="phone">
                                    ☎ 1900 1010 - Nhánh 101
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="store-map">
            <!--Nhúng google map -->
            <iframe 
            	src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.8550433631945!2d105.81055487444931!3d20.998446988820625!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ad451df5656b%3A0x1f65c96d05d1c064!2zUFRJVC3EkOG6oWkgSOG7jWMgVkxWSA!5e0!3m2!1svi!2s!4v1716556083752!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade">
            </iframe>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>

<script src="./assets/js/system_store.js"></script>

</html>
