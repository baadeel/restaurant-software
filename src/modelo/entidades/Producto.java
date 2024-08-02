/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

/**
 *
 * @author Badal
 */
public class Producto {
  
  private int id;
  private String nombre;
  private String tipo;
  private double pvp;

  public Producto() {
  }

  public Producto(int id, String nombre, String tipo, double pvp) {
    this.id = id;
    this.nombre = nombre;
    this.tipo = tipo;
    this.pvp = pvp;
  }
  
  public Producto(String nombre, String tipo, double precio) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.pvp = precio;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPvp(double pvp) {
    this.pvp = pvp;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPvp() {
    return pvp;
  }

  public String getTipo() {
    return tipo;
  }
  
  
  
  
}
