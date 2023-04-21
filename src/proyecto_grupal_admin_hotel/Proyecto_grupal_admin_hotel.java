/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_grupal_admin_hotel;

import javax.swing.*;

/**
 * @author Lenovo
 */
public class Proyecto_grupal_admin_hotel {
  /**
   * @param args the command line arguments
   */
  public static int desplegar_menu() {
    int respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opciones: \n"
        + "1. Desplegar lista de reservas del restaurante \n"
        + "2. Desplegar lista de reservas de habitaciones \n"
        + "3. Desplegar habitaciones libres \n"
        + "4. Hacer nueva reserva \n"
        + "5. Desplegar informacion de cierta reserva de habitacion \n"
        + "6. Desplegar la factura para cierta reserva de habitacion \n"
        + "7. Desplegar informacion de cierta reserva de restuarante \n"
        + "8. Desplegar la factura para cierta reserva de restaurante \n"
        + "9. Cancelar reserva habitaciones \n"
        + "10. Cancelar reserva de restaurantes \n"
        + "11. Salir \n"));
    return respuesta;
  }

  public static void main(String[] args) {
    Restaurante[] restaurantes = new Restaurante[0];
    ReservaRestaurante[] reservaRestaurantes = new ReservaRestaurante[0];
    Reservacion_Habitacion[] reservacionHabitaciones = new Reservacion_Habitacion[0];
    inicializarDatos(restaurantes, reservaRestaurantes, reservacionHabitaciones);
    boolean loop = true;
    while (loop) {
      switch (desplegar_menu()) {
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        case 8:
          break;
        case 9:
          break;
        case 10:
          break;
        case 11:
          break;
      }
    }
  }

  private static Restaurante obtenerRestaurantePorId(Restaurante[] restaurantes, int id) {
    if (id > 0 && id <= restaurantes.length) {
      return restaurantes[id - 1];
    }
    return null;
  }

  private static Reservacion_Habitacion obtenerReservacionHabitacionPorNombreCliente(Reservacion_Habitacion[] reservacionHabitacions, String nombre) {
    for (int i = 0; i < reservacionHabitacions.length; i++) {
      if (reservacionHabitacions[i].getNombre_cliente().equalsIgnoreCase(nombre)) {
        return reservacionHabitacions[i];
      }
    }
    return null;
  }

  private static Reservacion_Habitacion obtenerReservacionHabitacionPorId(Reservacion_Habitacion[] reservacionHabitacions, int id) {
    if (id > 0 && id <= reservacionHabitacions.length) {
      return reservacionHabitacions[id - 1];
    }
    return null;
  }

  private static ReservaRestaurante obtenerReservacionRestaurantePorNombreCliente(ReservaRestaurante[] ReservaRestaurante, String nombre) {
    for (int i = 0; i < ReservaRestaurante.length; i++) {
      if (ReservaRestaurante[i].getNombreCliente().equalsIgnoreCase(nombre)) {
        return ReservaRestaurante[i];
      }
    }
    return null;
  }

  private static ReservaRestaurante obtenerReservacionRestaurantePorId(ReservaRestaurante[] ReservaRestaurante, int id) {
    if (id > 0 && id <= ReservaRestaurante.length) {
      return ReservaRestaurante[id - 1];
    }
    return null;
  }

  private static void crearReservacionRestaurante() {
  }

  private static void inicializarDatos(Restaurante[] restaurantes, ReservaRestaurante[] reservaRestaurantes, Reservacion_Habitacion[] reservacionHabitaciones) {
    int cantidadRestaurantes = 4;
    int cantidadHabitaciones = 50;
    int inicioHabitacion = 96;
    restaurantes = new Restaurante[cantidadRestaurantes];
    reservaRestaurantes = new ReservaRestaurante[0];
    reservacionHabitaciones = new Reservacion_Habitacion[cantidadHabitaciones];
    for (int i = 0; i < cantidadHabitaciones; i++) {
      reservacionHabitaciones[i] = new Reservacion_Habitacion();
      reservacionHabitaciones[i].setCant_noches(0);
      reservacionHabitaciones[i].setNumero_habitacion(inicioHabitacion);
      reservacionHabitaciones[i].setCant_personas(0);
      reservacionHabitaciones[i].setCant_noches(0);
      reservacionHabitaciones[i].setNombre_cliente("");
      reservacionHabitaciones[i].setEstado_reserva(Estados.Disponible);
      if (i <= 24) {
        reservacionHabitaciones[i].setTipo_habitacion(Habitaciones.Basica);
      } else if (i <= 39) {
        reservacionHabitaciones[i].setTipo_habitacion(Habitaciones.Premium);
      } else if (i <= 45) {
        reservacionHabitaciones[i].setTipo_habitacion(Habitaciones.Deluxe);
      } else {
        reservacionHabitaciones[i].setTipo_habitacion(Habitaciones.Presidencial);
      }
    }
    for (int i = 0; i < cantidadRestaurantes; i++) {
      restaurantes[i] = new Restaurante();
      restaurantes[i].setMesas(crearMesas());
    }
  }

  private static Mesa[][] crearMesas() {
    Mesa[][] mesas = new Mesa[5][5];
    int i = 0, j = 0;
    for (; i < mesas.length; i++) {
      for (; j < mesas[i].length; i++) {
        mesas[i][j] = new Mesa().setIdMesa(i + "-" + j).setDisponibilidad(true).setAsientosDisponibles(6);
      }
    }
    return mesas;
  }
}
