/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.base_de_datos.HistorialOrdenesDAO;
import modelo.base_de_datos.LineaTiquetDAO;
import modelo.base_de_datos.ProductoDAO;
import modelo.entidades.LineaTiquet;
import modelo.entidades.Producto;
import vista.Orden;


/**
 *
 * @author Badal
 */
public class ControladorVentanaOrden {

 
  private Orden orden;
  private LineaTiquetDAO ltDAO;
  private ProductoDAO prDAO;
  private Producto pr;
  private HistorialOrdenesDAO hoDAO;
  



  public ControladorVentanaOrden(Orden orden, LineaTiquetDAO ltDAO, ProductoDAO prDAO, HistorialOrdenesDAO hoDAO) {
    this.orden = orden;
    this.ltDAO = ltDAO;
    this.prDAO = prDAO;
    this.hoDAO = hoDAO;
  }
  
  

  public void setDisponibilidad() {
    JButton cerrarOrden = orden.getCerrarOrdenBoton();
    int numeroMesa = orden.getNumeroMesa();
    JLabel libre = orden.getLibre();
    JLabel ocupada = orden.getOcupada();
    int idLinea = ltDAO.obtenerId(numeroMesa);

    if (idLinea != 0) {
      libre.setVisible(false);
      ocupada.setVisible(true);
      cerrarOrden.setEnabled(true);
    } else {
      ocupada.setVisible(false);
      libre.setVisible(true);
      cerrarOrden.setEnabled(false);
    }
  }
  
   public boolean comprobarMesaOcupada() {
    int numeroMesa = orden.getNumeroMesa();
    int idLinea = ltDAO.obtenerId(numeroMesa);

    if (idLinea != 0) {
      return true;
    } else {
      return false;
    }
  }
   
   public void setEmpleado(){
     int numeroMesa = orden.getNumeroMesa();
     String empleadoOrden = ltDAO.obtenerNombre(numeroMesa);
     JLabel lNombreEmpleado = orden.getlNombreCamarer();
    lNombreEmpleado.setText(empleadoOrden);
   }

  public void actualizarTablaOrden() {
    int numeroMesa = orden.getNumeroMesa();
    List<LineaTiquet> ordenLista = ltDAO.obtenerOrden(numeroMesa);
    DefaultTableModel modelo = (DefaultTableModel) orden.getTablaOrden().getModel();
    modelo.setRowCount(0);
    for (LineaTiquet lt : ordenLista) {
      Object[] fila = {lt.getCantidad(), lt.getNombre(), lt.getPrecioPvp(), lt.getPrecio()};
      modelo.addRow(fila);
    }
    orden.getTablaOrden().setModel(modelo);
  }

  public void actualizarTablaMenu() {
    List<Producto> productos = prDAO.obtenerProductos();
    DefaultTableModel modelo = (DefaultTableModel) orden.getTablaMenu().getModel();
    modelo.setRowCount(0);
    for (Producto pr : productos) {
      Object[] fila = {pr.getId(), pr.getNombre(), pr.getTipo(), pr.getPvp()};
      modelo.addRow(fila);
    }
    orden.getTablaMenu().setModel(modelo);
  }

  public void setTotal() {
    int numeroMesa = orden.getNumeroMesa();
    JLabel lTotal = orden.getTotal();
    double total = ltDAO.obtenerTotal(numeroMesa);
    lTotal.setText(total + " $");
  }

  public void añadirProductoMesaLibre() {
    int idLinea;
    int numeroMesa = orden.getNumeroMesa();
    String nombreEmp = orden.getEmpleadoSistema();
    JTable tMenu = orden.getTablaMenu();
    boolean flag = false;
    for (int fila : tMenu.getSelectedRows()) {
      if (flag == false) {
        idLinea = ltDAO.obtenerUltimoId() + 1;
        flag = true;
      } else {
        idLinea = ltDAO.obtenerId(numeroMesa);
      }
      double pvp = (double) tMenu.getValueAt(fila, 3);
      int idProducto = (int) tMenu.getValueAt(fila, 0);
      int idEmpleado = ltDAO.obtenerIdEmpleadoPorNombre(nombreEmp);
      LineaTiquet lt = ltDAO.insertarProducto(idLinea, 1, pvp, idProducto, numeroMesa, idEmpleado, 0);
    }
  }

