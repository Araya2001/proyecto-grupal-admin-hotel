package proyecto_grupal_admin_hotel;

import java.util.Objects;

public class ReservaRestaurante {
  private Cliente cliente;
  private String string;
  private int cuposReservados;
  private Restaurante restaurante;
  private TipoComida tipoComida;
  private Mesa mesa;
  private Factura factura;
  private boolean esConfirmada;

  public Factura getFactura() {
    return factura;
  }

  public ReservaRestaurante setFactura(Factura factura) {
    this.factura = factura;
    return this;
  }

  public ReservaRestaurante(Cliente cliente, String string, int cuposReservados, Restaurante restaurante, TipoComida tipoComida, Mesa mesa, Factura factura, boolean esConfirmada) {
    this.cliente = cliente;
    this.string = string;
    this.cuposReservados = cuposReservados;
    this.restaurante = restaurante;
    this.tipoComida = tipoComida;
    this.mesa = mesa;
    this.factura = factura;
    this.esConfirmada = esConfirmada;
  }

  public ReservaRestaurante() {
    this.cliente = new Cliente();
    this.string = new String();
    this.cuposReservados = 0;
    this.restaurante = new Restaurante();
    this.tipoComida = null;
    this.mesa = new Mesa();
    this.factura = new Factura();
    this.esConfirmada = false;
  }

  public boolean isEsConfirmada() {
    return esConfirmada;
  }

  public ReservaRestaurante setEsConfirmada(boolean esConfirmada) {
    this.esConfirmada = esConfirmada;
    return this;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public ReservaRestaurante setCliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  public String getReservacionHabitacion() {
    return string;
  }

  public ReservaRestaurante setReservacionHabitacion(String string) {
    this.string = string;
    return this;
  }

  public int getCuposReservados() {
    return cuposReservados;
  }

  public ReservaRestaurante setCuposReservados(int cuposReservados) {
    this.cuposReservados = cuposReservados;
    return this;
  }

  public Restaurante getRestaurante() {
    return restaurante;
  }

  public ReservaRestaurante setRestaurante(Restaurante restaurante) {
    this.restaurante = restaurante;
    return this;
  }

  public TipoComida getTipoComida() {
    return tipoComida;
  }

  public ReservaRestaurante setTipoComida(TipoComida tipoComida) {
    this.tipoComida = tipoComida;
    return this;
  }

  public Mesa getMesa() {
    return mesa;
  }

  public ReservaRestaurante setMesa(Mesa mesa) {
    this.mesa = mesa;
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
    ReservaRestaurante that = (ReservaRestaurante) o;
    return string == that.string && cuposReservados == that.cuposReservados && esConfirmada == that.esConfirmada && Objects.equals(cliente, that.cliente) && Objects.equals(restaurante, that.restaurante) && tipoComida == that.tipoComida && Objects.equals(mesa, that.mesa) && Objects.equals(factura, that.factura);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cliente, string, cuposReservados, restaurante, tipoComida, mesa, factura, esConfirmada);
  }

  public java.lang.String desplegarInfo() {
    StringBuilder sb = new StringBuilder();
    sb.append("Información Reserva Restaurante");
    sb.append("\n");
    sb.append("Restaurante: ");
    sb.append(this.restaurante.getNombre());
    sb.append("\n");
    sb.append("Nombre cliente: ");
    sb.append(this.cliente);
    sb.append("\n");
    sb.append("Mesa reservada: ");
    sb.append(this.mesa.getIdMesa());
    sb.append("\n");
    sb.append("Estado de reserva: ");
    sb.append(this.esConfirmada);
    sb.append("\n");
    sb.append("Tipo de comida:");
    sb.append(this.tipoComida.getValor());
    sb.append("\n");
    sb.append("Cantidad de acompañantes: ");
    sb.append(this.cuposReservados);
    sb.append("\n");
    return sb.toString();
  }

  public java.lang.String mostrarFactura() {
    return this.getFactura().desplegarFactura();
  }

  public void cancelarReserva() {
    setEsConfirmada(false);
    this.mesa.setDisponibilidad(true);
    this.mesa = new Mesa()
        .setIdMesa("MESA CANCELADA")
        .setDisponibilidad(false)
        .setAsientosDisponibles(0);
  }
}
