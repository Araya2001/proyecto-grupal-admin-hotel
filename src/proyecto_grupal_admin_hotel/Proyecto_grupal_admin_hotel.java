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
      return Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opciones: \n"
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
    }

    public static void main(java.lang.String[] args) {
        ReservaRestaurante[] reservaRestaurantes;
        String[] reservaHabitaciones;



        String r1 = new ReservaHabitacion();
        String r2 = new ReservaHabitacion("Alejandro Jimenez", 101, 4, Estados.DISPONIBLE, TipoHabitacion.DELUXE, 4);

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

}