  public void añadirProducto() {
    int numeroMesa = orden.getNumeroMesa();
    String nombreEmp = ltDAO.obtenerNombre(numeroMesa);
    int idLinea = ltDAO.obtenerId(numeroMesa);
    int idEmpleado = ltDAO.obtenerIdEmpleadoPorNombre(nombreEmp);
    JTable tMenu = orden.getTablaMenu();
    for (int fila : tMenu.getSelectedRows()) {
      double pvp = (double) tMenu.getValueAt(fila, 3);
      int idProducto = (int) tMenu.getValueAt(fila, 0);
      if (ltDAO.comprobarProductoOrden(idLinea, idProducto)) {
        ltDAO.sumarCantidad(idLinea, idProducto);
      } else {
        LineaTiquet lt = ltDAO.insertarProducto(idLinea, 1, pvp, idProducto, numeroMesa, idEmpleado, 0);
      }
    }
  }
  
  public void añadir() {
    String empleadoOrden = orden.getEmpleadoOrden();
    String empleadoSistema = orden.getEmpleadoSistema();
    boolean mesaOcupada = comprobarMesaOcupada();
    
    if (mesaOcupada == false){
      añadirProductoMesaLibre();
      setDisponibilidad();
      setEmpleado();
        
    } else {
    if (empleadoOrden.equals(empleadoSistema)) {
    JTable tMenu = orden.getTablaMenu();
    if (tMenu.getSelectedRows().length == 0) {
      JOptionPane.showMessageDialog(orden, "Selecciona uno o varios productos para añadirlos a la orden", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
      JLabel lLibre = orden.getLibre();
      if (lLibre.isVisible()) {
        añadirProductoMesaLibre();
        setDisponibilidad();
      } else {
        añadirProducto();
      }
    } else {
            JOptionPane.showMessageDialog(orden, "El empleado seleccionado no pertenece a este orden.", "ERROR", JOptionPane.ERROR_MESSAGE);

    }
  }
    setTotal();
    actualizarTablaOrden();
  }
  
  public void eliminarProducto(){
    JTable tOrden = orden.getTablaOrden();
    if (tOrden.getSelectedRows().length == 0) {
      JOptionPane.showMessageDialog(orden, "Selecciona uno o varios productos para eliminarlos de la orden", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    for (int fila : tOrden.getSelectedRows()) {
      int und = (int) tOrden.getValueAt(fila, 0);
      String nombreProducto = (String) tOrden.getValueAt(fila, 1);
      int idProducto = prDAO.obtenerIdPorNombre(nombreProducto);
      int numeroMesa = orden.getNumeroMesa();
      int idLinea = ltDAO.obtenerId(numeroMesa);
      if(und > 1){
        ltDAO.restarCantidad(idLinea, idProducto);
      } else if (und == 1) {
        ltDAO.eliminar(idLinea, idProducto);
        setDisponibilidad();
        setEmpleado();
      } 
    }
    
    setTotal();
    actualizarTablaOrden();
    
  }
  
  public void cerrarOrden(){
    Object[] opciones = {"Pagar ahora", "Cancelar"};
    int respuesta = JOptionPane.showOptionDialog(orden,
  "¿Seguro que desea cerrar la orden?",
    "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
    null, opciones, opciones[0]);
    
    if(respuesta == 0){
      JOptionPane.showMessageDialog(orden, "Orden pagada con éxito :)");
      int numeroMesa = orden.getNumeroMesa();
      int idLinea = ltDAO.obtenerId(numeroMesa);
      String nombreEmpleado = orden.getEmpleadoOrden();
      int idEmpleado = ltDAO.obtenerIdEmpleadoPorNombre(nombreEmpleado);
      double total = ltDAO.obtenerTotal(numeroMesa);
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss" );
      LocalDateTime now = LocalDateTime.now();
      String hora = dtf.format(now);
      hoDAO.insertar(idLinea, hora, idEmpleado, numeroMesa, total);
      ltDAO.pagarOrden(idLinea);
  
      
      
      
      
      setDisponibilidad();
      setEmpleado();
      actualizarTablaOrden();
    } 
  }
  
  
  
}
