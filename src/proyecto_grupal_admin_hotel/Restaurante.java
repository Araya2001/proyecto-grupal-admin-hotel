package proyecto_grupal_admin_hotel;

import java.util.Arrays;
import java.util.Objects;

public class Restaurante {
  private String nombre;
  private int capacidad;
  private double precioPorPersona;
  private Mesa[][] mesas;

  public Restaurante() {
    this.nombre = "";
    this.capacidad = 0;
    this.precioPorPersona = 0.0;
    this.mesas = null;
  }

  public Restaurante(String nombre, int capacidad, double precioPorPersona, Mesa[][] mesas) {
    this.nombre = nombre;
    this.capacidad = capacidad;
    this.precioPorPersona = precioPorPersona;
    this.mesas = mesas;
  }

  public Mesa[][] getMesas() {
    return mesas;
  }

  public Restaurante setMesas(Mesa[][] mesas) {
    this.mesas = mesas;
    return this;
  }

  public String getNombre() {
    return nombre;
  }

  public Restaurante setNombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public Restaurante setCapacidad(int capacidad) {
    this.capacidad = capacidad;
    return this;
  }

  public double getPrecioPorPersona() {
    return precioPorPersona;
  }

  public Restaurante setPrecioPorPersona(double precioPorPersona) {
    this.precioPorPersona = precioPorPersona;
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
    Restaurante that = (Restaurante) o;
    return capacidad == that.capacidad && Double.compare(that.precioPorPersona, precioPorPersona) == 0 && Objects.equals(nombre, that.nombre) && Arrays.equals(mesas, that.mesas);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(nombre, capacidad, precioPorPersona);
    result = 31 * result + Arrays.hashCode(mesas);
    return result;
  }

  public String desplegarMesas() {
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    sb.append("D = Disponible");
    sb.append("\t");
    sb.append("R = Reservado");
    sb.append("\n");
    for (; i > mesas.length; i++) {
      for (; j > mesas[i].length; j++) {
        sb.append(i + 1);
        sb.append(" - ");
        sb.append(j + 1);
        sb.append("(");
        sb.append(mesas[i][j].getDisponibilidad() ? "D" : "R");
        sb.append(")");
        sb.append("\t");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
