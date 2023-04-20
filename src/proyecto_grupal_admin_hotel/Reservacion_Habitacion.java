/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupal_admin_hotel;

import javax.swing.*;
/**
 *
 * @author Lenovo
 */
public class Reservacion_Habitacion {
    public String nombre_cliente;
    public int numero_habitacion;
    public int cant_personas;
    public Estados estado_reserva;
    public Habitaciones tipo_habitacion;
    public int cant_noches;

    public Reservacion_Habitacion(String nombre_cliente, int numero_habitacion, int cant_personas, Estados estado_reserva, Habitaciones tipo_habitacion, int cant_noches) {
        this.nombre_cliente = nombre_cliente;
        this.numero_habitacion = numero_habitacion;
        this.cant_personas = cant_personas;
        this.estado_reserva = estado_reserva;
        this.tipo_habitacion = tipo_habitacion;
        this.cant_noches = cant_noches;
    }

    public Reservacion_Habitacion() {
        this.nombre_cliente = "";
        this.numero_habitacion = 0;
        this.cant_personas = 0;
        this.estado_reserva = Estados.Disponible;
        this.tipo_habitacion = Habitaciones.Basica;
        this.cant_noches = 0;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public Estados getEstado_reserva() {
        return estado_reserva;
    }

    public boolean setEstado_reserva(Estados estado_reserva) {
        String[] estados = {"Por_confirmar", "Reservado","Disponible"};
        for (int i=0; i<estados.length; i++){
            if (estado_reserva == Estados.valueOf(estados[i])){
                this.estado_reserva = estado_reserva;
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,"Tipo de habitacion incorrecto");
        return false;
    }

    public Habitaciones getTipo_habitacion() {
        return tipo_habitacion;
    }

    public boolean setTipo_habitacion(Habitaciones tipo_habitacion) {
        String[] habitaciones = {"Basica","Premium","Deluxe","Presidencial"};
        for (int i=0; i<habitaciones.length; i++){
            if (tipo_habitacion == Habitaciones.valueOf(habitaciones[i])){
                this.tipo_habitacion = tipo_habitacion;
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,"Tipo de habitacion incorrecto");
        return false;
    }

    public int getCant_noches() {
        return cant_noches;
    }

    public void setCant_noches(int cant_noches) {
        this.cant_noches = cant_noches;
    }

    public void desplegar_reserva(){
        System.out.println();
        System.out.println("Infromacion de Reserva: ");
        System.out.println();
        System.out.println("Nombre del cliente: "+this.getNombre_cliente());
        System.out.println("Numero de habitacion: "+this.getNumero_habitacion());
        System.out.println("Cantidad de personas en habitacion: "+this.getCant_personas());
        System.out.println("Estado de la reserva: "+this.getEstado_reserva());
        System.out.println();
        System.out.println("------------------------------------------------------------");
    }

    public void cancela_reserva(Estados nuevo_estado){
        if (this.setEstado_reserva(nuevo_estado)){
            System.out.println("Cancelacion de reserva exitosa!");
        }else{
            System.out.println("Error: cancelacion no posible!");
        }
    }

    public void desglose(){
        Habitaciones habitacion = getTipo_habitacion();
        int PrecioHabitacion = habitacion.getPrecio();
        double bruto = (PrecioHabitacion*this.getCant_personas())*this.getCant_noches();
        System.out.println("Nombre del cliente:                   "+ this.getNombre_cliente());
        System.out.println("Cantidad de personas:                 "+this.getCant_personas());
        System.out.println("Numero de habitacion:                 "+this.getNumero_habitacion());
        System.out.println("Tipo habitacion:                      "+this.getTipo_habitacion());
        System.out.println("Cantidad de noches de hospedaje:      "+this.getCant_noches());
        System.out.println();
        System.out.println("Precio por noche:                     "+PrecioHabitacion);
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("A pagar:                              "+bruto);
    }

    public void mostrarFactura(){
        Factura f1 = new Factura(this.getNombre_cliente(), this.getCant_personas(), this.getNumero_habitacion(), this.getTipo_habitacion(), this.getCant_noches());
        System.out.println(f1.desplegar_factura());
    }
}
