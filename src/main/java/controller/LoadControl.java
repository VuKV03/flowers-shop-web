package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import model.Account;
import model.Blog;
import model.Category;
import model.Product;

@WebServlet(name = "LoadControl", urlPatterns = {"/loadProduct", "/loadAccount", "/loadBlog"})
public class LoadControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);
        List<Category> list = dao.getAllCategory();

        request.setAttribute("detail", p);
        request.setAttribute("listC", list);
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }

    protected void processRequestAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Account p = dao.getAccountByID(id);

        request.setAttribute("detail", p);
        request.getRequestDispatcher("editAccount.jsp").forward(request, response);
    }

    protected void processRequestBlog(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Blog p = dao.getBlogByID(id);

        request.setAttribute("detail", p);
        request.getRequestDispatcher("editBlog.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if(requestURI.contains("/loadAccount")) {
            processRequestAccount(req, resp);
        }
        else if(requestURI.contains("/loadBlog")) {
            processRequestBlog(req, resp);
        }
        else if(requestURI.contains("/loadProduct")) {
            processRequest(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if(requestURI.contains("/loadAccount")) {
            processRequestAccount(req, resp);
        }
        else if(requestURI.contains("/loadBlog")) {
            processRequestBlog(req, resp);
        }
        else if(requestURI.contains("/loadProduct")) {
            processRequest(req, resp);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}