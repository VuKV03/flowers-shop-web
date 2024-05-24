package controller;

import dao.DAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllProducts", value = "/all")
public class AllProducts extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        int number = dao.getNumberPage2();

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        List<Product> list1 = dao.getPaging2(indexPage);

        request.setAttribute("listPage", list1);
        request.setAttribute("indexPage",indexPage);
        request.setAttribute("listAP", list);
        request.setAttribute("num", number);
        request.getRequestDispatcher("sapxep.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
