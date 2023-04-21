/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupal_admin_hotel;

/**
 * @author Lenovo
 */
public enum Habitaciones {
  Basica(100),
  Premium(200),
  Deluxe(500),
  Presidencial(1000);
  private int precio;

  private Habitaciones(int precio) {
    this.precio = precio;
  }

  public int getPrecio() {
    return this.precio;
  }

  public static Habitaciones obtenerHabitacionConNombre(String name) {
    Habitaciones[] estados = Habitaciones.values();
    for (int i = 0; i < estados.length; i++) {
      if (estados[i].name().equalsIgnoreCase(name)) {
        return estados[i];
      }
    }
    return null;
  }
}
