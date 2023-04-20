package proyecto_grupal_admin_hotel;

import java.util.Arrays;

public class ReservaRestaurante {
  private String nombreCliente;
  private int cuposReservados;
  private Restaurante restaurante;
  private TipoComida tipoComida;
  private Mesa[] mesas;
  private boolean esConfirmada;
  private boolean esCancelada;
  private DetalleRestaurante[] detalleRestaurante;

  public ReservaRestaurante(String nombreCliente, int cuposReservados, Restaurante restaurante, TipoComida tipoComida, Mesa[] mesas, boolean esConfirmada, boolean esCancelada) {
    this.nombreCliente = nombreCliente;
    this.cuposReservados = cuposReservados;
    this.restaurante = restaurante;
    this.tipoComida = tipoComida;
    this.mesas = mesas;
    this.esConfirmada = esConfirmada;
    this.esCancelada = esCancelada;
  }

  public ReservaRestaurante() {
  }

  public boolean setEsCancelada() {
    return esCancelada;
  }

  public ReservaRestaurante setEsCancelada(boolean esCancelada) {
    this.esCancelada = esCancelada;
    return this;
  }

  public DetalleRestaurante[] getDetalleRestaurante() {
    return detalleRestaurante;
  }

  public ReservaRestaurante setDetalleRestaurante(DetalleRestaurante[] detalleRestaurante) {
    this.detalleRestaurante = detalleRestaurante;
    return this;
  }

  public boolean isEsConfirmada() {
    return esConfirmada;
  }

  public ReservaRestaurante setEsConfirmada(boolean esConfirmada) {
    this.esConfirmada = esConfirmada;
    return this;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public ReservaRestaurante setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
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

  public Mesa[] getMesas() {
    return mesas;
  }

  public ReservaRestaurante setMesas(Mesa[] mesas) {
    this.mesas = mesas;
    return this;
  }

  public String mostrarFactura() {
    Double montoSubtotal = 0.0;
    Double montoTotal = 0.0;
    Double montoPorUnidad;
    Double iva = 0.0;
    StringBuilder sb = new StringBuilder();
    sb.append("Factura de restaurante: ");
    sb.append(this.restaurante.getNombre());
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Nombre del cliente: ");
    sb.append(this.nombreCliente);
    sb.append("\n");
    sb.append("Tipo de comida: ");
    sb.append(this.tipoComida.getValor());
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Detalle comprobante: ");
    sb.append("\n");
    sb.append("Comentario\t\tCantidad\tMonto\tSubtotal\tTotal (IVA)");
    sb.append("\n");
    for (int i = 0; i < this.detalleRestaurante.length; i++) {
      montoPorUnidad = this.detalleRestaurante[i].getMonto() * detalleRestaurante[i].getCantidad();
      sb.append(this.detalleRestaurante[i].getComentario());
      sb.append("\t\t");
      sb.append(this.detalleRestaurante[i].getCantidad());
      sb.append("\t");
      sb.append(this.detalleRestaurante[i].getMonto());
      sb.append("\t");
      sb.append(montoPorUnidad);
      sb.append("\t");
      sb.append(montoPorUnidad * 1.13);
      sb.append("\n");
      montoSubtotal += montoPorUnidad;
      montoTotal += montoPorUnidad * 1.13;
      iva += montoPorUnidad * 0.13;
    }
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("IVA: ");
    sb.append(iva);
    sb.append("\n");
    sb.append("Subtotal: ");
    sb.append(montoSubtotal);
    sb.append("\n");
    sb.append("Total: ");
    sb.append(montoTotal);
    sb.append("\n");
    return sb.toString();
  }

  public String desplegarInformacion() {
    StringBuilder sb = new StringBuilder();
    sb.append("Información de reserva de restaurante");
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Nombre Restaurante: ");
    sb.append(this.restaurante.getNombre());
    sb.append("\n");
    sb.append("Nombre cliente: ");
    sb.append(this.getNombreCliente());
    sb.append("\n");
    sb.append("Cantidad de acompañantes: ");
    sb.append(this.getCuposReservados());
    sb.append("\n");
    sb.append("Tipo de comida: ");
    sb.append(this.tipoComida.getValor());
    sb.append("\n");
    sb.append("Mesas: ");
    for (int i = 0; i < this.mesas.length; i++) {
      sb.append(this.mesas[i].getIdMesa());
      if (i != this.mesas.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("\n");
    sb.append("Estado reserva: ");
    sb.append(this.esConfirmada ? "CONFIRMADA" : this.esCancelada ? "CANCELADA" : "SIN CONFIRMAR");
    sb.append("\n");
    return sb.toString();
  }

  public String desglose() {
    Double montoSubtotal = 0.0;
    Double montoPorUnidad;
    StringBuilder sb = new StringBuilder();
    sb.append("Desglose: ");
    sb.append(this.restaurante.getNombre());
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Nombre del cliente: ");
    sb.append(this.nombreCliente);
    sb.append("\n");
    sb.append("Tipo de comida: ");
    sb.append(this.tipoComida.getValor());
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Detalle: ");
    sb.append("\n");
    sb.append("Comentario\t\tCantidad\tMonto\tSubtotal");
    sb.append("\n");
    for (int i = 0; i < this.detalleRestaurante.length; i++) {
      montoPorUnidad = this.detalleRestaurante[i].getMonto() * detalleRestaurante[i].getCantidad();
      sb.append(this.detalleRestaurante[i].getComentario());
      sb.append("\t\t");
      sb.append(this.detalleRestaurante[i].getCantidad());
      sb.append("\t");
      sb.append(this.detalleRestaurante[i].getMonto());
      sb.append("\t");
      sb.append(montoPorUnidad);
      sb.append("\n");
      montoSubtotal += montoPorUnidad;
    }
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Subtotal: ");
    sb.append(montoSubtotal);
    sb.append("\n");
    sb.append("Cantidad de Acompañantes: ");
    sb.append(this.cuposReservados);
    sb.append("\n");
    sb.append("Monto por persona (Sugerido): ");
    sb.append(montoSubtotal / this.cuposReservados);
    sb.append("\n");
    return sb.toString();
  }

  public void cancelarReserva() {
    setEsConfirmada(false);
    setEsCancelada(true);
    for (int i = 0; i < this.mesas.length; i++) {
      this.mesas[i].setDisponibilidad(true);
    }
    this.mesas = new Mesa[1];
    mesas[0] = new Mesa()
        .setIdMesa("MESA CANCELADA")
        .setDisponibilidad(false)
        .setAsientosDisponibles(0);
  }

  public void agregarCobroFactura(double cantidad, double monto, String comentario) {
    DetalleRestaurante[] nuevoDetalle = new DetalleRestaurante[this.detalleRestaurante.length + 1];
    for (int i = 0; i < this.detalleRestaurante.length; i++) {
      nuevoDetalle[i] = this.detalleRestaurante[i];
    }
    nuevoDetalle[this.detalleRestaurante.length] = new DetalleRestaurante()
        .setCantidad(cantidad)
        .setMonto(monto)
        .setComentario(comentario);
    this.detalleRestaurante = nuevoDetalle;
  }

  @Override
  public String toString() {
    return "ReservaRestaurante{" +
        "nombreCliente='" + nombreCliente + '\'' +
        ", cuposReservados=" + cuposReservados +
        ", restaurante=" + restaurante +
        ", tipoComida=" + tipoComida +
        ", mesa=" + mesas +
        ", esConfirmada=" + esConfirmada +
        ", detalleRestaurante=" + Arrays.toString(detalleRestaurante) +
        '}';
  }
}
