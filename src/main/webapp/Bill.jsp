<%@ page import="dao.DAO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    Account a = (Account) request.getSession().getAttribute("acc");
    DAO dao= new DAO();
    List<Order_History>model =dao.getAllOrder_History(a.getId());
    String check="";
%>
<html>
<head>
    <title>Bill</title>
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
    <span class="current-page">Kiểm tra đơn hàng</span> /
</div>
<div class="container">
    <div class="card-header my-3">Orders History</div>

    <table class="table table-light list_order">

        <tr>
            <th scope="col">Date</th>
            <th scope="col">Bill_code</th>
            <th scope="col">Detail</th>
        </tr>

        <%
            for(Order_History o: model){%>
        <tr>
            <% if(check.compareTo(o.getBill_code()) != 0){%>
            <td class="product_detail_des"><%=o.getDate() %></td>
            <td class="product_detail_des"><%=o.getBill_code()%></td>
            <td class="product_detail_des"><a class="bill_detail" href="detail_order?bill=<%=o.getBill_code()%>">Detail</a></td>
            <% check= o.getBill_code();}%>
        </tr>
        <%
        }
        %>
    </table>
    <a href="home" class="btn_bill">OK</a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
