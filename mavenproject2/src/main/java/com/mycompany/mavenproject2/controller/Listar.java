package com.mycompany.mavenproject2.controller;

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
import com.mycompany.mavenproject2.config.db.DbConnect;
import com.mycompany.mavenproject2.config.db.Sql;
import java.util.List;




import java.sql.Connection;
import java.sql.SQLException;
import com.mycompany.mavenproject2.model.Carrera;


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
        
        // Crear una conexión
        Connection conexion = null;

        try {
            // Obtener la conexión de la clase DbConnect
            DbConnect.loadDriver();
            DbConnect db = new DbConnect();
            conexion = db.getConexion();

            // Verificar si la conexión es nula
            if (conexion == null) {
                throw new SQLException("Error al establecer la conexión");
            }
            else {
                System.out.println("Conexion establecida correctamente");
                 }
            
            // Crear una instancia de Sql para realizar la operación de inserción
            Sql sql = new Sql();

            // Obtener la lista de carreras
            List<Carrera> carreras = sql.getCarreras(conexion);

            // Establecer la lista de carreras como atributo de solicitud
            request.setAttribute("carreras", carreras);

            // Redireccionar al archivo JSP
            request.getRequestDispatcher("listarCarrera.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier excepción
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

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
        // Crear una conexión
        Connection conexion = null;
                try {
            // Obtener la conexión de la clase DbConnect
            DbConnect.loadDriver();
            DbConnect db = new DbConnect();
            conexion = db.getConexion();

            // Verificar si la conexión es nula
            if (conexion == null) {
                throw new SQLException("Error al establecer la conexión");
            }
            else {
                System.out.println("Conexion establecida correctamente");
                 }
            
            // Crear una instancia de Sql para realizar la operación de inserción
            Sql sql = new Sql();
             // Obtener el ID de la carrera a eliminar desde la solicitud
            int idCarrera = Integer.parseInt(request.getParameter("idCarrera"));

        // Llamar a la función para eliminar la carrera
            sql.deleteCarrera(idCarrera, conexion);
            

          

        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier excepción
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

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
        System.out.println("HOLA ESTOY EN EL DELETE");
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
