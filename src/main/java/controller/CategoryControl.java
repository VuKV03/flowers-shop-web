package controller;

import dao.DAO;
import model.Account;
import model.Blog;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryControl", value = "/category")
public class CategoryControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("cid");

        DAO dao = new DAO();
        List<Product> list = dao.getProductByCID(cateID);
        List<Category> listC = dao.getAllCategory();
        List<Product> list8last = dao.get8LastestProducts();

        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("listPL",list8last);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
