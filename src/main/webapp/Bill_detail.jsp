<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="dao.DAO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DAO dao=new DAO();
    List<Order_History> order=(List<Order_History>) request.getAttribute("Bill");
    double Total=0;
    String bill_code="";
%>
<html>
<head>
    <title>Bill detail</title>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="stylesheet" href="./assets/css/cart.css">
</head>
<body>
<jsp:include page="header_none.jsp"/>
<div class="crumbread">
    <a href="home">Trang chủ</a> /
    <a href="bill">Kiểm tra đơn hàng</a> /
    <span class="current-page">Chi tiết đơn hàng</span> /
</div>
<div class="container">
    <div class="card-header my-3">Order Bill</div>

    <table class="table table-light">
        <tr>
            <th scope="col">Name Product</th>
            <th scope="col">Quantity</th>
            <th scope="col">Total Price</th>
            <th scope="col">Date</th>

        </tr>

        <%for(Order_History o:order){%>
        <tr>
            <%Product Name= dao.getNamePro(o.getP_id());%>
            <%Total += Double.parseDouble(o.getTotalPrice());%>
            <%bill_code=o.getBill_code();%>
            <td><%=Name.getName()%></td>
            <td><%=o.getO_quantity()%></td>
            <fmt:formatNumber value="<%=o.getTotalPrice()%>" pattern="##,###" var="formattedPrice1"/>
            <td>${formattedPrice1} <span>VNĐ</span></td>
            <td><%=o.getDate()%></td>
        </tr>
        <%}%>
    </table>
    <div class="bill_detail--sum">
        <fmt:formatNumber value="<%=Total%>" pattern="##,###" var="formattedPrice"/>
        <h4 >Tổng tiền đã thanh toán: ${formattedPrice} <span>VNĐ</span></h4>
        <h4 >Mã Code: <%=bill_code%></h4>
    </div>
    <a href="home" class="btn_bill">OK</a>
    <a href="bill" class="btn_bill">Back</a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
