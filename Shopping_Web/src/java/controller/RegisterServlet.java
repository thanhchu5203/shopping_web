package controller;

import dal.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");

        // Validate the input fields
        if (user == null || user.isEmpty() ||
            name == null || name.isEmpty() ||
            pass == null || pass.isEmpty() ||
            email == null || email.isEmpty() ||
            dob == null || dob.isEmpty() ||
            mobile == null || mobile.isEmpty() ||
            address == null || address.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        AccountDAO accountDAO = new AccountDAO();
        
        // Check if the account already exists
        if (accountDAO.accountExists(user)) {
            request.setAttribute("error", "Username already exists.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Register the account
        boolean isRegistered = accountDAO.registerAccount(user, pass, name, email, dob, mobile, address);

        if (isRegistered) {
            response.sendRedirect("login.jsp"); // Redirect to the login page after successful registration
        } else {
            request.setAttribute("error", "Registration failed. Please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
