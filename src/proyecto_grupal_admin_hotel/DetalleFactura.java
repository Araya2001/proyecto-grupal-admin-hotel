package proyecto_grupal_admin_hotel;

import java.util.Objects;

public class DetalleFactura {
  private Double montoUnitario;
  private Double unidades;
  private String comentario;

  public DetalleFactura(Double montoUnitario, Double unidades, String comentario) {
    this.montoUnitario = montoUnitario;
    this.unidades = unidades;
    this.comentario = comentario;
  }

  public DetalleFactura() {
    this.montoUnitario = 0.0;
    this.unidades = 0.0;
    this.comentario = "";
  }

  public Double getMontoUnitario() {
    return montoUnitario;
  }

  public DetalleFactura setMontoUnitario(Double montoUnitario) {
    this.montoUnitario = montoUnitario;
    return this;
  }

  public Double getUnidades() {
    return unidades;
  }

  public DetalleFactura setUnidades(Double unidades) {
    this.unidades = unidades;
    return this;
  }

  public String getComentario() {
    return comentario;
  }

  public DetalleFactura setComentario(String comentario) {
    this.comentario = comentario;
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
    DetalleFactura that = (DetalleFactura) o;
    return Objects.equals(montoUnitario, that.montoUnitario) && Objects.equals(unidades, that.unidades) && Objects.equals(comentario, that.comentario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(montoUnitario, unidades, comentario);
  }
}
