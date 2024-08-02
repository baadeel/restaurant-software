/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelo.base_de_datos.EmpleadoDAO;
import modelo.entidades.Empleado;
import vista.VentanaPrincipal;

/**
 *
 * @author Badal
 */
public class ControladorVentanaPrincipal {

  private VentanaPrincipal vp;
  private EmpleadoDAO empDAO;

  public ControladorVentanaPrincipal(VentanaPrincipal vp, EmpleadoDAO empDAO) {
    this.vp = vp;
    this.empDAO = empDAO;
  }
  
  

  public void insertarEmpleados() {
    JComboBox cbEmpleados = vp.getCBEmpleados();
    cbEmpleados.removeAllItems();
    List<Empleado> empleados = empDAO.obtenerEmpleados();
    List<Object> nombresEmp = new ArrayList();
    for (Empleado emp : empleados) {
      Object nombre = emp.getNombre();
      cbEmpleados.addItem(nombre);
    }
  }
  
  public int obtenerId(){
    String nombre = vp.getCBNombreEmpleado().getSelectedItem().toString();
    List<Empleado> empleados = empDAO.obtenerEmpleados();
    for (Empleado emp : empleados){
      if (emp.getNombre().equals(nombre)){
        return emp.getId();
      }
    }
    return 0;
  }

}
