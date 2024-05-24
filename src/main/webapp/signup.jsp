<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="./assets/css/signup.css">
</head>
<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> /
    <a href="login">Tài khoản</a> /
    <span class="current-page">Đăng ký</span> /
</div>
<div class="register">
    <div class="register-header">
        <h1>đăng ký tài khoản</h1>
        <p>Bạn đã có tài khoản ? Đăng nhập <a href="signin.jsp" class="btn__login">tại đây</a></p>
    </div>
    <div class="register-form">
        <div class="register-form-header">
            <h3>thông tin cá nhân</h3>
        </div>

        <form action="signup" method="post" class="register-form-container">
            <div class="mes_alert" style="color: red;display: flex;
    justify-content: center;
    align-items: center;">${requestScope.mes}<br>
            </div>

            <div class="register-form-form">
                <label for="Name" class="register-form-label">Name <span class="required">*</span></label><br>
                <input name="name_user" type="text" class="register-form-input" placeholder="Name" required>
            </div>
            <div class="register-form-form">
                <label for="Username" class="register-form-label">Username <span class="required">*</span></label><br>
                <input name="user" type="text" class="register-form-input" placeholder="Username" required>
            </div>
            <div class="register-form-form">
                <label for="Email" class="register-form-label">Email <span class="required">*</span></label><br>
                <input name="email" type="text" class="register-form-input" placeholder=Email required>
            </div>
            <div class="register-form-form">
                <label for="Phone" class="register-form-label">Phone <span class="required">*</span></label><br>
                <input name="phone" type="text" class="register-form-input" placeholder="Phone" required>
            </div>
            <div class="register-form-form">
                <label for="Password" class="register-form-label">Password <span
                        class="required">*</span></label><br>
                <input name="pass" type="password" class="register-form-input" placeholder="Password" required>
            </div>
            <div class="register-form-form">
                <label for="Repeat Password" class="register-form-label">Repeat Password <span
                        class="required">*</span></label><br>
                <input name="repass" type="password" class="register-form-input" placeholder="Repeat Password" required>
            </div>
            <div class="register-submit">
                <button type="submit" class="btn-submit">Create Account</button>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
