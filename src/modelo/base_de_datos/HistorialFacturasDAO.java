/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.base_de_datos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.entidades.HistorialFacturas;

/**
 *
 * @author Badal
 */
public class HistorialFacturasDAO {

  public HistorialFacturas insertar(String fecha, double total) {
    String query = "INSERT INTO historial_facturas (fecha, total ) VALUES ('"
            + fecha + "',"
            + total + ")";
    if (new BD().actualizar(query) > 0) {
      HistorialFacturas hf = new HistorialFacturas(fecha, total);
      return hf;
    }
    return null;
  }

  public List obtenerHistorialFacturas() {
    String query = "SELECT * FROM historial_facturas";
    List<Map> registros = new BD().ejecutar(query);
    List<HistorialFacturas> historialFacturas = new ArrayList();
    for (Map registro : registros) {
      HistorialFacturas hf = new HistorialFacturas(
              (int) registro.get("id_historial_facturas"),
              registro.get("fecha").toString(),
              ((BigDecimal) registro.get("total")).doubleValue());
      historialFacturas.add(hf);
    }
    return historialFacturas;
  }

  public int eliminar(int id) {
    String query = "DELETE FROM historial_facturas WHERE id_historial_facturas = " + id;
    return new BD().actualizar(query);
  }
 

}
