/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2.config.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnect {
    
//com.mysql.cj.jdbc.MysqlDataSource
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String PROTOCOL = "jdbc:mysql:";
    public static final String HOST = "localhost";
    public static final String BD_NAME = "bd_institucion";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static String BD_URL;
    private Connection conexion;
    
    public static void loadDriver() throws ClassNotFoundException {
        //getConnectionProperties(); better if connection properties are read from a configuration file
        Class.forName(DRIVER);
        BD_URL = String.format("%s//%s/%s?useSSL=false&currentSchema=%s", PROTOCOL, HOST, BD_NAME, BD_NAME);
    }
    
    /**
     * gets and returns a connection to database
     *
     * @return connection
     * @throws java.sql.SQLException
     */
    public Connection getConexion() throws SQLException {
        conexion = DriverManager.getConnection(BD_URL, USER, PASSWORD);
        return conexion;
    }
    public void Close()throws SQLException {
        conexion.close();
    }   
}