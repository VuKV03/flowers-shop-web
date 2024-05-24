package controller;

import dao.DAO;
import model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;

@WebServlet(name = "SignUpControl", urlPatterns = "/signup")
public class SignUpControl extends HttpServlet {

    //add
    public Boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //add
    public static Boolean isValidPhone(String phone) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
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

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name_user = request.getParameter("name_user");
        String username = request.getParameter("user");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("pass");
        String re_pass = request.getParameter("repass");

        StringBuilder errorMessage = new StringBuilder();

        if (!isValidEmail(email)) {
            errorMessage.append("Invalid Email!");
        }
        if (!isValidPhone(phone)) {
            errorMessage.append("Invalid Phone!");
        }
        if (!password.equals(re_pass)) {
            errorMessage.append("Invalid Password!");
        }

        if (errorMessage.length() > 0) {
            // Có ít nhất một lỗi xảy ra
            request.setAttribute("mes", errorMessage.toString());
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            DAO dao = new DAO();
            Account a = dao.checkAccountExist(username, email, phone);
            if (a == null) {
                try {
                    password = toHexString(getSHA(password));
                } catch (NoSuchAlgorithmException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //dc signup
                dao.signup(name_user, username, password, email, phone);
                request.setAttribute("mes", "Successful account registration. Please login here!");
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            } else {
                request.setAttribute("mes", "Account containing information already exists!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
