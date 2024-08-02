/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import javax.swing.JButton;
import modelo.base_de_datos.LineaTiquetDAO;
import vista.MesasYOrdenes;

/**
 *
 * @author Badal
 */
public class ControladorMesasYOrdenes {
  
  private MesasYOrdenes myo;
  private LineaTiquetDAO ltDAO;
  Color verde = new Color(153, 255, 153);
  Color rojo = new Color(255, 153, 153);

  public ControladorMesasYOrdenes(MesasYOrdenes myo, LineaTiquetDAO ltDAO) {
    this.myo = myo;
    this.ltDAO = ltDAO;
  }
  
  public void colorarMesas(){
    for (int i = 1; i <= 18; i++) {
    int idLinea = ltDAO.obtenerId(i);
    JButton[] mesas = myo.getBotonesMesa();
     if (idLinea != 0) {
      mesas[i].setBackground(rojo);
    } else {
      mesas[i].setBackground(verde);
    }
      
    }
  }
  
  
  
  
}
