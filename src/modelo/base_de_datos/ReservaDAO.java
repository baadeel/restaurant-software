/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.base_de_datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import modelo.entidades.Reserva;
import vista.ReservaPantalla;

/**
 *
 * @author Badal
 */
public class ReservaDAO {
  
  public Reserva insertar(String nombre, int personas, String comentarios, String fecha, String hora, int numeroMesa){
    String query = "INSERT INTO reserva (nombre, personas, comentarios,fecha,hora,numero_mesa) VALUES ('"
            + nombre + "',"
            + personas + ",'"
            + comentarios + "','"
            + fecha + "','"
            + hora + "',"
            + numeroMesa + ")";
    if (new BD().actualizar(query) > 0) {
      Reserva rs = new Reserva(nombre, personas, comentarios, fecha, hora, numeroMesa);
      return rs;
    }
    return null;
  }
  
  public int eliminar(int id){
    String query = "DELETE FROM reserva WHERE id_reserva = " + id;
    return new BD().actualizar(query);
  }
  
  public List obtenerProductos(){
    String query = "SELECT * FROM reserva";
    List<Map> registros = new BD().ejecutar(query);
    List<Reserva> reservas = new ArrayList();
    for(Map registro : registros){
      Reserva reserva = new Reserva(
              (int) registro.get("id_reserva"), 
              (String) registro.get("nombre"),
              (int) registro.get("personas"),
              (String) registro.get("comentarios"),
               registro.get("fecha").toString(),
               registro.get("hora").toString(),
              (int) registro.get("numero_mesa"));
              
      reservas.add(reserva);
    }
    return reservas;
  }
  
    
  
}
