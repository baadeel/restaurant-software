/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

/**
 *
 * @author Badal
 */
public class HistorialOrdenes {
  
   
  private int id;
  private String hora;
  private int idEmpleado;
  private int numeroMesa;
  private double total;
  private int idLinea;

  public HistorialOrdenes(int idLinea, String hora, int idEmpleado, int numeroMesa, double total) {
    this.hora = hora;
    this.idEmpleado = idEmpleado;
    this.numeroMesa = numeroMesa;
    this.total = total;
    this.idLinea = idLinea;
  }

  public HistorialOrdenes(int id, int idLinea, String hora, int idEmpleado, int numeroMesa, double total) {
    this.id = id;
    this.hora = hora;
    this.idEmpleado = idEmpleado;
    this.numeroMesa = numeroMesa;
    this.total = total;
    this.idLinea = idLinea;
  }

  public int getIdLinea() {
    return idLinea;
  }

  public void setIdLinea(int idLinea) {
    this.idLinea = idLinea;
  }
  
  

  public HistorialOrdenes() {
  }

  public int getId() {
    return id;
  }

  public String getHora() {
    return hora;
  }

  public int getIdEmpleado() {
    return idEmpleado;
  }

  public int getNumeroMesa() {
    return numeroMesa;
  }

  public double getTotal() {
    return total;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public void setNumeroMesa(int numeroMesa) {
    this.numeroMesa = numeroMesa;
  }

  public void setTotal(double total) {
    this.total = total;
  }
  
  
  
  
  
  
}
