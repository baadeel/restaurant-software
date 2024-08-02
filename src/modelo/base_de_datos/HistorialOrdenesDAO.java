/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.base_de_datos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.entidades.HistorialOrdenes;

/**
 *
 * @author Badal
 */
public class HistorialOrdenesDAO {
 
 public HistorialOrdenes insertar(int idLinea, String hora, int idEmpleado, int numeroMesa, double total){
  String query = "INSERT INTO historial_ordenes (id_linea, hora, id_empleado, numero_mesa, total) VALUES ("
            + idLinea + ",'"
            + hora + "',"
            + idEmpleado + ","
            + numeroMesa + ","
            + total + ")";
  if (new BD().actualizar(query) > 0) {
      HistorialOrdenes ho = new HistorialOrdenes(idLinea, hora, idEmpleado, numeroMesa,total);
      return ho;
    }
    return null;
}
 
 public List obtenerHistorialOrdenes() {
    String query = "SELECT * FROM historial_ordenes" ;
    List<Map> registros = new BD().ejecutar(query);
    List<HistorialOrdenes> historialOrdenes = new ArrayList();
    for (Map registro : registros) {
      String hora = registro.get("hora").toString();
     
      HistorialOrdenes ho = new HistorialOrdenes(
              (int) registro.get("id_historial_ordenes"),
              (int) registro.get("id_linea"),
              "Fecha: " + hora.replaceAll("T", " Hora: "),
              (int) registro.get("id_empleado"),
              (int) registro.get("numero_mesa"),
              ((BigDecimal) registro.get("total")).doubleValue());
      historialOrdenes.add(ho);
    }
    return historialOrdenes;
  }
 
 public int eliminar(int id){
    String query = "DELETE FROM historial_ordenes WHERE id_historial_ordenes = " + id;
    return new BD().actualizar(query);
  }
 
 public int eliminarTodo(){
    String query = "DELETE FROM historial_ordenes";
    return new BD().actualizar(query);
  }
 
}
