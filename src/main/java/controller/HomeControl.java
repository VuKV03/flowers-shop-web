package controller;

import dao.DAO;
import model.Blog;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeControl", urlPatterns = "/home")
public class HomeControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        List<Product> list = dao.get15TopProducts();
        List<Category> listC = dao.getAllCategory();
        List<Product> list8last = dao.get8LastestProducts();
        List<Blog> listBL = dao.getAllBlogs();

        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("listPL", list8last);
        request.setAttribute("listBL", listBL);
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
