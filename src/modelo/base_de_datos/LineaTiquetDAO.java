/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.base_de_datos;

import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.SwingConstants;
import modelo.entidades.LineaTiquet;

/**
 *
 * @author Badal
 */
public class LineaTiquetDAO {

  public LineaTiquet insertarProducto(int idLinea, int cantidad, double precio, int idProducto, int numeroMesa, int idEmpleado, int pagado) {
    String query = "INSERT INTO linea_tiquet (id_linea, cantidad, precio, id_producto, numero_mesa, id_empleado, pagado) VALUES ("
            + idLinea + ","
            + cantidad + ","
            + precio + ","
            + idProducto + ","
            + numeroMesa + ","
            + idEmpleado + ","
            + pagado + ")";
    if (new BD().actualizar(query) > 0) {
      LineaTiquet lt = new LineaTiquet(idLinea, cantidad, precio, idProducto, numeroMesa, idEmpleado, pagado);
      return lt;
    }
    return null;
  }

  public int sumarCantidad(int idLinea, int idProducto) {
    String query = "UPDATE linea_tiquet SET cantidad = cantidad + 1 , precio = cantidad * "
            + "(SELECT pvp FROM producto WHERE id_producto = " + idProducto + ") "
            + "WHERE id_linea = " + idLinea + " AND id_producto = " + idProducto;
    if (new BD().actualizar(query) > 0) {
      return 1;
    }
    return 0;
  }

  public int restarCantidad(int idLinea, int idProducto) {
    String query = "UPDATE linea_tiquet SET cantidad = cantidad - 1 , precio = cantidad * "
            + "(SELECT pvp FROM producto WHERE id_producto = " + idProducto + ") "
            + "WHERE id_linea = " + idLinea + " AND id_producto = " + idProducto;
    if (new BD().actualizar(query) > 0) {
      return 1;
    }
    return 0;
  }

  public int eliminar(int idLinea, int idProducto) {
    String query = "DELETE FROM linea_tiquet WHERE id_linea = " + idLinea + " AND id_producto = " + idProducto;
    return new BD().actualizar(query);
  }

  public List obtenerOrden(int numeroMesa) {
    String query = "SELECT lt.cantidad, pr.nombre, pr.pvp, lt.precio FROM linea_tiquet lt JOIN producto pr\n"
            + "ON lt.id_producto = pr.id_producto WHERE lt.pagado = 0 AND lt.numero_mesa = " + numeroMesa;
    List<Map> registros = new BD().ejecutar(query);
    List<LineaTiquet> orden = new ArrayList();
    for (Map registro : registros) {
      LineaTiquet lt = new LineaTiquet(
              (int) registro.get("cantidad"),
              (String) registro.get("nombre"),
              ((BigDecimal) registro.get("pvp")).doubleValue(),
              ((BigDecimal) registro.get("precio")).doubleValue());
      orden.add(lt);
    }
    return orden;
  }

  public int obtenerId(int numeroMesa) {
    String query = "SELECT id_linea FROM linea_tiquet WHERE numero_mesa = " + numeroMesa + " AND pagado = 0";
    List<Map> registros = new BD().ejecutar(query);
    for (Map registro : registros) {
      int idLinea = (int) registro.get("id_linea");
      return idLinea;
    }
    return 0;
  }

  public String obtenerNombre(int numeroMesa) {
    String query = "SELECT nombre FROM empleado e JOIN linea_tiquet lt ON e.id_empleado = lt.id_empleado AND lt.pagado = 0 "
            + "AND lt.numero_mesa = " + numeroMesa;
    List<Map> registros = new BD().ejecutar(query);
    for (Map registro : registros) {
      String nombre = (String) registro.get("nombre");
      return nombre;
    }
    return "";
  }

  public double obtenerTotal(int numeroMesa) {
    int idLinea = obtenerId(numeroMesa);
    String query = "SELECT SUM(precio) as total FROM linea_tiquet lt WHERE lt.id_linea = " + idLinea;
    List<Map> registros = new BD().ejecutar(query);
    for (Map registro : registros) {
      if (registro.get("total") != null) {
        double total = ((BigDecimal) registro.get("total")).doubleValue();
        return total;
      }
    }
    return 0;
  }

  public int obtenerUltimoId() {
    String query = "SELECT MAX(id_linea) as max FROM linea_tiquet";
    List<Map> registros = new BD().ejecutar(query);
    if (registros != null) {
      for (Map registro : registros) {
        Object maxIdObject = registro.get("max");
        if (maxIdObject != null) {
          int maxId = (int) maxIdObject;
          System.out.println(maxId);
          return maxId;
        }
      }
    }
    return 0;
  }

  public int obtenerIdEmpleadoPorNombre(String nombre) {
    String query = "SELECT id_empleado FROM empleado WHERE nombre = '" + nombre + "'";
    List<Map> registros = new BD().ejecutar(query);
    for (Map registro : registros) {
      int idEmpleado = (int) registro.get("id_empleado");
      return idEmpleado;
    }
    return 0;
  }

  public boolean comprobarProductoOrden(int idLinea, int idProducto) {
    String query = "SELECT id_producto FROM linea_tiquet WHERE id_linea = " + idLinea + " AND id_producto = " + idProducto;
    List<Map> registros = new BD().ejecutar(query);
    for (Map registro : registros) {
      return true;
    }
    return false;
  }
  
  public int pagarOrden(int idLinea){
    String query = "UPDATE linea_tiquet SET linea_tiquet.pagado = 1 WHERE linea_tiquet.id_linea = " + idLinea;
    return new BD().actualizar(query);
  }
}
