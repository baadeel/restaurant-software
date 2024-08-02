/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import java.util.Date;

/**
 *
 * @author Badal
 */
public class Reserva {
  
  private int id;
  private String nombre;
  private int personas;
  private String comentarios;
  private String fecha;
  private String hora;
  private int numeroMesa;

  public Reserva() {
  }

  public Reserva(String nombre, int personas, String comentarios, String fecha, String hora, int numeroMesa) {
    this.nombre = nombre;
    this.personas = personas;
    this.comentarios = comentarios;
    this.fecha = fecha;
    this.hora = hora;
    this.numeroMesa = numeroMesa;
  }

  public Reserva(int id, String nombre, int personas, String comentarios, String fecha, String hora, int numeroMesa) {
    this.id = id;
    this.nombre = nombre;
    this.personas = personas;
    this.comentarios = comentarios;
    this.fecha = fecha;
    this.hora = hora;
    this.numeroMesa = numeroMesa;
  }
  
  

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public int getPersonas() {
    return personas;
  }

  public String getComentarios() {
    return comentarios;
  }

  public String getFecha() {
    return fecha;
  }

  public String getHora() {
    return hora;
  }

  public int getNumeroMesa() {
    return numeroMesa;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPersonas(int personas) {
    this.personas = personas;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public void setNumeroMesa(int numeroMesa) {
    this.numeroMesa = numeroMesa;
  }
  
  
  
  
  
}
