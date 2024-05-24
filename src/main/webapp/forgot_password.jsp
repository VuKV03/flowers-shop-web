<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="./assets/css/forgot_password.css">
    <meta charset="UTF-8">
    <title>Lấy lại mật khẩu</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
</head>
<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> /
    <a href="login">Tài khoản</a> /
    <span class="current-page">Đăng nhập</span> /
</div>
<div class="forgot-password">
    <div class="forgot-password-container">
        <div class="forgot-password-text">
            <h3>ĐẶT LẠI MẬT KHẨU</h3>
            <p>Chúng tôi sẽ gửi cho bạn một email để kích hoạt việc đặt lại mật khẩu.</p>
        </div>
        <form action="otp" method="post" class="forgot-password-form">
            <div class="">
                <input type="text" name="email" class="forgot-password-input" placeholder="Email" required>
            </div>
            <div class="">
                <button class="btn-submit">Lấy lại mật khẩu</button>
            </div>
        </form>
        <div class="btn-before">
            <button class="btn-submit">
                <a href="login" class="before">Quay lại</a>
            </button>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>