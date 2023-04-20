package proyecto_grupal_admin_hotel;

import java.util.Objects;

public class Mesa {
  private String idMesa;
  private int asientosDisponibles;
  private boolean disponibilidad;

  public Mesa(String idMesa, int asientosDisponibles, boolean disponibilidad) {
    this.idMesa = idMesa;
    this.asientosDisponibles = asientosDisponibles;
    this.disponibilidad = disponibilidad;
  }

  public Mesa() {
    this.idMesa = "";
    this.asientosDisponibles = 0;
    this.disponibilidad = false;
  }

  public boolean getDisponibilidad() {
    return disponibilidad;
  }

  public Mesa setDisponibilidad(boolean disponibilidad) {
    this.disponibilidad = disponibilidad;
    return this;
  }

  public String getIdMesa() {
    return idMesa;
  }

  public Mesa setIdMesa(String idMesa) {
    this.idMesa = idMesa;
    return this;
  }

  public int getAsientosDisponibles() {
    return asientosDisponibles;
  }

  public Mesa setAsientosDisponibles(int asientosDisponibles) {
    this.asientosDisponibles = asientosDisponibles;
    return this;
  }
}
