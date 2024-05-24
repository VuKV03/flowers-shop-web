package controller;

import dao.DAO;
import model.Account;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerProduct", urlPatterns = "/manage")
public class ManagerProduct extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();

        DAO dao = new DAO();
        List<Product> list = dao.getProductBySellID(id);
        List<Category> listC = dao.getAllCategory();
        int number = dao.getNumberPage(id);

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        List<Product> list1 = dao.getPaging(indexPage, id);

        request.setAttribute("listPage", list1);
        request.setAttribute("indexPage", indexPage);
        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("num", number);
        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
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
