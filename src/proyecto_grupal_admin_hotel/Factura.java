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
public class Factura {
    public String nombre_cliente;
    public int cant_personas;
    public int numero_habitacion;
    public Habitaciones tipo_habitacion;
    public int cant_noches;

    public Factura() {
        this.nombre_cliente = "";
        this.cant_personas = 0;
        this.numero_habitacion = 0;
        this.tipo_habitacion = Habitaciones.Basica;
        this.cant_noches = 0;
    }

    public Factura(String nombre_cliente, int cant_personas, int numero_habitacion, Habitaciones tipo_habitacion, int cant_noches) {
        this.nombre_cliente = nombre_cliente;
        this.cant_personas = cant_personas;
        this.numero_habitacion = numero_habitacion;
        this.tipo_habitacion = tipo_habitacion;
        this.cant_noches = cant_noches;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
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

    public String mostrar_Info(){
        return ("\n------------------------------------------------\n"
                + "Nombre del cliente:                   "+ this.getNombre_cliente()+"\n"
                + "Cantidad de personas:                 "+this.getCant_personas()+"\n"
                + "Numero de habitacion:                 "+this.getNumero_habitacion()+"\n"
                + "Tipo habitacion:                      "+this.getTipo_habitacion()+"\n"
                + "Cantidad de noches de hospedaje:      "+this.getCant_noches()+"\n"
                + "------------------------------------------------\n");
    }

    public String desplegar_factura(){
        Habitaciones habitacion = getTipo_habitacion();
        int PrecioHabitacion = habitacion.getPrecio();
        double bruto = (PrecioHabitacion*this.getCant_personas())*this.getCant_noches();
        double IVA = bruto*0.13;
        double total = bruto+IVA;
        return ("Factura de habitacion: " + this.getNumero_habitacion()+"\n"
                + "------------------------------------------------\n"
                + "Nombre del cliente:                   "+ this.getNombre_cliente()+"\n"
                + "Cantidad de personas:                 "+this.getCant_personas()+"\n"
                + "Numero de habitacion:                 "+this.getNumero_habitacion()+"\n"
                + "Tipo habitacion:                      "+this.getTipo_habitacion()+"\n"
                + "Cantidad de noches de hospedaje:      "+this.getCant_noches()+"\n"
                + "\n"
                + "Precio por noche:                     "+PrecioHabitacion
                + "\n------------------------------------------------\n"
                + "\n"
                + "A pagar:                              "+bruto+"\n"
                + "IVA:                                  "+IVA+"\n"
                + "\n"
                + "Total a pagar (con IVA):                        "+total
                +"\n------------------------------------------------\n");
    }


}
