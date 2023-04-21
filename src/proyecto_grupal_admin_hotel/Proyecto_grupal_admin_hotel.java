/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_grupal_admin_hotel;

import javax.swing.*;
import java.math.BigDecimal;

/**
 * @author Lenovo
 */
public class Proyecto_grupal_admin_hotel {
  /**
   * @param args the command line arguments
   */
  public static int desplegar_menu() {
    String valor = JOptionPane.showInputDialog(null, "Menu de opciones: \n"
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
        + "11. Salir \n");
    if (valor != null) {
      return Integer.parseInt(valor);
    }
    return 99;

  }

  public static void main(String[] args) {
    int cantidadRestaurantes = 4;
    int cantidadHabitaciones = 50;
    int inicioHabitacion = 96;
    JFrame frame = new JFrame();
    Restaurante[] restaurantes;
    ReservaRestaurante[] reservaRestaurantes;
    Reservacion_Habitacion[] reservacionHabitaciones;
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
      inicioHabitacion++;
    }
    for (int i = 0; i < cantidadRestaurantes; i++) {
      restaurantes[i] = new Restaurante();
      restaurantes[i].setMesas(crearMesas());
      restaurantes[i].setNombre("Restaurante " + i + 1);
      restaurantes[i].setCapacidad(5 * 5 * 6);
    }

    boolean loop = true;
    while (loop) {
      switch (desplegar_menu()) {
        case 1:
          JOptionPane.showMessageDialog(frame, obtenerReservasRestaurante(reservaRestaurantes, restaurantes));
          break;
        case 2:
          JOptionPane.showMessageDialog(frame, obtenerReservasHabitacion(reservacionHabitaciones));
          break;
        case 3:
          JOptionPane.showMessageDialog(frame, obtenerReservasHabitacionDisponibles(reservacionHabitaciones));
          break;
        case 4:
          JOptionPane.showInputDialog("1. Habitación ");
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
        default:
          loop = false;
          break;
      }
    }
  }

  private static String obtenerReservasRestaurante(ReservaRestaurante[] reservaRestaurantes, Restaurante[] restaurantes) {
    StringBuilder sb = new StringBuilder();
    sb.append("Restaurantes disponibles: ");
    sb.append("\n");
    for (int i = 0; i < restaurantes.length; i++) {
      sb.append(i + 1);
      sb.append(". ");
      sb.append(restaurantes[i].getNombre());
      sb.append("\n");
    }
    sb.append("Reservas realizadas: ");
    sb.append("\n");
    for (int i = 0; i < reservaRestaurantes.length; i++) {
      sb.append(i + 1);
      sb.append(". ");
      sb.append(reservaRestaurantes[i].getRestaurante().getNombre());
      sb.append(" - Reservado por: ");
      sb.append(reservaRestaurantes[i].getNombreCliente());
      sb.append("\n");
    }
    return sb.toString();
  }

  private static String obtenerReservasHabitacion(Reservacion_Habitacion[] reservacionHabitaciones) {
    StringBuilder sb = new StringBuilder();
    sb.append("Todas las reservas: ");
    sb.append("\n");
    for (int i = 0; i < reservacionHabitaciones.length; i++) {
      sb.append(reservacionHabitaciones[i].getNumero_habitacion());
      sb.append(". ");
      sb.append(reservacionHabitaciones[i].getTipo_habitacion());
      sb.append(" - Disponibilidad: ");
      sb.append(reservacionHabitaciones[i].getEstado_reserva());
      sb.append("\n");
    }
    return sb.toString();
  }

  private static String obtenerReservasHabitacionDisponibles(Reservacion_Habitacion[] reservacionHabitaciones) {
    StringBuilder sb = new StringBuilder();
    sb.append("Todas las reservas: ");
    sb.append("\n");
    for (int i = 0; i < reservacionHabitaciones.length; i++) {
      if (reservacionHabitaciones[i].getEstado_reserva() == Estados.Disponible) {
        sb.append(reservacionHabitaciones[i].getNumero_habitacion());
        sb.append(". ");
        sb.append(reservacionHabitaciones[i].getTipo_habitacion());
        sb.append("\n");
      }

    }
    return sb.toString();
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
      return reservacionHabitacions[id - 96];
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

  private static void crearReservacionRestaurante(ReservaRestaurante[] reservaRestaurantes, Restaurante[] restaurantes, int idRestaurante) {
    ReservaRestaurante[] reservaRestaurantesAux = new ReservaRestaurante[reservaRestaurantes.length + 1];
    for (int i = 0; i < reservaRestaurantes.length - 1; i++) {
      reservaRestaurantesAux[i] = reservaRestaurantes[i];
    }
    String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente");
    TipoComida tipoComida = TipoComida.obtenerTipoComidaConValor(JOptionPane.showInputDialog("Indique el tipo de comida:\nDesayuno, almuerzo ó cena"));
    int cuposReservados = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de personas que le acompañan"));
    Mesa[] mesas = obtenerMesas(obtenerRestaurantePorId(restaurantes, idRestaurante), JOptionPane.showInputDialog("Seleccione mesas, si desea seleccionar más de una mesa, por favor separarlas con una coma \",\""));
    DetalleRestaurante[] detalles = new DetalleRestaurante[cuposReservados];
    for (int i = 0; i < cuposReservados; i++) {
      detalles[i] = new DetalleRestaurante().setMonto(tipoComida.getMonto()).setComentario(tipoComida.getValor() + i + 1).setCantidad(1);
    }
    reservaRestaurantesAux[reservaRestaurantes.length] = new ReservaRestaurante()
        .setRestaurante(obtenerRestaurantePorId(restaurantes, idRestaurante))
        .setEsCancelada(false)
        .setEsConfirmada(true)
        .setNombreCliente(nombreCliente)
        .setCuposReservados(cuposReservados)
        .setTipoComida(tipoComida)
        .setMesas(mesas)
        .setDetalleRestaurante(detalles);
  }

  private static Mesa[] obtenerMesas(Restaurante restaurante, String stringMesas) {
    stringMesas = stringMesas.replace(" ", "");
    String[] mesasSeparadas = stringMesas.split(",");
    Mesa[][] mesasDeRestaurante = restaurante.getMesas();
    Mesa[] mesasAElegir = new Mesa[0];
    int i = 0, j = 0, k = 0;
    for (; i < mesasSeparadas.length; i++) {
      mesasAElegir = new Mesa[mesasAElegir.length + 1];
      for (; j < mesasDeRestaurante.length; j++) {
        for (; k < mesasDeRestaurante[j].length; k++) {
          if (mesasDeRestaurante[j][k].getIdMesa().equals(mesasSeparadas[i])) {
            mesasAElegir[i] = mesasDeRestaurante[j][k];
          }
        }
      }
    }
    return mesasAElegir;
  }

  private void inicializarDatos(Restaurante[] restaurantes, ReservaRestaurante[] reservaRestaurantes, Reservacion_Habitacion[] reservacionHabitaciones) {
  }

  private static Mesa[][] crearMesas() {
    Mesa[][] mesas = new Mesa[5][5];
    int i = 0, j = 0;
    for (; i < mesas.length; i++) {
      for (; j < mesas[i].length; j++) {
        mesas[i][j] = new Mesa().setIdMesa(i + "-" + j).setDisponibilidad(true).setAsientosDisponibles(6);
      }
    }
    return mesas;
  }
}
