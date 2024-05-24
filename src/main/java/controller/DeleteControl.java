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

@WebServlet(name = "DeleteControl", urlPatterns = {"/delete", "/deleteAccount", "/deleteBlog", "/deleteProduct"})
public class DeleteControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pid = request.getParameter("pid");
        DAO dao = new DAO();
        dao.deleteProduct(pid);
        response.sendRedirect("manage");
    }

    protected void processRequestAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pid = request.getParameter("pid");
        DAO dao = new DAO();
        dao.deleteAccount(pid);
        response.sendRedirect("manageUser");
    }

    protected void processRequestBlog(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pid = request.getParameter("pid");
        DAO dao = new DAO();
        dao.deleteBlog(pid);
        response.sendRedirect("manageBlog");
    }

    protected void processRequestProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pid = request.getParameter("pid");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int idUser = a.getId();
        DAO dao = new DAO();
        dao.deleteProductOrders(pid, idUser);
        response.sendRedirect("cart");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if(requestURI.contains("/deleteAccount")) {
            processRequestAccount(req, resp);
        }
        else if(requestURI.contains("/deleteBlog")) {
            processRequestBlog(req, resp);
        }
        else if(requestURI.contains("/deleteProduct")) {
            processRequestProduct(req, resp);
        }
        else if(requestURI.contains("/delete")) {
            processRequest(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if(requestURI.contains("/deleteAccount")) {
            processRequestAccount(req, resp);
        }
        else if(requestURI.contains("/deleteBlog")) {
            processRequestBlog(req, resp);
        }
        else if(requestURI.contains("/deleteProduct")) {
            processRequestProduct(req, resp);
        }
        else if(requestURI.contains("/delete")) {
            processRequest(req, resp);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}