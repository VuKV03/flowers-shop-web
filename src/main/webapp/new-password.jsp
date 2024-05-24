<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đổi mật khẩu</title>
    <link rel="stylesheet" href="./assets/css/new-password.css">
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
</head>
<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> /
    <a href="login">Tài khoản</a> /
    <span class="current-page">Đăng nhập</span> /
</div>
<div class="new-password">
    <div class="new-password-container">
        <div class="new-password-text">
            <h3>THAY ĐỔI MẬT KHẨU</h3>
            <p>Nhập mật khẩu mới</p>
        </div>
        <div class="form">
            <form name="signupForm" id="newPasswordForm" action="ValidateOTP" method="post">
                <div class="">
                    <label for="password" class="new-password-label">Mật khẩu <span
                            class="required">*</span></label><br>
                    <input type="password" id="password" name="password" class="new-password-input"
                           placeholder="Mật khẩu" required>
                </div>
                <div class="">
                    <label for="re-password" class="new-password-label">Xác nhận mật khẩu <span
                            class="required">*</span></label><br>
                    <input type="password" id="re-password" name="re-password" class="new-password-input"
                           placeholder="Xác nhận mật khẩu" required>
                </div>
                <div class="btn">
                    <div class="btn-submit">
                        <button type="submit" id="submitButton"
                                onclick="validateSignupForm()">Đổi mật khẩu
                        </button>
                    </div>
                </div>
            </form>
            <button class="btn-cancel">
                <a href="login">Hủy</a>
            </button>
        </div>
    </div> 
</div>
<jsp:include page="footer.jsp"/>
<script src="./assets/js/new-password.js"></script>
</body>
</html>