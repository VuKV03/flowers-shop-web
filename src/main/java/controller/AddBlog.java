package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DAO;

@WebServlet(name = "AddBlog", value = "/addBlog")
@MultipartConfig
public class AddBlog extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
         String title = request.getParameter("title");
         String description = request.getParameter("description");
         String image = request.getParameter("image");
         
         Part imagePart = request.getPart("image");
         String fileName = imagePart.getSubmittedFileName();
         
         InputStream inputStream = imagePart.getInputStream();

         System.out.println(getServletContext().getRealPath("/assets"));

         String path = getServletContext().getRealPath("/assets");
         
         String savePath = path + "/img/img-blog";
         image = "./assets/img/img-blog" + fileName;
         Files.copy(inputStream, Paths.get(savePath + fileName), StandardCopyOption.REPLACE_EXISTING);
   
         System.out.println("Thêm ảnh thành công");
         DAO dao = new DAO();
         dao.addBlog(image, title,description);
         response.sendRedirect("manageBlog");
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
