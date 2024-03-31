/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import db.DbConnect;
import db.Sql;




import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author 39348
 */
@WebServlet(urlPatterns = {"/Listar"})
public class Listar extends HttpServlet {

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
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarCarrera.jsp");
            dispatcher.include(request,response);
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
        
        // Establecer el tipo de contenido de la respuesta
        response.setContentType("text/html;charset=UTF-8");

        // Establecer PrintWriter para escribir la respuesta
        PrintWriter out = response.getWriter();

        // Crear una conexión
        Connection conexion = null;

        try {
            // Obtener la conexión de la clase DbConnect
            DbConnect.loadDriver();
            DbConnect db = new DbConnect();
            conexion = db.getConexion();

            // Verificar si la conexión es nula
            if (conexion == null) {
                out.println("Error al establecer la conexión");
                return;
            }
             // Crear una instancia de Sql para realizar la operación de inserción
            Sql sql = new Sql();

            // Llamar a la función readAndPrintData para obtener los datos de la tabla 'carreras'
            out.println("<html><body>");
            out.println("<h2>Carreras:</h2>");
            out.println("<table border='1'>");
            sql.readAndPrintData("carreras", "nombre", conexion); // Llamada a la función
            out.println("</table>");
            out.println("</body></html>");

        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier excepción
            out.println("Error: " + e.getMessage());

        } finally {
            // Cerrar la conexión
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    // Manejar cualquier excepción
                }
            }
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
