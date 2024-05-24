package controller;

import dao.DAO;
import model.Order_History;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/detail_order")
public class Detail_order extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DAO dao = new DAO();
            String bill = request.getParameter("bill");
            List<Order_History> order = dao.getAllProductByCode(bill);
            int sum = 0;
            for (Order_History c : order) {
                sum += dao.ChangeInt(c.getTotalPrice());
            }
            request.setAttribute("sumPrice", sum);
            request.setAttribute("Bill", order);
            request.setAttribute("Bill_code", bill);
            request.getRequestDispatcher("Bill_detail.jsp").forward(request, response);
        } catch (Exception e) {

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
