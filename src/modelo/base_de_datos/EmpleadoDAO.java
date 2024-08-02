/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.base_de_datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.entidades.Empleado;

/**
 *
 * @author Badal
 */
public class EmpleadoDAO {

  public List obtenerEmpleados() {
    String query = "SELECT * FROM empleado";
    List<Map> registros = new BD().ejecutar(query);
    List<Empleado> empleados = new ArrayList();
    for (Map registro : registros) {
      Empleado emp = new Empleado(
              (int) registro.get("id_empleado"),
              (String) registro.get("nombre"));
      empleados.add(emp);
    }
    return empleados;
  }

}
