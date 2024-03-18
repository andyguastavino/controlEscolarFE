/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mati
 */

public class Carrera{
    private static final String TABLE_NAME = "carreras";
    private static final String COLUMN_NAME_1 = "nombre";
    
    
    private String table;
    private String columna1;
    private String nombre;
    int id;
    
    public Carrera(){
        setTable(TABLE_NAME);
        setColumna1(COLUMN_NAME_1);
    }
    public Carrera(int idp, String nombrep){
        setId(idp);
        setNombre(nombrep);
        setTable(TABLE_NAME);
        setColumna1(COLUMN_NAME_1);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTable(){
        return table;
    }
    
    public void setTable(String table){
        this.table = table;
    }
    
    public String getColumna1() {
        return columna1;
    }

    public void setColumna1(String columna1) {
        this.columna1 = columna1;
    }
}
