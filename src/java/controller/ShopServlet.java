/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Lewis
 */
@WebServlet(name="ShopServlet", urlPatterns={"/shop"})
public class ShopServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet ShopServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String fromPrice = request.getParameter("fromPrice");
        String toPrice = request.getParameter("toPrice");
        String sortType = request.getParameter("sortType");
        String search = request.getParameter("search");
        ProductDAO pdb = new ProductDAO();
        CategoryDAO cbd = new CategoryDAO();
        List<Category> list2 = cbd.getAll();
        List<Product> list1;
        
        String id_raw = request.getParameter("id");
        int id;
        if (id_raw == null) {
            id = 0;
        } else {
            id = Integer.parseInt(id_raw);
        }
        if(id == 0){
            list1 = pdb.getAllByDetail(search, fromPrice, toPrice, sortType);
        }else{
            String cid = ""+id;
            list1 = pdb.getProductBySearch(cid,search, fromPrice, toPrice, sortType);
        }
        String numb = request.getParameter("numperpage");
        int numset, numperpage;
        if(numb == null){
            numset = 9;
        }
        else{
            numset = Integer.parseInt(numb);
        }
        numperpage = numset;
        int num, page, size;
        size = list1.size();
        num = (size % numperpage == 0 ? (size / numperpage) : (size / numperpage + 1));
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = numperpage * (page - 1);
        /*
        start firstPage = 0;
        if size =14 page = 3, 3*6=18 choose 14, if page =2 page = 12 choose 12
         */
        end = Math.min(numperpage * page, size);
        List<Product> list = pdb.getListByPage(list1, start, end);
        request.setAttribute("data", list);
        request.setAttribute("num", num);
        request.setAttribute("page", page);
        request.setAttribute("id", id);
        request.setAttribute("cate", list2);
        request.setAttribute("numperpage", numperpage);
        request.setAttribute("sortType", sortType);
        request.setAttribute("fromPrice", fromPrice);
        request.setAttribute("toPrice", toPrice);
        request.setAttribute("search", search);
        request.getRequestDispatcher("shop-grid.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
