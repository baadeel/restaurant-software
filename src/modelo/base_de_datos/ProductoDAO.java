/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.base_de_datos;

import modelo.entidades.Producto;
import java.util.*;

/**
 *
 * @author Badal
 */
public class ProductoDAO {

  public Producto insertar(String nombre, double pvp, String tipo) {
    String query = "INSERT INTO producto (nombre, tipo_producto, pvp) VALUES ('"
            + nombre + "','"
            + tipo + "',"
            + pvp + ")";
    if (new BD().actualizar(query) > 0) {
      Producto pr = new Producto(nombre, tipo, pvp);
      return pr;
    }
    return null;
  }
  
  public int eliminar(int id){
    String query = "DELETE FROM producto WHERE id_producto = " + id;
    return new BD().actualizar(query);
  }
  
  public List obtenerProductos(){
    String query = "SELECT * FROM producto";
    List<Map> registros = new BD().ejecutar(query);
    List<Producto> productos = new ArrayList();
    for(Map registro : registros){
      Producto pr = new Producto(
              (int) registro.get("id_producto"), 
              (String) registro.get("nombre"),
              (String) registro.get("tipo_producto"),
              ((java.math.BigDecimal) registro.get("pvp")).doubleValue());
      productos.add(pr);
    }
    return productos;
  }
  
  public int obtenerIdPorNombre(String nombre){
    String query = "SELECT id_producto FROM producto WHERE nombre = '" + nombre + "'";
    List<Map> registros = new BD().ejecutar(query);
    for (Map registro : registros) {
      int idProducto = (int) registro.get("id_producto");
      return idProducto;
    }
    return 0;
  }
}
