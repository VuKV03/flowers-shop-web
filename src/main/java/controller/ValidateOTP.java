package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ValidateOTP", value = "/newPassword")
public class ValidateOTP extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        String third = request.getParameter("third");
        String fourth = request.getParameter("fourth");
        String fifth = request.getParameter("fifth");
        String sixth = request.getParameter("sixth");

        String result = first + second + third + fourth + fifth + sixth;
        HttpSession session = request.getSession();
        int otp = (int) session.getAttribute("otp");
        RequestDispatcher dispatcher = null;


        if (result.equals(otp + "")) {

            request.setAttribute("email", request.getParameter("email"));
            dispatcher = request.getRequestDispatcher("new-password.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("validate", "OTP is wrong. Please re-enter.");
            dispatcher = request.getRequestDispatcher("otp.jsp");
            dispatcher.forward(request, response);
        }
    }
}
