/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.base_de_datos.ProductoDAO;
import modelo.entidades.Producto;
import vista.Menu;
import vista.Orden;

/**
 *
 * @author Badal
 */
public class ControladorVentanaMenu {

  private Menu menu;
  private Orden orden;
  private ProductoDAO productoDAO;
  private Producto pr;

  public ControladorVentanaMenu(Menu menu, ProductoDAO productoDAO) {
    this.menu = menu;
    this.productoDAO = productoDAO;
  }
 

  public void actualizarTabla() {
    List<Producto> productos = productoDAO.obtenerProductos();
    DefaultTableModel modelo = (DefaultTableModel) menu.getTabla().getModel();
    modelo.setRowCount(0);
    for (Producto pr : productos) {
      Object[] fila = {pr.getId(), pr.getNombre(), pr.getTipo(), pr.getPvp()};
      modelo.addRow(fila);
    }
    menu.getTabla().setModel(modelo);
  }

  public void añadirProducto() {
    String nombre = menu.getNombre();
    System.out.println(nombre);
    String precio = menu.getPrecio().replace(",", ".");
    String tipo = menu.getTipo();
    if (!nombre.equals("") && !precio.equals("")) {
      if (isTextDouble(precio)) {
        double precioDouble = Double.parseDouble(precio);
        productoDAO.insertar(nombre, precioDouble, tipo);
        actualizarTabla();
      }
    } else {
      JOptionPane.showMessageDialog(menu, "Debes completar todos los campos",
              "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  public void eliminarProducto(){
    if(menu.getProductosAEliminar().length == 0){
      JOptionPane.showMessageDialog(menu, "Selecciona una o varias filas para eliminarlas", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    for (int row : menu.getProductosAEliminar()){
      DefaultTableModel modelo = (DefaultTableModel) menu.getTabla().getModel();
      productoDAO.eliminar((int) modelo.getValueAt(row, 0));
    }
    actualizarTabla();
  }

  public boolean isTextDouble(String text) {
    try {
      Double.parseDouble(text);
      return true;
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(menu, "El valor introducido en el precio es erróneo", "ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }

}
