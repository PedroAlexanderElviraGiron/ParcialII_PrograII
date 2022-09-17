/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialii;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Pedro
 */
public class ParcialII {
    //SUMAORIA DE LOS MESES DE CADA EMPLEADO
    public static void meses(){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbparcial?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","mamikeka12*");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM dbparcial.tbparcial";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            int r1=0; 
             int r2=0; 
             int r3=0; 
             int r4=0; 
             int r5=0; 
             int r6=0; 
             int e=0; 
             int f=0; 
             int m=0; 
             int a=0; 
             int my=0; 
             int j=0; 
            while(resultado.next()){ 
                System.out.println("NIV ="+resultado.getInt(2)); 
                System.out.println("Nombre = "+resultado.getString(3)); 
                System.out.println("Enero ="+resultado.getInt(4)); 
                r1=resultado.getInt(4); 
                e=e+r1; 
                System.out.println("Febrero ="+resultado.getInt(5)); 
                 r2=resultado.getInt(5); 
                 f=f+r2; 
                System.out.println("Marzo ="+resultado.getInt(6)); 
                r3=resultado.getInt(6); 
                m=m+r3; 
                System.out.println("Abril ="+resultado.getInt(7)); 
                r4=resultado.getInt(7); 
                a=a+r4; 
                System.out.println("Mayo ="+resultado.getInt(8)); 
                r5=resultado.getInt(8); 
                my=my+r5; 
                System.out.println("Junio ="+resultado.getInt(9)); 
                r6=resultado.getInt(9); 
                j=j+r6; 
            } 
            System.out.println("El resultado de las ventas de Enero es de Q"+e); 
            System.out.println("El resultado de las ventas de Febrero es de Q"+f); 
            System.out.println("El resultado de las ventas de Marzo es de Q"+m); 
            System.out.println("El resultado de las ventas de Abril es de Q"+a); 
            System.out.println("El resultado de las ventas de Mayo es de Q"+my); 
            System.out.println("El resultado de las ventas de Junio es de Q"+j);
            } catch (SQLException ex) {
            System.out.println("Hubo un problema="+ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
    
    //consulta con NIV 
    public static void consul(int id){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbparcial?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","mamikeka12*");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM tbparcial  where NIV = "+id;
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
         int rr=0; 
            while(resultado.next()){ 
                System.out.println("NIV ="+resultado.getInt(2)); 
                System.out.println("Nombre = "+resultado.getString(3)); 
                System.out.println("Enero ="+resultado.getInt(4)); 
                rr=resultado.getInt(4); 
                System.out.println("Febrero ="+resultado.getInt(5)); 
                 rr=rr+resultado.getInt(5); 
                System.out.println("Marzo ="+resultado.getInt(6)); 
                rr=rr+resultado.getInt(6); 
                System.out.println("Abril ="+resultado.getInt(7)); 
                rr=rr+resultado.getInt(7); 
                System.out.println("Mayo ="+resultado.getInt(8)); 
                rr=rr+resultado.getInt(8); 
                System.out.println("Junio ="+resultado.getInt(9)); 
                rr=rr+resultado.getInt(9); 
            } 
            System.out.println("El resultado de las ventas es de Q"+rr);
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
        
}
    
    //DELETE POR NIV 
    public static void delet(int id){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbparcial?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","mamikeka12*");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion en la cual indicamos que elimine el delete
            String sql = "delete from tbparcial where NIV ="+id ;
            
            //este print nos sirve para analizar qué instrucción sql se va a ejecutar
            //System.out.println(sql);
            // paso 5 ejecutamos el query
            // tome atención que es diferente del paso 5 de la funcion ej1
            sentencia.execute(sql);
           
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}
    //UPDATE POR NIV 
    public static void subi(String nombre, int id){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbparcial?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","mamikeka12*");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "update dbparcial.tbparcial set nombre = '"+nombre+"' where NIV = "+id;
            // paso 5 ejecutamos el query
            sentencia.execute(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
        } catch (SQLException ex) {
            System.out.println("Hubo problem = "+ex.getMessage());
            
        }
}

        public static void main(String[] args) throws IOException {
        //meses();
        //consul(92025);
      
        //UPDATE
      BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
      String linea="",Linea2=""; 
             int num1; 
             System.out.println("Ingrese el NIV de la persona a Actualizar:"); 
             linea = lector.readLine(); 
             num1 = Integer.parseInt(linea); 
             System.out.println("Escriba el nuevo nombre"); 
             Linea2 = lector.readLine(); 
              subi(Linea2,num1);
              
        //ELIMINAR DELETE 
//        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in)); 
//        String linea,Linea2; 
//        int num1,num2; 
//        try { 
//             System.out.println("Ingrese el NIV de la persona a borrar:"); 
//             linea = lector.readLine(); 
//             num1 = Integer.parseInt(linea); 
//             System.out.println("Escriba 1 si esta seguro de eliminarlo o 2 Si no lo quiere eliminar"); 
//             Linea2 = lector.readLine(); 
//             num2 = Integer.parseInt(Linea2); 
//             if(num2==1){ 
//              delet(num1);             
//             } 
//        }  
//        catch(IOException e) { 
//            throw new RuntimeException(e); 
//        }
            
    }
        
}
