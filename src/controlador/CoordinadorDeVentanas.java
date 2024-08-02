/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import vista.Menu;
import vista.MesasYOrdenes;
import vista.Orden;
import vista.VentanaPrincipal;

/**
 *
 * @author Badal
 */
public class CoordinadorDeVentanas {
 
  private JPanel ventana;
  private CardLayout cl;
  private VentanaPrincipal vp;
  
  
  
  
  public CoordinadorDeVentanas(JPanel ventana, CardLayout cl){
  this.ventana = ventana;
  this.cl = cl;
}
  
  
 public void mostrarVentana(String name){
   
    cl.show(ventana, name);
 }
 
 

 

    
     
    
 
   
   
 }
 
  

