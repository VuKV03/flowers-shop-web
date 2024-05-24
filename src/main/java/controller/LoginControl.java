package controller;

import dao.DAO;
import model.Account;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebServlet(name = "LoginControl", urlPatterns = "/login")
public class LoginControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cookie arr[] = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("userC")) {
                    request.setAttribute("username", o.getValue());
                }
                if (o.getName().equals("passC")) {
                    request.setAttribute("password", o.getValue());
                }
            }
        }
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // get parameter from HTML
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");

        // using cookie for save account
        Cookie u = new Cookie("userC", userName);
        Cookie p = new Cookie("passC", password);

        // set time storing for username
        u.setMaxAge(60 * 60 * 24 * 30);

        // Save to brower
        response.addCookie(u);
        response.addCookie(p);


        // Check valid userName and password
        HttpSession httpSession = request.getSession();

        DAO dao = new DAO();
        try {
            password = toHexString(getSHA(password));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Account a = dao.login(userName, password);

        if (a == null) {
            request.setAttribute("error", "Wrong username or password");
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        } else {
            httpSession.setAttribute("acc", a);
            response.sendRedirect("home");
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

}
