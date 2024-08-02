/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

/**
 *
 * @author Badal
 */
public class HistorialFacturas {
  
  private int id;
  private String fecha;
  private double total;

  public HistorialFacturas(String fecha, double total) {
    this.fecha = fecha;
    this.total = total;
  }

  public HistorialFacturas(int id, String fecha, double total) {
    this.id = id;
    this.fecha = fecha;
    this.total = total;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  
  
  
  

  public int getId() {
    return id;
  }

  public double getTotal() {
    return total;
  }

  public void setId(int id) {
    this.id = id;
  }


  public void setTotal(double total) {
    this.total = total;
  }
  
  
  
  
}
