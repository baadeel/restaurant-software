/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.base_de_datos.HistorialFacturasDAO;
import modelo.entidades.HistorialFacturas;
import vista.HistorialFacturasPantalla;

/**
 *
 * @author Badal
 */
public class ControladorHistorialFacturas {
  
  private HistorialFacturasPantalla hfp;
  private HistorialFacturasDAO hfDAO;

  public ControladorHistorialFacturas(HistorialFacturasPantalla hfp, HistorialFacturasDAO hfDAO) {
    this.hfp = hfp;
    this.hfDAO = hfDAO;
  }
  
  public void actualizarTabla() {
    List<HistorialFacturas> facturas = hfDAO.obtenerHistorialFacturas();
    DefaultTableModel modelo = (DefaultTableModel) hfp.getTabla().getModel();
    modelo.setRowCount(0);
    for (HistorialFacturas hf : facturas) {
      Object[] fila = {hf.getId(), hf.getFecha(), hf.getTotal()};
      modelo.addRow(fila);
    }
    hfp.getTabla().setModel(modelo);
  }
  
   public void eliminar() {
    if (hfp.getOrdenesAEliminar().length == 0) {
      JOptionPane.showMessageDialog(hfp, "Selecciona una o varias filas para eliminarlas", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    for (int row : hfp.getOrdenesAEliminar()) {
      DefaultTableModel modelo = (DefaultTableModel) hfp.getTabla().getModel();
      hfDAO.eliminar((int) modelo.getValueAt(row, 0));
    }
    actualizarTabla();
    setTotal();
  }
   
    public void setTotal() {
    JLabel total = hfp.getTotalValor();
    DefaultTableModel modelo = (DefaultTableModel) hfp.getTabla().getModel();
    double ValorTotal = 0;
    for (int i = 0; i < modelo.getRowCount(); i++) {
      ValorTotal += (double) modelo.getValueAt( i, 2);
    }
    total.setText(ValorTotal + " $");
  }
  
}
