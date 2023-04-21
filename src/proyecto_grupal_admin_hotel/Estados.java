/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupal_admin_hotel;

/**
 *
 * @author Lenovo
 */
public enum Estados {
    Por_confirmar,
    Reservado,
    Disponible;

  public static Estados obtenerEstadoConNombre(String name) {
    Estados[] estados = Estados.values();
    for (int i = 0; i < estados.length; i++) {
      if (estados[i].name().equalsIgnoreCase(name)) {
        return estados[i];
      }
    }
    return null;
  }
}
