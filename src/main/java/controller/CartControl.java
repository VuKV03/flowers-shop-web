package controller;


import dao.DAO;
import model.Account;
import model.Orders;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(name = "CartControl", value = "/cart")
public class CartControl extends HttpServlet {

    private DAO dao = new DAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int idUser = a.getId();
        

        List<Orders> listCart = dao.getAllOrders(idUser);
        request.setAttribute("list", listCart);
        Double totalPrice = 0.0;
        for (Orders x : listCart) {
            totalPrice += Double.parseDouble(x.getTotalPrice().replace(",", ""));
        }
        String totalMoney = String.valueOf(totalPrice); // Chuyển đổi double thành chuỗi
        DecimalFormat decimalFormat = new DecimalFormat("##,###");
        String formattedNumber = "";
        if (!totalMoney.isEmpty()) {
            try {
                formattedNumber = decimalFormat.format(Double.parseDouble(totalMoney));
            } catch (NumberFormatException e) {
                formattedNumber = "Invalid Number"; // Giá trị không hợp lệ
            }
        }
        request.setAttribute("totalPrice", formattedNumber);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
