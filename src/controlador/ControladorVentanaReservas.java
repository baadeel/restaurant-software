/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.base_de_datos.ReservaDAO;
import modelo.entidades.Reserva;
import vista.ReservaPantalla;

/**
 *
 * @author Badal
 */
public class ControladorVentanaReservas {

  private ReservaPantalla reserva;
  private ReservaDAO rDAO;
 

  public ControladorVentanaReservas(ReservaPantalla reserva, ReservaDAO rDAO) {
    this.reserva = reserva;
    this.rDAO = rDAO;
  }

  public void actualizarTabla() {
    List<Reserva> reservas = rDAO.obtenerProductos();
    DefaultTableModel modelo = (DefaultTableModel) reserva.getTabla().getModel();
    modelo.setRowCount(0);
    for (Reserva rs : reservas) {
      Object[] fila = {rs.getId(), rs.getNumeroMesa(), rs.getNombre(), rs.getPersonas(), rs.getFecha(), rs.getHora(), rs.getComentarios()};
      modelo.addRow(fila);
    }
    reserva.getTabla().setModel(modelo);
  }

  public void añadirReserva() throws ParseException {
    String nombre = reserva.getNombre();
    String personas = reserva.getPersonas();
    String fecha = reserva.getFecha();
    String hora = reserva.getHora();
    String comentarios = reserva.getComentarios();
    int numeroMesa = reserva.getMesa();
    if (!nombre.equals("") && !personas.equals("")) {
      if (isInt(personas)) {
        int personasInt = Integer.parseInt(personas);
        rDAO.insertar(nombre, personasInt, comentarios, fecha, hora, numeroMesa);
        actualizarTabla();
      }
    } else {
      JOptionPane.showMessageDialog(reserva, "Debes completar el nombre y las personas.",
              "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean isInt(String texto) {
    try {
      Integer.parseInt(texto);
      return true;
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(reserva, "El campo personas solo puede contener numero enteros", "ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }

  public void eliminar() {
    if (reserva.getReservasAEliminar().length == 0) {
      JOptionPane.showMessageDialog(reserva, "Selecciona una o varias filas para eliminarlas", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    for (int row : reserva.getReservasAEliminar()) {
      DefaultTableModel modelo = (DefaultTableModel) reserva.getTabla().getModel();
      rDAO.eliminar((int) modelo.getValueAt(row, 0));
    }
    actualizarTabla();
  }
  
 
}


