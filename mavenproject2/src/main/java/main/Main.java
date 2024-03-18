package main;
import db.*;
import model.Carrera;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license


/**
 *
 * @author Mati
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner in = new Scanner(System.in);
        DbConnect.loadDriver();
        DbConnect dbConnect = new DbConnect();
        Connection con = dbConnect.getConexion();
        Carrera car = new Carrera();
        Sql controlEscolar = new Sql(car, con);
        int inUsuario, nextIntInput;
        String nextInput1,nextInput2; //1 y 2 para el caso particular en el que deseemos actualizar datos de una columna específica, necesitaremos ingresar el valor que deseamos actualizar y el valor que queremos
        do{
            System.out.printf("1.Insertar datos en la base de datos\n2.Leer datos de la base de datos\n3.Actualizar datos de la base de datos\n4.Borrar datos de la base de datos\n0.Salir\n");
            inUsuario = in.nextInt();
            in.nextLine();
            switch(inUsuario){
                case 1:
                    //Aquí sería preciso pedir al usuario a qué tabla acceder, como solo tenemos 1 aun no lo hacemos. También cabe destacar que, para tablas que tengan más de una columna hay que preguntarle al usuario qué columnas quiere modificar (en este caso solo hay nombre)
                    System.out.println("Ingrese el nombre de la carrera que desea ingresar");
                    nextInput1 = in.nextLine();
                    controlEscolar.insertData(con, car.getTable(),car.getColumna1(),nextInput1);                    
                    break;
                case 2:
                    controlEscolar.readAndPrintData(car.getTable(),car.getColumna1(), con);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la carrera que quiere actualizar y la nueva en ese orden");
                    nextInput1 = in.nextLine();
                    nextInput2 = in.nextLine();
                    controlEscolar.updateData(car.getTable(), car.getColumna1(),nextInput1,nextInput2,con);
                    break;
                case 4:
                    System.out.println("Ingrese el 'id' de la fila que quiere borrar");
                    nextIntInput = in.nextInt();
                    in.nextLine();
                    controlEscolar.deleteData(car.getTable(), nextIntInput,con);
                    break;                            
                    }
        }while(inUsuario!=0);
        con.close();
        in.close();
    }
}

