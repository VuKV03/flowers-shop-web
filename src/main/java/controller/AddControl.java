package controller;

import dao.DAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "AddControl", value = "/add")
@MultipartConfig
public class AddControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pname = request.getParameter("name");
        String pdescription = request.getParameter("description");
        String pcostPrice = request.getParameter("cost_price");
        String psalePrice = request.getParameter("sale_price");
        String pimagePrimary = request.getParameter("image_primary");
        String pimageSecondary = request.getParameter("image_secondary");
        String pcategory = request.getParameter("cate");

        Part imagePart = request.getPart("image_primary"); 
        String fileName = imagePart.getSubmittedFileName();
        
        InputStream inputStream = imagePart.getInputStream();
        System.out.println(getServletContext().getRealPath("/assets"));
        String path = getServletContext().getRealPath("/assets");
        
        String savePath = path + "/img/";
        pimagePrimary = "./assets/img/" + fileName;
        Files.copy(inputStream, Paths.get(savePath + fileName), StandardCopyOption.REPLACE_EXISTING);   
        
        imagePart = request.getPart("image_secondary"); 
        fileName = imagePart.getSubmittedFileName();
        
        inputStream = imagePart.getInputStream();
        System.out.println(getServletContext().getRealPath("/assets"));
        path = getServletContext().getRealPath("/assets");
        
        savePath = path + "/img/";
        pimageSecondary = "./assets/img/" + fileName;
        Files.copy(inputStream, Paths.get(savePath + fileName), StandardCopyOption.REPLACE_EXISTING);
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();

        DAO dao = new DAO();
        dao.addProduct(pname, pdescription, pcostPrice, psalePrice, pimagePrimary, pimageSecondary, pcategory, sid);
        response.sendRedirect("manage");
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
