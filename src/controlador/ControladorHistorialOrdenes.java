/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.base_de_datos.HistorialFacturasDAO;
import modelo.base_de_datos.HistorialOrdenesDAO;
import vista.HistorialOrdenesPantalla;

/**
 *
 * @author Badal
 */
import modelo.entidades.HistorialOrdenes;

public class ControladorHistorialOrdenes {

  private HistorialOrdenesPantalla HoPantalla;
  private HistorialOrdenesDAO HODAO;
  private HistorialFacturasDAO hfDAO;

  public ControladorHistorialOrdenes(HistorialOrdenesPantalla HoPantalla, HistorialOrdenesDAO HODAO, HistorialFacturasDAO hfDAO) {
    this.HoPantalla = HoPantalla;
    this.HODAO = HODAO;
    this.hfDAO = hfDAO;
  }

  public void actualizarTabla() {
    List<HistorialOrdenes> ordenes = HODAO.obtenerHistorialOrdenes();
    DefaultTableModel modelo = (DefaultTableModel) HoPantalla.getTabla().getModel();
    modelo.setRowCount(0);
    for (HistorialOrdenes ho : ordenes) {
      Object[] fila = {ho.getId(), ho.getIdLinea(), ho.getHora(), ho.getIdEmpleado(), ho.getNumeroMesa(), ho.getTotal()};
      modelo.addRow(fila);
    }
    HoPantalla.getTabla().setModel(modelo);
  }

  public void eliminar() {
    if (HoPantalla.getOrdenesAEliminar().length == 0) {
      JOptionPane.showMessageDialog(HoPantalla, "Selecciona una o varias filas para eliminarlas", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    for (int row : HoPantalla.getOrdenesAEliminar()) {
      DefaultTableModel modelo = (DefaultTableModel) HoPantalla.getTabla().getModel();
      HODAO.eliminar((int) modelo.getValueAt(row, 0));
    }
    actualizarTabla();
    setTotal();
  }

  public void setTotal() {
    JLabel total = HoPantalla.getTotalValor();
    DefaultTableModel modelo = (DefaultTableModel) HoPantalla.getTabla().getModel();
    double ValorTotal = 0;
    for (int i = 0; i < modelo.getRowCount(); i++) {
      ValorTotal += (double) modelo.getValueAt( i, 5);
    }
    total.setText(ValorTotal + " $");
  }
  
  public void cerrarCaja() {
    Object[] opciones = {"Si", "No"};
    int respuesta = JOptionPane.showOptionDialog(HoPantalla,
  "¿Seguro que cerrar la Caja?",
    "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
    null, opciones, opciones[0]);
    
    if(respuesta == 0){
      JOptionPane.showMessageDialog(HoPantalla, "Caja cerrada con éxito :)");
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd" );
       LocalDateTime now = LocalDateTime.now();
      String fecha = dtf.format(now);
      double total = Double.parseDouble(HoPantalla.getTotalValor().getText().replace("$", " "));
      hfDAO.insertar(fecha, total);
      HODAO.eliminarTodo();
      actualizarTabla();
      setTotal();
    }
  }

}
