package proyecto_grupal_admin_hotel;

import java.util.Objects;

public class Habitacion {
  private String id;
  private boolean disponibilidad;

  private TipoHabitacion tipoHabitacion;

  public Habitacion() {
    this.id = "";
    this.disponibilidad = false;
  }

  public Habitacion(String id, boolean disponibilidad, TipoHabitacion tipoHabitacion) {
    this.id = id;
    this.disponibilidad = disponibilidad;
    this.tipoHabitacion = tipoHabitacion;
  }

  public TipoHabitacion getTipoHabitacion() {
    return tipoHabitacion;
  }

  public Habitacion setTipoHabitacion(TipoHabitacion tipoHabitacion) {
    this.tipoHabitacion = tipoHabitacion;
    return this;
  }

  public String getId() {
    return id;
  }

  public Habitacion setId(String id) {
    this.id = id;
    return this;
  }

  public boolean isDisponibilidad() {
    return disponibilidad;
  }

  public Habitacion setDisponibilidad(boolean disponibilidad) {
    this.disponibilidad = disponibilidad;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Habitacion that = (Habitacion) o;
    return disponibilidad == that.disponibilidad && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, disponibilidad);
  }
}
