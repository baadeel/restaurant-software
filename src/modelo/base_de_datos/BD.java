/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.base_de_datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author Badal
 */
public class BD {

  Connection cn;
  private final String HOST = "jdbc:mysql://localhost/restaurante";
  private final String USER = "root";
  private final String PASS = "";

  public BD(){         
    try {      
      cn = DriverManager.getConnection(HOST, USER, PASS);  
      
    } catch (SQLException ex) {  
      Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }   
  }
  
  public int actualizar(String consulta){
    try(Statement st = cn.createStatement()) {
       return st.executeUpdate(consulta);
      
    } catch (SQLException ex) {
      Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    cerrarConexion();
    return 0;
  }
  
  public List ejecutar(String consulta){
    List resultado = new ArrayList();
    
    try (Statement st = cn.createStatement()){
      try (ResultSet rs = st.executeQuery(consulta)){
        resultado = organizarDatos(rs);
      }   
    } catch (SQLException ex) {
      Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    cerrarConexion();
    return resultado;
  }
  
  public List organizarDatos(ResultSet rs){
      List filas = new ArrayList();
    try {
      int cantColumnas = rs.getMetaData().getColumnCount();
      while (rs.next()){
        Map<String, Object> fila = new HashMap();
        for(int i = 1; i <= cantColumnas; i++){
          String nombreColumna = rs.getMetaData().getColumnName(i);
          Object valor = rs.getObject(nombreColumna);
          fila.put(nombreColumna, valor);
        }
        filas.add(fila);
      }
    } catch (SQLException ex) {
      Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    cerrarConexion();
    return filas;
  }
  
  public void cerrarConexion(){
    try{
      cn.close();
    } catch (SQLException e){
      e.printStackTrace();
    }
  }
  
  
  
  
  
}
