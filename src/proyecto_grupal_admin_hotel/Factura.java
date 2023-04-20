/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupal_admin_hotel;

import javax.swing.*;

/**
 * @author Lenovo
 */
public class Factura {
  private Cliente cliente;
  private int cantPersonas;
  private String string;
  private TipoHabitacion tipoHabitacion;
  private int cantNoches;

  private DetalleFactura detalleFactura;

  public Factura() {
    this.cliente = new Cliente();
    this.cantPersonas = 0;
    this.string = new String();
    this.tipoHabitacion = TipoHabitacion.BASICA;
    this.cantNoches = 0;
  }

  public Factura(Cliente cliente, int cantPersonas, String string, TipoHabitacion tipoHabitacion, int cantNoches, DetalleFactura detalleFactura) {
    this.cliente = cliente;
    this.cantPersonas = cantPersonas;
    this.string = string;
    this.tipoHabitacion = tipoHabitacion;
    this.cantNoches = cantNoches;
    this.detalleFactura = detalleFactura;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Factura setCliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  public java.lang.String getNombreCliente() {
    return getCliente().getNombre();
  }

  public void setNombreCliente(java.lang.String nombreCliente) {
    this.cliente.setNombre(nombreCliente);
  }

  public int getCantPersonas() {
    return cantPersonas;
  }

  public void setCantPersonas(int cantPersonas) {
    this.cantPersonas = cantPersonas;
  }

  public String getReservacionHabitacion() {
    return string;
  }

  public void setReservacionHabitacion(String string) {
    this.string = string;
  }

  public TipoHabitacion getTipoHabitacion() {
    return tipoHabitacion;
  }

  public boolean setTipoHabitacion(TipoHabitacion tipo_Tipo_habitacion) {
    java.lang.String[] habitaciones = {"Basica", "Premium", "Deluxe", "Presidencial"};
    for (int i = 0; i < habitaciones.length; i++) {
      if (tipo_Tipo_habitacion == TipoHabitacion.valueOf(habitaciones[i])) {
        this.tipoHabitacion = tipo_Tipo_habitacion;
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

  public java.lang.String mostrar_Info() {
    return ("\n------------------------------------------------\n"
        + "Nombre del cliente:                   " + this.getNombreCliente() + "\n"
        + "Identificación del cliente:           " + this.getCliente().getId() + "\n"
        + "Cantidad de personas:                 " + this.getCantPersonas() + "\n"
        + "Numero de habitacion:                 " + this.getReservacionHabitacion().getIdHabitacion() + "\n"
        + "Tipo habitacion:                      " + this.getTipoHabitacion() + "\n"
        + "Cantidad de noches de hospedaje:      " + this.getCantNoches() + "\n"
        + "------------------------------------------------\n");
  }

  public java.lang.String desplegarFactura() {
    TipoHabitacion tipoHabitacion = getTipoHabitacion();
    int PrecioHabitacion = tipoHabitacion.getPrecio();
    double bruto = (PrecioHabitacion * this.getCantPersonas()) * this.getCantNoches();
    double IVA = bruto * 0.13;
    double total = bruto + IVA;
    return ("Factura de habitacion: " + this.getReservacionHabitacion() + "\n"
        + "------------------------------------------------\n"
        + "Nombre del cliente:                   " + this.getNombreCliente() + "\n"
        + "Cantidad de personas:                 " + this.getCantPersonas() + "\n"
        + "Numero de habitacion:                 " + this.getReservacionHabitacion().getIdHabitacion() + "\n"
        + "Tipo habitacion:                      " + this.getTipoHabitacion() + "\n"
        + "Cantidad de noches de hospedaje:      " + this.getCantNoches() + "\n"
        + "\n"
        + "Precio por noche:                     " + PrecioHabitacion
        + "\n------------------------------------------------\n"
        + "\n"
        + "A pagar:                              " + bruto + "\n"
        + "IVA:                                  " + IVA + "\n"
        + "\n"
        + "Total a pagar (con IVA):                        " + total
        + "\n------------------------------------------------\n");
  }
}
