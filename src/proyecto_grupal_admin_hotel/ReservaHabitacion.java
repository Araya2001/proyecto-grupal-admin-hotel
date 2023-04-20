/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupal_admin_hotel;

import javax.swing.*;

/**
 * @author Lenovo
 */
public class ReservaHabitacion {
  private Cliente cliente;
  private int cantPersonas;
  private Estados estadoReserva;
  private Habitacion habitacion;
  private int cantNoches;

  public ReservaHabitacion(Cliente cliente, int cantPersonas, Estados estadoReserva, Habitacion habitacion, int cantNoches) {
    this.cliente = cliente;
    this.cantPersonas = cantPersonas;
    this.estadoReserva = estadoReserva;
    this.habitacion = habitacion;
    this.cantNoches = cantNoches;
  }

  public ReservaHabitacion() {
    this.cliente = new Cliente();
    this.cantPersonas = 0;
    this.estadoReserva = Estados.DISPONIBLE;
    this.cantNoches = 0;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }


  public int getCantPersonas() {
    return cantPersonas;
  }

  public void setCantPersonas(int cantPersonas) {
    this.cantPersonas = cantPersonas;
  }

  public Estados getEstadoReserva() {
    return estadoReserva;
  }

  public boolean setEstadoReserva(Estados estadiReserva) {
    java.lang.String[] estados = {"Por_confirmar", "Reservado", "Disponible"};
    for (int i = 0; i < estados.length; i++) {
      if (estado_reserva == Estados.valueOf(estados[i])) {
        this.estadoReserva = estado_reserva;
        return true;
      }
    }
    JOptionPane.showMessageDialog(null, "Tipo de habitacion incorrecto");
    return false;
  }



  public boolean setTipoHabitacion(TipoHabitacion tipo_Tipo_habitacion) {
    java.lang.String[] habitaciones = {"Basica", "Premium", "Deluxe", "Presidencial"};
    for (int i = 0; i < habitaciones.length; i++) {
      if (tipo_Tipo_habitacion == TipoHabitacion.valueOf(habitaciones[i])) {
        this.habitacion = tipo_Tipo_habitacion;
        return true;
      }
    }
    JOptionPane.showMessageDialog(null, "Tipo de habitacion incorrecto");
    return false;
  }

  public int getCantNoches() {
    return cantNoches;
  }

  public void setCantNoches(int cantNoches) {
    this.cantNoches = cantNoches;
  }

  public void desplegarReserva() {
    System.out.println();
    System.out.println("Infromacion de Reserva: ");
    System.out.println();
    System.out.println("Nombre del cliente: " + this.getCliente().getNombre());
    System.out.println("Identificación del cliente: " + this.getCliente().getId());
    System.out.println("Numero de habitacion: " + this.getIdHabitacion());
    System.out.println("Cantidad de personas en habitacion: " + this.getCantPersonas());
    System.out.println("Estado de la reserva: " + this.getEstadoReserva());
    System.out.println();
    System.out.println("------------------------------------------------------------");
  }

  public void cancela_reserva(Estados nuevo_estado) {
    if (this.setEstadoReserva(nuevo_estado)) {
      System.out.println("Cancelacion de reserva exitosa!");
    } else {
      System.out.println("Error: cancelacion no posible!");
    }
  }

  public void desglose() {
    TipoHabitacion tipoHabitacion = getHabitacion();
    int PrecioHabitacion = tipoHabitacion.getPrecio();
    double bruto = (PrecioHabitacion * this.getCantPersonas()) * this.getCantNoches();
    System.out.println("Nombre del cliente:                   " + this.getCliente());
    System.out.println("Cantidad de personas:                 " + this.getCantPersonas());
    System.out.println("Numero de habitacion:                 " + this.getIdHabitacion());
    System.out.println("Tipo habitacion:                      " + this.getHabitacion());
    System.out.println("Cantidad de noches de hospedaje:      " + this.getCantNoches());
    System.out.println();
    System.out.println("Precio por noche:                     " + PrecioHabitacion);
    System.out.println("------------------------------------------------");
    System.out.println();
    System.out.println("A pagar:                              " + bruto);
  }

  public void mostrarFactura() {
    Factura f1 = new Factura(this.getCliente(), this.getCantPersonas(), this.getIdHabitacion(), this.getHabitacion(), this.getCantNoches(), detalleFactura);
    System.out.println(f1.desplegarFactura());
  }
}
