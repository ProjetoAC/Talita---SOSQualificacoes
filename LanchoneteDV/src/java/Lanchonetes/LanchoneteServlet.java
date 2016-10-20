/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lanchonetes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gilvan Honorato
 */
public class LanchoneteServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LacnchoneteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LacnchoneteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        processRequest(request, response);
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
        
        if(request.getParameter("nome").isEmpty()
                ||request.getParameter("rua").isEmpty()
                || request.getParameter("numero").isEmpty()
                || request.getParameter("bairro").isEmpty()
                || request.getParameter("cidade").isEmpty()
                || request.getParameter("telefone").isEmpty()
                || request.getParameter("email").isEmpty()
                || request.getParameter("senha").isEmpty()
                || request.getParameter("confirmacao_senha").isEmpty()){
            request.setAttribute("erro", "Preencha todos os campos corretamente");
            request.getRequestDispatcher("Cadastros_Estabelecimentos.jsp").forward(request, response);
        }
        else{
        
        
        String nome = request.getParameter("nome");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmacao_senha = request.getParameter("confirmacao_senha");
        
        
        LanchoneteDAO.salvar(nome,rua,numero,bairro,cidade,telefone,email,senha,confirmacao_senha);
        
        request.setAttribute("sucesso", "Cadastro realizado com sucesso");
        request.getRequestDispatcher("Cadastros_Estabelecimentos.jsp").forward(request, response);
       
    }

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
