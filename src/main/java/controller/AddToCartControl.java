package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Account;


@WebServlet(value = "/addToCart")
public class AddToCartControl extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String description = request.getParameter("product-description");

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }
        int idUser = a.getId();

        String price = request.getParameter("product-saleprice");
        int quantity = Integer.parseInt(request.getParameter("product-quantity"));
        Double totalPrice = Double.parseDouble(price.replace(",", "")) * quantity;

        DAO dao = new DAO();
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        if (a.getIsAdmin() == 0 && a.getIsSell() == 0) {
            if (dao.checkProductInOrders(idProduct, idUser)) {
                dao.updateQuantityOrders(quantity, idProduct, price, idUser);
            } else {
                dao.addOrder(idProduct, quantity, totalPrice, idUser);
            }
            response.sendRedirect("home");
        } else {
            response.sendRedirect("home");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
