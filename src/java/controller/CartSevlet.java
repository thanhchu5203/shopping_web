/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author Lewis
 */
@WebServlet(name = "CartSevlet", urlPatterns = {"/cart"})
public class CartSevlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartSevlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartSevlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Cart cart = new Cart(new ArrayList<Item>());
            if (session.getAttribute("cart") != null) {
                cart = (Cart) session.getAttribute("cart");
            }
            String tid = request.getParameter("id");
            int num, id;
            List<Item> list = cart.getItems();
            
            num = 1;
            id = Integer.parseInt(tid);
            
            ProductDAO pdb = new ProductDAO();
            Product p = pdb.getProductById(id);
            double price = p.getProductPrice();
            Item t = new Item(p, num, price);
            cart.addItem(t);

            session.setAttribute("num", num);
            session.setAttribute("cart", cart);
            session.setAttribute("size", list.size());
            response.sendRedirect("shop");
        } catch (NumberFormatException e) {
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        for (Item item : list) {
//                if (item.getQuantity() == 4) {
//                    num = 2;
//                }
//                if (item.getQuantity() > 5) {
//                    num = 3;
//                }
//            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
