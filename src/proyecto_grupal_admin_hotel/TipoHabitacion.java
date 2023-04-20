/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupal_admin_hotel;

/**
 * @author Lenovo
 */
public enum TipoHabitacion {
  BASICA(100),
  PREMIUM(200),
  DELUXE(500),
  Presidencial(1000);
  private final int precio;

  TipoHabitacion(int precio) {
    this.precio = precio;
  }

  public int getPrecio() {
    return this.precio;
  }
}
