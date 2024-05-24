package controller;

import dao.DAO;
import model.Account;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@WebServlet(name = "EditControl", urlPatterns = {"/edit", "/editAccount", "/editBlog"})
@MultipartConfig
public class EditControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pid = request.getParameter("id");
        String pname = request.getParameter("name");
        String pdescription = request.getParameter("description");
        String pcostPrice = request.getParameter("cost_price");
        String psalePrice = request.getParameter("sale_price");
        String pimagePrimary = request.getParameter("img_primarys");
        String pimageSecondary = request.getParameter("img_seconds");
        String pcategory = request.getParameter("cate");

        Part imagePart = request.getPart("img_primary"); 
        String fileName = imagePart.getSubmittedFileName();
        
        if(!fileName.equals("")) {
        	InputStream inputStream = imagePart.getInputStream();
            System.out.println(getServletContext().getRealPath("/assets"));
            String path = getServletContext().getRealPath("/assets");
            
            String savePath = path + "/img/";
            pimagePrimary = "./assets/img/" + fileName;
            Files.copy(inputStream, Paths.get(savePath + fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        
         imagePart = request.getPart("img_second"); 
         fileName = imagePart.getSubmittedFileName();
        
        if(!fileName.equals("")) {
        	InputStream inputStream = imagePart.getInputStream();
            System.out.println(getServletContext().getRealPath("/assets"));
            String path = getServletContext().getRealPath("/assets");
            
            String savePath = path + "/img/";
            pimageSecondary = "./assets/img/" + fileName;
            Files.copy(inputStream, Paths.get(savePath + fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        
        
        DAO dao = new DAO();
        dao.editProduct(pname, pdescription, pcostPrice, psalePrice, pimagePrimary, pimageSecondary, pcategory, pid);
        response.sendRedirect("manage");
    }

    protected void processRequestAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pid = request.getParameter("id");
        String pname = request.getParameter("name");
        String pisSell = request.getParameter("role");
        String pemail = request.getParameter("email");
        String pphone = request.getParameter("phone");
        
        DAO dao = new DAO();
        dao.editAccount(pid, pname, pisSell, pemail, pphone);
        response.sendRedirect("manageUser");
    }

    protected void processRequestBlog(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pid = request.getParameter("id");
        String pimage = request.getParameter("images");
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");

        
        Part imagePart = request.getPart("image"); // "imageName" là tên của trường file trong form gửi đi
        String fileName = imagePart.getSubmittedFileName();
        
        if(!fileName.equals("")) {
        	InputStream inputStream = imagePart.getInputStream();
            System.out.println(getServletContext().getRealPath("/assets"));
            String path = getServletContext().getRealPath("/assets");
            String savePath = path + "/img/";
            pimage = "./assets/img/" + fileName;
            Files.copy(inputStream, Paths.get(savePath + fileName), StandardCopyOption.REPLACE_EXISTING);
        }
       
        DAO dao = new DAO();
        dao.editBlog(pid, pimage, ptitle, pdescription);
        response.sendRedirect("manageBlog");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if(requestURI.contains("/editAccount")) {
            processRequestAccount(req, resp);
        }
        else if(requestURI.contains("/editBlog")) {
            processRequestBlog(req, resp);
        }
        else if(requestURI.contains("/edit")) {
            processRequest(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if(requestURI.contains("/editAccount")) {
            processRequestAccount(req, resp);
        }
        else if(requestURI.contains("/editBlog")) {
            processRequestBlog(req, resp);
        }
        else if(requestURI.contains("/edit")) {
            processRequest(req, resp);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}