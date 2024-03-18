/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import model.Carrera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Mati
 */
public class Sql {
    
    private Carrera car;
    private Connection conexion;

    public Sql(){}
    public Sql(Carrera car, Connection conexion) {
        setCar(car);
        setConexion(conexion);
    }



    public void insertData(Connection con, String table, String columna, String inputCarrera) {
        try {
            String SQLQuery = "INSERT INTO " + table + " (" + columna + ") VALUES (?)";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setString(1, inputCarrera);
            pt.executeUpdate();
            System.out.println("Se ha insertado el registro correctamente");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error insertando los datos: " + e.getMessage());
        }
    }

    public void readAndPrintData(String table, String columna, Connection con) {
        try {
            String SQLQuery = "SELECT * FROM " +table;
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " +rs.getString("id") + " " + columna + ": " +rs.getString(columna));
            }
        } catch (SQLException ex){
            System.out.println("Error en la adquisición de datos");
        }
    }


    public static void deleteData(String table, int id, Connection con){
        try {
            String SQLQuery = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setInt(1, id);
            pt.executeUpdate();
            System.out.println("Se ha eliminado la fila correctamente");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error borrando los datos seleccionados: " + e.getMessage());
        }
    }
    public static void updateData(String table, String columna, String nombreAntiguo, String nombreNuevo, Connection con) {
        try {
            String query = "UPDATE " + table + " SET " + columna + " = ? WHERE " + columna + " LIKE ?"; 
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, nombreNuevo); 
            pt.setString(2, nombreAntiguo); 
            pt.executeUpdate();
            System.out.println("Datos actualizados correctamente.");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error actualizando los datos: " + e.getMessage());
        }
    }
  
    public Carrera getCar() {
        return car;
    }

    public void setCar(Carrera car) {
        this.car = car;
    }

    public Connection getCon(){
        return conexion;
    }
            
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
