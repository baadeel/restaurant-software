/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

/**
 *
 * @author Badal
 */
public class LineaTiquet {
  
  private int id_linea;
  private int cantidad;
  private double precio;
  private int id_producto;
  private int numero_mesa;
  private int id_empleado;
  private int pagado;
  private String nombre;
  private double precioPvp;

  public LineaTiquet() {
  }
  
  public LineaTiquet (int cantidad, String nombre, double precioPvp, double precio){
    this.cantidad = cantidad;
    this.nombre = nombre;
    this.precioPvp = precioPvp;
    this.precio = precio;
  }

  public LineaTiquet(int id_linea, int cantidad, double precio, int id_producto, int numero_mesa, int id_empleado, int pagado) {
    this.id_linea = id_linea;
    this.cantidad = cantidad;
    this.precio = precio;
    this.id_producto = id_producto;
    this.numero_mesa = numero_mesa;
    this.id_empleado = id_empleado;
    this.pagado = pagado;
  }
  
   public LineaTiquet(int cantidad, double precio, int id_producto, int numero_mesa, int id_empleado, int pagado) {
    this.cantidad = cantidad;
    this.precio = precio;
    this.id_producto = id_producto;
    this.numero_mesa = numero_mesa;
    this.id_empleado = id_empleado;
    this.pagado = pagado;
  }

  public int getId_linea() {
    return id_linea;
  }

  public int getCantidad() {
    return cantidad;
  }

  public double getPrecio() {
    return precio;
  }

  public int getId_producto() {
    return id_producto;
  }

  public int getNumero_mesa() {
    return numero_mesa;
  }

  public int getId_empleado() {
    return id_empleado;
  }

  public int getPagado() {
    return pagado;
  }

  public void setId_linea(int id_linea) {
    this.id_linea = id_linea;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public void setId_producto(int id_producto) {
    this.id_producto = id_producto;
  }

  public void setNumero_mesa(int numero_mesa) {
    this.numero_mesa = numero_mesa;
  }

  public void setId_empleado(int id_empleado) {
    this.id_empleado = id_empleado;
  }

  public void setPagado(int pagado) {
    this.pagado = pagado;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecioPvp() {
    return precioPvp;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPrecioPvp(double precioPvp) {
    this.precioPvp = precioPvp;
  }
  
  
  
  
}
