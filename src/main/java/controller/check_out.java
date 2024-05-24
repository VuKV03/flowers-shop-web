package controller;

import dao.DAO;
import model.Account;
import model.Order_History;
import model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet("/cart-check-out")
public class check_out extends HttpServlet{

    public String RandGeneratedStr(int l)

    {

        // a list of characters to choose from in form of a string

        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

        // creating a StringBuffer size of AlphaNumericStr

        StringBuilder s = new StringBuilder(l);

        int i;

        for ( i=0; i<l; i++) {

            //generating a random number using math.random()


            int ch = (int)(AlphaNumericStr.length() * Math.random());

            //adding Random character one by one at the end of s

            s.append(AlphaNumericStr.charAt(ch));

        }

        return s.toString();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            String bill_code=RandGeneratedStr(10);
            HttpSession session = request.getSession();
            session.setAttribute("bill_code", bill_code);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Account a = (Account) request.getSession().getAttribute("acc");
            DAO dao= new DAO();
            List<Order_History> listOrder_History = new ArrayList();
            List<Orders> cart_list=dao.getAllOrders(a.getId());

            if(cart_list.size() >0 && a!=null) {
                for(Orders c:cart_list) {

                    Order_History order = new Order_History();

                    order.setP_id(c.getIdProduct());
                    order.setU_id(a.getId());
                    order.setO_quantity(c.getQuantity());
                    order.setTotalPrice(c.getTotalPrice());
                    order.setDate(formatter.format(date));
                    order.setBill_code(bill_code);

                    dao.deleteCart_Product(c.getIdProduct(),a.getId());

                    boolean result = dao.insertOrder_History(order);
                    if(!result) break;
                }



                cart_list.clear();
                response.sendRedirect("cart");


            }else {
                if(a == null) {
                    response.sendRedirect("signin.jsp");
                }
                else response.sendRedirect("home");
            }
        } catch (Exception e) {

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
