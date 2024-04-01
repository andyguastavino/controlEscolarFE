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
import java.sql.*;


/**
 *
 * @author 39348
 */
@WebServlet(urlPatterns = {"/Crear"})
public class Crear extends HttpServlet {

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
             RequestDispatcher dispatcher = request.getRequestDispatcher("crearCarrera.jsp");
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
        
        // Recuperar los datos del formulario
        String nombreCarrera = request.getParameter("nombreCarrera");

        // Crear una instancia de DbConnect para obtener la conexión
        Connection conexion = null;
        System.out.println("Todavia no cree conexion");


        try {
            // Cargar el controlador JDBC y establecer la conexión
            DbConnect.loadDriver();
            DbConnect db = new DbConnect();
            conexion = db.getConexion();
              if (conexion != null) {
                System.out.println("Conexión establecida correctamente");
            } else {
                System.out.println("Error al establecer la conexión");
            }

            // Crear una instancia de Sql para realizar la operación de inserción
            Sql sql = new Sql();
            sql.insertData(conexion, "carreras", "nombre", nombreCarrera);

            // Redireccionar a alguna página de éxito
            response.sendRedirect("exito.jsp");

        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier excepción
            
            // Redireccionar a una página de error
            response.sendRedirect("error.jsp");

        } finally {
            // Cerrar la conexión en el bloque finally para asegurarse de que siempre se cierre
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                   e.getErrorCode();
                }
            }
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
